import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-atendimentos-form',
  templateUrl: './atendimentos-form.component.html',
  styleUrl: './atendimentos-form.component.css'
})
export class AtendimentosFormComponent {
  atendimentosForm: FormGroup;

  constructor() {
    this.atendimentosForm = new FormGroup({
  
    });
  }

}