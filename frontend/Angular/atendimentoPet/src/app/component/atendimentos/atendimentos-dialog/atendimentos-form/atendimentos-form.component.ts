import { Component, EventEmitter, Output } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-atendimentos-form',
  templateUrl: './atendimentos-form.component.html',
  styleUrl: './atendimentos-form.component.css'
})
export class AtendimentosFormComponent {
  @Output() tituloForm = new EventEmitter<string>();
  titulo: string = 'Cadastrar atendimentos';

  atendimentosForm: FormGroup;

  constructor() {
    this.enviarTitulo();
    this.atendimentosForm = new FormGroup({
  
    });
  }

  enviarTitulo() {
    console.log('form: ' + this.titulo);
    this.tituloForm.emit(this.titulo);
  }

}