import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  constructor(private route: Router) { }

  ativo: boolean = true;

  rotaServicos() {
    this.route.navigate(['/servicos']);
  }

  rotaSobre() {
    this.route.navigate(['/sobre']);
  }

}
