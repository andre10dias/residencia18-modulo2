import { Component, OnInit, ViewChild } from '@angular/core';

import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { Sort, MatSort } from '@angular/material/sort';

import { AtendimentosDialogComponent } from '../atendimentos-dialog/atendimentos-dialog.component';
import { AtendimentoListDTO } from '../../../model/atendimento/atendimento-list.dto';
import { AtendimentoService } from '../../../service/atendimento.service';
import { AtendimentoUtil } from '../../../util/atendimento.util';
import { AtendimentoEditDTO } from '../../../model/atendimento/atendimento-edit.dto.';
import { DialogComponent } from '../../dialog/dialog.component';
import { AtendimentoConverter } from '../../../converter/atendimento.converter';

@Component({
  selector: 'app-atendimentos-list',
  templateUrl: './atendimentos-list.component.html',
  styleUrl: './atendimentos-list.component.css'
})
export class AtendimentosListComponent implements OnInit {
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  
  listaAtendimentos: AtendimentoListDTO[] = [];
  dadosCarregados: boolean = false;
  screenWidth: number = window.innerWidth;
  
  
  displayedColumns: string[] = ['tutor', 'pet', 'data', 'raca', 'action'];
  dataSource = new MatTableDataSource<AtendimentoListDTO>();
  sortedData: AtendimentoListDTO[] = [];

  removeTitle: string = 'Excluir atendimento';
  removeTemplate: string = '<div>Tem certeza que deseja remover?</div>';

  constructor(
    private service: AtendimentoService,
    private converter: AtendimentoConverter,
    private util: AtendimentoUtil,
    public dialog: MatDialog
  ) {
    // this.listaAtendimentos = this.converter.toListAtendimentoListDTOs(this.service.getAllAtendimentos());
    console.log('[atendimentos-list] this.listaAtendimentos: ', this.listaAtendimentos);
    // this.dataSource = new MatTableDataSource<AtendimentoListDTO>(this.listaAtendimentos);
    // if (this.listaAtendimentos) {
    //   this.sortedData = this.listaAtendimentos.slice() as AtendimentoListDTO[];
    // }
  }

  ngOnInit(): void {
    this.getListaAtendimentos();

    window.onresize = () => {
      this.screenWidth = window.innerWidth;
    };

    if (this.isScreenSmall()) {
      this.displayedColumns = ['tutor', 'pet', 'raca', 'action'];
    }
  }

  getListaAtendimentos(): void {
    this.service.getAllAtendimentos().subscribe({
      next: atendimentos => {
        this.listaAtendimentos = this.converter.toListAtendimentoListDTOs(atendimentos);
        this.dadosCarregados = true;
        this.dataSource = new MatTableDataSource<AtendimentoListDTO>(this.listaAtendimentos);
        this.sortedData = this.listaAtendimentos.slice();

        setTimeout(() => {
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
          let label = document.querySelector('#mat-paginator-page-size-label-0') as HTMLElement;
          // let label2 = document.querySelector('.mat-mdc-paginator-range-label') as HTMLElement;
          
          if (label) {
            label.innerHTML = 'Itens por página:';
          }
        }, 200);
      },
      error: error => {
        console.error('Erro ao carregar atendimentos:', error);
      }
    });
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

  editItem(id: string): void {
    // this.service.getAtendimentoById(id).subscribe(atendimento => {
    //     if (atendimento) {
    //         let atendimentoEditDTO: AtendimentoEditDTO = this.converter.toAtendimentoEditDTO(atendimento);
    //         // console.log('[atendimentos-list] editItem: ', atendimentoEditDTO);
    //         this.openDialog(atendimentoEditDTO);
    //     }
    // });
  }

  removeItem(id: string): void {
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
        case 'dataAtendimento':
          return this.util.compareDates(a.dataAtendimento, b.dataAtendimento, isAsc);
        case 'raca':
          return this.util.compare(a.raca, b.raca, isAsc);
        default:
          return this.util.compare(a.dataAtendimento, b.dataAtendimento, isAsc);
      }
    });
  }

  isScreenSmall(): boolean {
    return this.screenWidth <= 500;
  }
  
}
