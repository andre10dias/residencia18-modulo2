import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';
import {MatTableModule} from '@angular/material/table';
import {MatIconModule} from '@angular/material/icon';
import {MatMenuModule} from '@angular/material/menu';
import {MatDividerModule} from '@angular/material/divider';
import {MatListModule} from '@angular/material/list';
import {
  MatDialogTitle,
  MatDialogContent,
  MatDialogActions,
  MatDialogClose,
} from '@angular/material/dialog';

import { AppRoutingModule } from '../../app-routing.module';

import { AtendimentosComponent } from './atendimentos.component';
import { AtendimentosListComponent } from './atendimentos-list/atendimentos-list.component';
import { AtendimentosFormComponent } from './atendimentos-dialog/atendimentos-form/atendimentos-form.component';
import { AtendimentosDialogComponent } from './atendimentos-dialog/atendimentos-dialog.component';

@NgModule({
  declarations: [
    AtendimentosComponent,
    AtendimentosListComponent,
    AtendimentosFormComponent,
    AtendimentosDialogComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatDialogClose,
    MatTableModule,
    MatIconModule,
    MatMenuModule,
    MatDividerModule,
    MatListModule
  ],
  exports: [
    AtendimentosComponent
  ]
})
export class AtendimentosModule { }
