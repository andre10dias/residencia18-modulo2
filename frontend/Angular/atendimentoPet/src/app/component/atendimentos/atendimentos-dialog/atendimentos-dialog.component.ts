import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

import { Atendimento } from '../../../model/atendimento';
import { BancoService } from '../../../service/banco.service';

@Component({
  selector: 'app-atendimentos-dialog',
  templateUrl: './atendimentos-dialog.component.html',
  styleUrl: './atendimentos-dialog.component.css'
})
export class AtendimentosDialogComponent {
  titulo: string = 'Cadastrar atendimentos';

  constructor(
    private service: BancoService,
    public dialogRef: MatDialogRef<AtendimentosDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Atendimento,
  ) {}

  // onNoClick(): void {
  //   console.log('[atendimentos-dialog.component] onNoClick()');
  //   this.dialogRef.close();
  // }

  enviarFormulario(formulario: any) {
    this.service.setDadosFormulario(formulario);
    // Fechar o diálogo após salvar e envia os dados 
    // do formulário para a lista de atendimentos
    this.dialogRef.close(formulario); 
  }

}
