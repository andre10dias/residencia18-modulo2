import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-servicos',
  templateUrl: './servicos.component.html',
  styleUrl: './servicos.component.css'
})
export class ServicosComponent {

  constructor(private route: Router) { }

  ativo: boolean = false;

  rotaHome() {
    this.route.navigate(['/home']);
  }

  rotaSobre() {
    this.route.navigate(['/sobre']);
  }

}
