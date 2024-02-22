import { Component } from '@angular/core';

@Component({
  selector: 'app-atendimentos',
  templateUrl: './atendimentos.component.html',
  styleUrl: './atendimentos.component.css'
})
export class AtendimentosComponent {
  list: boolean = true;
  form: boolean = false;
}
