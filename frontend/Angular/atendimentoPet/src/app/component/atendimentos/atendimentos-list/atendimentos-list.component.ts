import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { Sort, MatSort } from '@angular/material/sort';

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
  @ViewChild(MatSort) sort!: MatSort;

  screenWidth: number = window.innerWidth;

  listaAtendimentos: AtendimentoListDTO[] = [];
  
  displayedColumns: string[] = ['tutor', 'pet', 'data', 'raca', 'action'];
  dataSource = new MatTableDataSource<AtendimentoListDTO>();
  sortedData: AtendimentoListDTO[];

  removeTitle: string = 'Excluir atendimento';
  removeTemplate: string = '<div>Tem certeza que deseja remover?</div>';

  constructor(
    private service: BancoService,
    private util: AtendimentoUtil,
    public dialog: MatDialog
  ) {
    this.listaAtendimentos = this.service.atendimentos;
    this.dataSource = new MatTableDataSource<AtendimentoListDTO>(this.listaAtendimentos);
    this.sortedData = this.listaAtendimentos.slice();
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
    this.dataSource.sort = this.sort;
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

  sortData(sort: Sort) {
    // const data = this.listaAtendimentos.slice();
    const data = this.dataSource.data.slice();
    console.log('data: ', data);

    if (!sort.active || sort.direction === '') {
      this.sortedData = data;
      return;
    }

    this.sortedData = data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'tutor':
          return this.util.compare(a.nomeTutor, b.nomeTutor, isAsc);
        case 'pet':
          return this.util.compare(a.nomePet, b.nomePet, isAsc);
        case 'data':
          return this.util.compare(a.data, b.data, isAsc);
        case 'raca':
          return this.util.compare(a.raca, b.raca, isAsc);
        default:
          return 0;
      }
    });
  }

  isScreenSmall(): boolean {
    return this.screenWidth <= 500;
  }
  
}
