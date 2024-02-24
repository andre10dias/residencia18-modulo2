import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';

import { AtendimentosDialogComponent } from '../atendimentos-dialog/atendimentos-dialog.component';
import { AtendimentoDTO } from '../../../model/atendimento.dto';
import { BancoService } from '../../../service/banco.service';
import { Atendimento } from '../../../model/atendimento';
import { AtendimentoUtil } from '../../../util/atendimento.util';

@Component({
  selector: 'app-atendimentos-list',
  templateUrl: './atendimentos-list.component.html',
  styleUrl: './atendimentos-list.component.css'
})
export class AtendimentosListComponent {
  displayedColumns: string[] = ['tutor', 'pet', 'data', 'raca'];
  dataSource = new MatTableDataSource<AtendimentoDTO>();

  constructor(
    private service: BancoService,
    private util: AtendimentoUtil,
    public dialog: MatDialog
  ) {
    this.dataSource = new MatTableDataSource<AtendimentoDTO>(this.service.atendimentos);
    console.log(this.service.atendimentos);
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AtendimentosDialogComponent, {
      width: '600px',
      // data: {name: this.name, animal: this.animal},
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('result: ', result);
      const atendimento: Atendimento = new Atendimento(
        result.nomeTutor,
        result.nomePet,
        new Date(result.data),
        result.tipo,
        result.observacao,
        result.raca
      );

      const atendimentoDTO: AtendimentoDTO = this.util.converterToDTO(atendimento);

      this.dataSource.data.push(atendimentoDTO);

      // Adiciona o novo item à fonte de dados e atualiza a fonte de dados
      // this.dataSource.data = [...this.dataSource.data, atendimentoDTO];
      this.dataSource._updateChangeSubscription(); // Atualizar a fonte de dados da tabela
    });
  }
  
}
