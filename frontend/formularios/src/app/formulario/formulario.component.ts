import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css'
})
export class FormularioComponent {
  @ViewChild('form') form!: NgForm | undefined;

  onSubmit(form: NgForm) {
    let { email, senha } = form.value;
    console.log('E-mail: ', email, 'Senha:', senha);
  }
}
