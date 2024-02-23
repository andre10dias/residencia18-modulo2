import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrl: './nav-bar.component.css'
})
export class NavBarComponent {

  constructor(private route: Router) { }

  rotaHome() {
    this.route.navigate(['/home']);
  }

  rotaAtendimentos() {
    this.route.navigate(['/atendimentos']);
  }

}
