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
  baseUrl: string = `${this.fire.baseUrl}/auth`;
  apiKey: string = this.fire.apiKey;

  usuario: BehaviorSubject<Usuario> = new BehaviorSubject<Usuario>(new Usuario('', '', '', new Date()));

  constructor(private http: HttpClient) { }

  signupUser(email: string, password: string) {
   return this.http.post<AuthResponse>('https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=[suachaveaqui]', 
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
        localStorage.setItem('userData', JSON.stringify(usuario));
      })
   );
  }

  loginUser(email: string, password: string) {
    return this.http.post<AuthResponse>('https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyBbHrkiG6nZlw_1KEtq9senY33hAHhRz2c',
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
      localStorage.setItem('userData', JSON.stringify(usuario));
    }),
   );
  }

  autoLogin() {
    const userData :{
      email: string;
      id: string;
      _token: string;
      _tokenExpirationDate: string;
    
    } = JSON.parse(localStorage.getItem('userData') as string);

    if(!userData) {
      return;
    }

    const loadedUser = new Usuario(
      userData.email,
      userData.id,
      userData._token,
      new Date(userData._tokenExpirationDate)
    );

    if(loadedUser.token) {
      this.usuario.next(loadedUser);
    }
  }

  logout() {
    this.usuario.next(new Usuario('', '', '', new Date()));
  }
  
}
