import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './service/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AtendimentoGuard {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate(): boolean {
    const isAuthenticated = this.authService.isAuthenticated();
    const url = this.router.url;

    // Se o usuário estiver autenticado, permita o acesso à rota solicitada
    if (isAuthenticated) {
      return true;
    }

    // Se o usuário não estiver autenticado e tentar acessar a página de login, permita o acesso
    if (url === '/login') {
      return true;
    }

    // Se o usuário não estiver autenticado e tentar acessar qualquer outra página, redirecione-o para a página de login
    this.router.navigate(['/login']);
    return false;
  }

}

