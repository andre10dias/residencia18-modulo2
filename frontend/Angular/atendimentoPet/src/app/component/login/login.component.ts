import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import {
  MatSnackBar,
  MatSnackBarAction,
  MatSnackBarActions,
  MatSnackBarLabel,
  MatSnackBarRef,
} from '@angular/material/snack-bar';

import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  snackBarDuration = 3000;
  erro: string = '';

  loginForm: FormGroup;
  mensagem: string = '';

  modoLogin = true;
  estaCarregando = false;
  temErro:boolean = false;

  constructor(
    private service: AuthService,
    private router: Router,
    private snackBar: MatSnackBar
  ) {
    this.loginForm = new FormGroup({
      'senha': new FormControl(null, [
        Validators.required,
        Validators.minLength(4)
      ]),
      'email': new FormControl(null, [
        Validators.required,
        Validators.email
      ]),
    });
  }

  onTrocarModo() {
    this.modoLogin = !this.modoLogin;
  }

  onSubmit(){
    if(!this.loginForm.valid){
      return;
    }

    const {email, senha} = this.loginForm.value;

    this.estaCarregando = true;

    // console.log(email, senha);
    if(this.modoLogin) {
      console.log('modoLogin');
      this.service.loginUser(email, senha).subscribe({
        next: (data) => {
          console.log('[OnSubmit] loginUser - login component: ', data);
          this.estaCarregando = false;
          this.temErro = false;
          this.router.navigate(['/home']);
        },
        error: (error) => {
          switch(error.error.error.message){
            case 'INVALID_LOGIN_CREDENTIALS':
              this.erro = 'E-mail ou senha inválidos.';
              break;
            default:
              this.erro = 'Ocorreu um erro ao cadastrar o usuário.'
              break;
          }

          if (this.erro) {
            this.openSnackBar();
          }
        }
      });
    } 
    else {
      console.log('modoSignup');
      this.service.signupUser(email, senha).subscribe({
        next: (data) => {
          console.log(data);
          this.estaCarregando = false;
          this.temErro = false;
          this.router.navigate(['/home']);
        },
        error: (error) => {
          console.log(error);
          switch(error.error.error.message){
            case 'EMAIL_EXISTS':
              this.erro = 'O e-mail já está em uso.';
              break;
            default:
              this.erro = 'Ocorreu um erro ao cadastrar o usuário.'
              break;
          
          }

          this.temErro = true;
          this.estaCarregando = false;
          if (this.erro) {
            this.openSnackBar();
          }
        }
      });
    }

    this.loginForm.reset();
  }

  openSnackBar () {
    this.snackBar.open(this.erro, 'X', {
      duration: this.snackBarDuration,
      horizontalPosition: 'center',
      verticalPosition: 'top'
    });
  }

}
