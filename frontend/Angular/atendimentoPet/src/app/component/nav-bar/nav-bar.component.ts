import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrl: './nav-bar.component.css'
})
export class NavBarComponent {

  constructor(
    private route: Router,
    private service: AuthService
  ) { }

  rotaHome() {
    this.route.navigate(['/home']);
  }

  rotaAtendimentos() {
    this.route.navigate(['/atendimentos']);
  }

  sair() {
    localStorage.clear();
    this.service.logout();
    this.route.navigate(['/login']);
  }

}
