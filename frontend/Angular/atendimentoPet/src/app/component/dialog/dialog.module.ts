import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {
  MatDialogTitle,
  MatDialogContent,
  MatDialogActions,
  MatDialogClose,
} from '@angular/material/dialog';

import { DialogComponent } from './dialog.component';


@NgModule({
  declarations: [
    DialogComponent
  ],
  imports: [
    CommonModule,
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatDialogClose,
  ]
})
export class DialogModule { }
