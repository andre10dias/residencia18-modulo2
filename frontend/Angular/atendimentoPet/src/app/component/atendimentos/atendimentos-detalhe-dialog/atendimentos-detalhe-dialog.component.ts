import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { AtendimentoFormDTO } from '../../../model/atendimento/atendimento-form.dto';
import { AtendimentoUtil } from '../../../util/atendimento.util';

@Component({
  selector: 'app-atendimentos-detalhe-dialog',
  templateUrl: './atendimentos-detalhe-dialog.component.html',
  styleUrl: './atendimentos-detalhe-dialog.component.css'
})
export class AtendimentosDetalheDialogComponent {
  title = '';
  dadosItemSelecionado: AtendimentoFormDTO = {} as AtendimentoFormDTO;

  constructor(
    private util: AtendimentoUtil,
    public dialogRef: MatDialogRef<AtendimentosDetalheDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {
    this.title = data.title;
    this.dadosItemSelecionado = data.element;
  }

}
