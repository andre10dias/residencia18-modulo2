import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-form-reativo',
  templateUrl: './form-reativo.component.html',
  styleUrl: './form-reativo.component.css'
})
export class FormReativoComponent {
  form: FormGroup;

  constructor() {
    this.form = new FormGroup({
      'estacao': new FormControl(null, Validators.required),
      'email': new FormControl(null, [
        Validators.required,
        Validators.email
      ]),
      'localizacao': new FormControl(null, Validators.required),
      'status': new FormControl(null)
    });
  }

  onSubmit() {
    console.log('form: ', this.form);
    console.log('form.value: ', this.form.value);
  }
}