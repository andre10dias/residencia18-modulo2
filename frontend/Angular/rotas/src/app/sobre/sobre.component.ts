import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sobre',
  templateUrl: './sobre.component.html',
  styleUrl: './sobre.component.css'
})
export class SobreComponent {

  constructor(private route: Router) { }

  ativo: boolean = false;

  rotaHome() {
    this.route.navigate(['/home']);
  }

  rotaServicos() {
    this.route.navigate(['/servicos']);
  }

}
