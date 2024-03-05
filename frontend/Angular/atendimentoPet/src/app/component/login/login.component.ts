import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loginForm: FormGroup;
  mensagem: string = '';

  modoLogin = true;
  estaCarregando = false;
  erro: string = '';
  temErro:boolean = false;

  constructor(
    private service: AuthService,
    private router: Router
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

    console.log(email, senha);
    if(this.modoLogin) {
      console.log('modoLogin');
      // this.service.loginUser(email, senha).subscribe({
      //   next: (data) => {
      //     console.log(data);
      //     this.estaCarregando = false;
      //     this.temErro = false;
      //     this.router.navigate(['/home']);
      //   }
      // });
    } 
    else {
      console.log('modoSignup');
      // this.service.signupUser(email, senha).subscribe({
      //   next: (data) => {
      //     console.log(data);
      //     this.estaCarregando = false;
      //     this.temErro = false;
      //     this.router.navigate(['/home']);
      //   },
      //   error: (error) => {
      //     console.log(error);
      //     switch(error.error.error.message){
      //       case 'EMAIL_EXISTS':
      //         this.erro = 'O e-mail já está em uso.';
      //         break;
      //       default:
      //         this.erro = 'Ocorreu um erro ao cadastrar o usuário.'
      //         break;
          
      //     }

      //     this.temErro = true;
      //     this.erro = 'Ocorreu um erro ao cadastrar o usuário.'
      //     this.estaCarregando = false;
      //   }
      // });
    }

    this.loginForm.reset();
  }

}
