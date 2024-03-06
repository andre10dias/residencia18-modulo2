import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { BehaviorSubject, tap } from 'rxjs';

import { Usuario } from '../model/usuario/usuario';
import { AuthResponse } from '../model/auth/auth-response';
import { FirebaseCredentials } from '../model/firebase/firebase-credentials';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  fire: FirebaseCredentials = new FirebaseCredentials();
  baseAuth: string = `${this.fire.baseAuth}/accounts`;
  apiKey: string = this.fire.apiKey;

  usuario: BehaviorSubject<Usuario> = new BehaviorSubject<Usuario>(new Usuario('', '', '', new Date()));

  private tokenExpirationTimer: any;

  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  signupUser(email: string, password: string) {
   return this.http.post<AuthResponse>(`${this.baseAuth}:signUp?key=${this.apiKey}`, 
   {
      email: email,
      password: password,
      returnSecureToken: true
   }).pipe(
      tap(data => {
        const expiracaoData = new Date(new Date().getTime() + +data.expiresIn * 1000);
        const usuario = new Usuario(
          data.email,
          data.localId,
          data.idToken,
          expiracaoData
        );

        this.usuario.next(usuario);
        localStorage.setItem('user', JSON.stringify(usuario));
      })
   );
  }

  loginUser(email: string, password: string) {
    return this.http.post<AuthResponse>(`${this.baseAuth}:signInWithPassword?key=${this.apiKey}`,
    {
      email: email,
      password: password,
      returnSecureToken: true
   }).pipe(
    tap(data => {
      const expiracaoData = new Date(new Date().getTime() + +data.expiresIn * 1000);

      const usuario = new Usuario(
        data.email,
        data.localId,
        data.idToken,
        expiracaoData
      );

      this.usuario.next(usuario);
      console.log('[AuthService] loginUser: ', usuario);
      localStorage.setItem('user', JSON.stringify(usuario));
    }),
   );
  }

  autoLogin() {
    const userData: {
      email: string;
      id: string;
      _token: string;
      _tokenExpirationDate: string;
    } = JSON.parse(localStorage.getItem('user') || '{}');

    if (!userData.email || !userData._token || !userData._tokenExpirationDate) {
      return; // Não há usuário autenticado armazenado localmente
    }

    const loadedUser = new Usuario(
      userData.email,
      userData.id,
      userData._token,
      new Date(userData._tokenExpirationDate)
    );

    if (loadedUser.token) {
      this.usuario.next(loadedUser);
      const expirationDuration = new Date(userData._tokenExpirationDate).getTime() - new Date().getTime();
      this.autoLogout(expirationDuration); // Opção: Implemente autoLogout para deslogar automaticamente após o tempo de expiração
    }
  }

  autoLogout(expirationDuration: number) {
    this.tokenExpirationTimer = setTimeout(() => {
      this.logout();
    }, expirationDuration);
  }
  
  clearLogoutTimer() {
    if (this.tokenExpirationTimer) {
      clearTimeout(this.tokenExpirationTimer);
      this.tokenExpirationTimer = null;
    }
  }

  logout() {
    localStorage.removeItem('user');
    this.usuario.next(new Usuario('', '', '', new Date()));
    this.router.navigate(['/login']);
    this.clearLogoutTimer();
  }

  isAuthenticated(): boolean {
    // const user: Usuario = this.usuario.value;
    // return user.token !== this.user.token || !this.usuario.token ? false : true;
    // console.log('[AuthService] isAuthenticated: ', this.usuario.value);
    const user: Usuario | null = this.usuario.value;
    return user !== null && user.token !== null && user.token !== undefined;
  }

  getToken(): string | null {
    const user: Usuario = this.usuario.value;
    return user.token;
  }
  
}
