import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

import { Atendimento } from '../../../model/atendimento/atendimento';
import { AtendimentoService } from '../../../service/atendimento.service';

@Component({
  selector: 'app-atendimentos-dialog',
  templateUrl: './atendimentos-dialog.component.html',
  styleUrl: './atendimentos-dialog.component.css'
})
export class AtendimentosDialogComponent {
  titulo: string = 'Cadastrar atendimentos';
  dadosItemSelecionado: any;

  constructor(
    private service: AtendimentoService,
    public dialogRef: MatDialogRef<AtendimentosDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {
    // console.log('[atendimentos-dialog.component] data: ', data);
    if (data) {
      this.titulo = 'Editar atendimentos';
      this.dadosItemSelecionado = data;
    }
  }

  // onNoClick(): void {
  //   console.log('[atendimentos-dialog.component] onNoClick()');
  //   this.dialogRef.close();
  // }

  enviarFormulario(formulario: any) {
    this.service.receberDadosFormulario(formulario);
    // Fechar o diálogo após salvar e envia os dados 
    // do formulário para a lista de atendimentos
    // this.dialogRef.close(formulario); 
    this.dialogRef.close(); 
  }

}
