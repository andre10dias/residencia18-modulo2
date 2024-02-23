import { Component, Inject } from '@angular/core';

import {
  MatDialog,
  MAT_DIALOG_DATA,
  MatDialogRef,
  MatDialogTitle,
  MatDialogContent,
  MatDialogActions,
  MatDialogClose,
} from '@angular/material/dialog';

import { Atendimento } from '../../../model/atendimento';

@Component({
  selector: 'app-atendimentos-dialog',
  templateUrl: './atendimentos-dialog.component.html',
  styleUrl: './atendimentos-dialog.component.css'
})
export class AtendimentosDialogComponent {
  constructor(
    public dialogRef: MatDialogRef<AtendimentosDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Atendimento,
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}
