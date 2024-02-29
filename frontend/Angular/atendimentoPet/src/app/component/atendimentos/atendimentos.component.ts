import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

import { BancoService } from '../../service/banco.service';
import { AtendimentosDialogComponent } from './atendimentos-dialog/atendimentos-dialog.component';
import { AtendimentoListDTO } from '../../model/atendimento-list.dto';

@Component({
  selector: 'app-atendimentos',
  templateUrl: './atendimentos.component.html',
  styleUrl: './atendimentos.component.css'
})
export class AtendimentosComponent {
  listaAtendimentos: AtendimentoListDTO[] = [];

  constructor(
    private service: BancoService,
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
      // console.log('result: ', result);
      // this.dataSource._updateChangeSubscription(); // Atualizar a fonte de dados da tabela
      this.listaAtendimentos = this.service.atendimentos;
      console.log(this.listaAtendimentos);
    });
  }

}
