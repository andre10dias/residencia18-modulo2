import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';
import {MatTableModule} from '@angular/material/table';
import {MatIconModule} from '@angular/material/icon';
import {MatCardModule} from '@angular/material/card';
import {MatMenuModule} from '@angular/material/menu';
import {MatDividerModule} from '@angular/material/divider';
import {MatListModule} from '@angular/material/list';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule} from '@angular/material/sort';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
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
import { AtendimentosDetalheDialogComponent } from './atendimentos-detalhe-dialog/atendimentos-detalhe-dialog.component';
import { AtendimentosDetalheViewComponent } from './atendimentos-detalhe-dialog/atendimentos-detalhe-view/atendimentos-detalhe-view.component';

@NgModule({
  declarations: [
    AtendimentosComponent,
    AtendimentosListComponent,
    AtendimentosFormComponent,
    AtendimentosDialogComponent,
    AtendimentosDetalheDialogComponent,
    AtendimentosDetalheViewComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    HttpClientModule,
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
    MatCardModule,
    MatMenuModule,
    MatDividerModule,
    MatListModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule
  ],
  exports: [
    AtendimentosComponent
  ]
})
export class AtendimentosModule { }
