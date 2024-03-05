// import { HttpEvent, HttpHandler, HttpInterceptor, HttpInterceptorFn, HttpParams, HttpRequest } from '@angular/common/http';
// import { Injectable } from '@angular/core';

// import { Observable, exhaustMap, take } from 'rxjs';

// import { AuthService } from '../service/auth.service';

// export const authInterceptor: HttpInterceptorFn = (req, next) => {
//   return next(req);
// };

// @Injectable()
// export class AuthInterceptor implements HttpInterceptor {

//   constructor(private service: AuthService) {}

//   intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
//     return this.service.usuario.pipe(
//       take(1),
//       exhaustMap(user => {
//         console.log(user);

//         if (!user) {
//           console.log(request);
//           return next.handle(request);
//         }
//         const requestModificado = request.clone({
//           params: new HttpParams().set('auth', user.token!)
//         });

//         console.log(requestModificado);
//         return next.handle(requestModificado);
//       }
//       ),
//     );
//   }
// }

import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(
    private authService: AuthService,
    private route: Router
  ) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // Verifica se a requisição está indo para a rota de login
    if (req.url.includes('/login')) {
      return next.handle(req);
    }

    // Verifica se o usuário está autenticado
    if (this.authService.isAuthenticated()) {
      // Clona a requisição e adiciona o token de autorização no cabeçalho
      const authReq = req.clone({
        setHeaders: {
          Authorization: `Bearer ${this.authService.getToken()}`
        }
      });

      console.log('Interceptor: ', authReq);
      return next.handle(authReq);
    } else {
      this.route.navigate(['/login']);
      return next.handle(req);
    }
  }
}

