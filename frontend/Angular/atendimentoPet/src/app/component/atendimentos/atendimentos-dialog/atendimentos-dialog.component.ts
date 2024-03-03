import { Component, Inject } from '@angular/core';

import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

import { AtendimentoService } from '../../../service/atendimento.service';

import { ActionEnum } from '../../../enum/action-enum';

@Component({
  selector: 'app-atendimentos-dialog',
  templateUrl: './atendimentos-dialog.component.html',
  styleUrl: './atendimentos-dialog.component.css'
})
export class AtendimentosDialogComponent {
  titulo: string = 'Cadastrar atendimentos';
  dadosItemSelecionado: any;
  action: string = ActionEnum.CREATE;

  constructor(
    private service: AtendimentoService,
    public dialogRef: MatDialogRef<AtendimentosDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {
    if (data) {
      this.action = ActionEnum.EDIT;
      this.titulo = 'Editar atendimentos';
      this.dadosItemSelecionado = data;
    }
  }

  // onNoClick(): void {
  //   console.log('[atendimentos-dialog.component] onNoClick()');
  //   this.dialogRef.close();
  // }

  enviarFormulario(formulario: any) {
    if (this.action === ActionEnum.CREATE) {
      this.service.receberDadosFormulario(formulario);
    } else if (this.action === ActionEnum.EDIT) {
      this.service.receberDadosFormularioEdit(formulario);
    }
    // Fechar o diálogo após salvar e envia os dados 
    // do formulário para a lista de atendimentos
    // this.dialogRef.close(formulario); 
    this.dialogRef.close(true); 
  }

}
