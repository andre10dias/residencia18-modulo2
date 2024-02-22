import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AtendimentosComponent } from './atendimentos.component';
import { AtendimentosListComponent } from './atendimentos-list/atendimentos-list.component';
import { AtendimentosFormComponent } from './atendimentos-form/atendimentos-form.component';
import { AppRoutingModule } from '../../app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';



@NgModule({
  declarations: [
    AtendimentosComponent,
    AtendimentosListComponent,
    AtendimentosFormComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule
  ],
  exports: [
    AtendimentosComponent
  ]
})
export class AtendimentosModule { }
