import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { BehaviorSubject, tap } from 'rxjs';

import { Usuario } from '../model/usuario/usuario';
import { AuthResponse } from '../model/auth/auth-response';
import { FirebaseCredentials } from '../model/firebase/firebase-credentials';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  fire: FirebaseCredentials = new FirebaseCredentials();
  baseAuth: string = `${this.fire.baseAuth}/accounts`;
  apiKey: string = this.fire.apiKey;

  usuario: BehaviorSubject<Usuario> = new BehaviorSubject<Usuario>(new Usuario('', '', '', new Date()));

  constructor(private http: HttpClient) { }

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
      localStorage.setItem('user', JSON.stringify(usuario));
    }),
   );
  }

  autoLogin() {
    const user :{
      email: string;
      id: string;
      _token: string;
      _tokenExpirationDate: string;
    
    } = JSON.parse(localStorage.getItem('user') as string);

    if(!user) {
      return;
    }

    const loadedUser = new Usuario(
      user.email,
      user.id,
      user._token,
      new Date(user._tokenExpirationDate)
    );

    if(loadedUser.token) {
      this.usuario.next(loadedUser);
    }
  }

  logout() {
    this.usuario.next(new Usuario('', '', '', new Date()));
  }

  isAuthenticated(): boolean {
    const user: Usuario = this.usuario.value;
    return user.token !== this.usuario.token || !this.usuario.token ? false : true;
  }

  getToken(): string | null {
    const user: Usuario = this.usuario.value;
    return user.token;
  }
  
}
