import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { AuthService } from './service/auth.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AtendimentoGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    // Check if the user is authenticated
    const isAuthenticated = this.authService.isAuthenticated();

    if (state.url === '/home') {
      // If the current route is 'home', redirect to '/atendimentos' if authenticated
      if (isAuthenticated) {
        return this.router.parseUrl('/atendimentos');
      } else {
        return true; // Allow activation if not authenticated
      }
    } else {
      // For other routes, return whether the user is authenticated or not
      if (isAuthenticated) {
        return true;
      } else {
        return this.router.parseUrl('/login');
      }
    }
  }
}
