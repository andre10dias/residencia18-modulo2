import { Component, EventEmitter, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-atendimentos-form',
  templateUrl: './atendimentos-form.component.html',
  styleUrl: './atendimentos-form.component.css'
})
export class AtendimentosFormComponent {
  atendimentosForm: FormGroup;

  constructor() {
    this.atendimentosForm = new FormGroup({
      'nomeTutor': new FormControl(null, Validators.required),
      'nomePet': new FormControl(null, Validators.required),
      'data': new FormControl(null, Validators.required),
      'tipo': new FormControl(null, Validators.required),
      'raca': new FormControl(null, Validators.required),
      'observacao': new FormControl(null, Validators.required)
    });
  }

}