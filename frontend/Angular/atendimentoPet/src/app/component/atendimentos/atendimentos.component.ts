import { Component } from '@angular/core';

import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';

import { AtendimentoService } from '../../service/atendimento.service';
import { AtendimentoConverter } from '../../converter/atendimento.converter';

import { AtendimentosDialogComponent } from './atendimentos-dialog/atendimentos-dialog.component';
import { AtendimentoListDTO } from '../../model/atendimento/atendimento-list.dto';

@Component({
  selector: 'app-atendimentos',
  templateUrl: './atendimentos.component.html',
  styleUrl: './atendimentos.component.css'
})
export class AtendimentosComponent {
  listaAtendimentos: AtendimentoListDTO[] = [];
  dataSource = new MatTableDataSource<AtendimentoListDTO>();

  constructor(
    private service: AtendimentoService,
    private converter: AtendimentoConverter,
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
      this.service.novoAtendimentoAdicionado();
    });
  }

  getListaAtendimentos(): void {
    this.service.getAllAtendimentos().subscribe({
      next: atendimentos => {
        this.listaAtendimentos = this.converter.toListAtendimentoListDTOs(atendimentos);
        // console.log('[atendimentos.component] getListaAtendimentos: ',this.listaAtendimentos);
      },
      error: error => {
        console.error('Erro ao carregar atendimentos:', error);
      }
    });
  }

}
