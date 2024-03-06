import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpParams, HttpRequest } from '@angular/common/http';
import { Observable, exhaustMap, take } from 'rxjs';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private service: AuthService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    return this.service.usuario.pipe(
      take(1),
      exhaustMap(usuario => {
        if(!usuario){
          return next.handle(request);
        }
        const requestModificado = request.clone({
          params: new HttpParams().set('auth', usuario.token!)
        });
        return next.handle(requestModificado);
      }
      ),
    );
  }
}
