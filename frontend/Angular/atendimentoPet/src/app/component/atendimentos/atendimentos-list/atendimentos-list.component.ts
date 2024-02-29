import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';

import { AtendimentosDialogComponent } from '../atendimentos-dialog/atendimentos-dialog.component';
import { AtendimentoListDTO } from '../../../model/atendimento-list.dto';
import { BancoService } from '../../../service/banco.service';
import { AtendimentoUtil } from '../../../util/atendimento.util';
import { Atendimento } from '../../../model/atendimento';
import { AtendimentoEditDTO } from '../../../model/atendimento-edit.dto.';
import { DialogComponent } from '../../dialog/dialog.component';

@Component({
  selector: 'app-atendimentos-list',
  templateUrl: './atendimentos-list.component.html',
  styleUrl: './atendimentos-list.component.css'
})
export class AtendimentosListComponent implements AfterViewInit, OnInit {
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  screenWidth: number = window.innerWidth;

  displayedColumns: string[] = ['tutor', 'pet', 'data', 'raca', 'action'];
  dataSource = new MatTableDataSource<AtendimentoListDTO>();

  removeTitle: string = 'Excluir atendimento';
  removeTemplate: string = '<div>Tem certeza que deseja remover?</div>';


  constructor(
    private service: BancoService,
    private util: AtendimentoUtil,
    public dialog: MatDialog
  ) {
    this.dataSource = new MatTableDataSource<AtendimentoListDTO>(this.service.atendimentos);
  }

  ngOnInit(): void {
    window.onresize = () => {
      this.screenWidth = window.innerWidth;
    };

    if (this.isScreenSmall()) {
      this.displayedColumns = ['tutor', 'pet', 'raca', 'action'];
    }
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    let label = document.querySelector('#mat-paginator-page-size-label-0') as HTMLElement;
    if (label) {
      label.innerHTML = 'Itens por página:';
    }
  }

  openDialog(element?: AtendimentoEditDTO): void {
    const dialogRef = this.dialog.open(AtendimentosDialogComponent, {
      width: '600px',
      disableClose: true,
      data: element
    });

    dialogRef.afterClosed().subscribe(result => {
      // console.log('result: ', result);
      // const atendimento: Atendimento = new Atendimento(
      //   result.nomeTutor,
      //   result.nomePet,
      //   new Date(result.data),
      //   result.tipo,
      //   result.observacao,
      //   result.raca
      // );

      // const atendimentoDTO: AtendimentoDTO = this.util.converterToDTO(atendimento);

      // this.dataSource.data.push(atendimentoDTO);

      // Adiciona o novo item à fonte de dados e atualiza a fonte de dados
      // this.dataSource.data = [...this.dataSource.data, atendimentoDTO];
      this.dataSource._updateChangeSubscription(); // Atualizar a fonte de dados da tabela
    });
  }

  editItem(id: number): void {
    let atendimento: Atendimento | undefined = this.service.getAtendimentoById(id);

    if (atendimento) {
      let atendimentoEditDTO: AtendimentoEditDTO = this.util.converterToEditDTO(atendimento);
      // console.log('[atendimentos-list] editItem: ', atendimentoEditDTO);
      this.openDialog(atendimentoEditDTO);
    }
  }

  removeItem(id: number): void {
    const index = this.dataSource.data.findIndex(item => item.id === id);
    if (index !== -1) {
      this.dataSource.data.splice(index, 1);
      this.dataSource._updateChangeSubscription();
    }
  }

  openConfirmDialog(
    element?: any, 
    template: string = this.removeTemplate, 
    title: string = this.removeTitle
  ): void {
    const dialogRef = this.dialog.open(DialogComponent, {
      width: '600px',
      disableClose: true,
      data: {title, template, element}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.removeItem(element);
        this.dataSource._updateChangeSubscription();
      }
    });
  }

  isScreenSmall(): boolean {
    return this.screenWidth <= 500;
  }
  
}
