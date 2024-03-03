import { Component } from '@angular/core';

import { MatDialog } from '@angular/material/dialog';

import { AtendimentosDialogComponent } from './atendimentos-dialog/atendimentos-dialog.component';

import { AtendimentoService } from '../../service/atendimento.service';

import { AtendimentoListDTO } from '../../model/atendimento/atendimento-list.dto';

@Component({
  selector: 'app-atendimentos',
  templateUrl: './atendimentos.component.html',
  styleUrl: './atendimentos.component.css'
})
export class AtendimentosComponent {
  listaAtendimentos: AtendimentoListDTO[] = [];
  spinner: boolean = true;
  constructor(
    private service: AtendimentoService,
    public dialog: MatDialog
  ) {
  }
  
  openDialog(element?: any): void {
    const dialogRef = this.dialog.open(AtendimentosDialogComponent, {
      width: '600px',
      disableClose: true,
      data: element
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.spinner = false;
        this.service.novoAtendimentoAdicionado();
  
        setTimeout(() => {
          this.spinner = true;
        }, 1000);
      }
    });
  }

}
