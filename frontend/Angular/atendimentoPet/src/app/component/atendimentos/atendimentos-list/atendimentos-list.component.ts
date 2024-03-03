import { Component, OnInit, ViewChild } from '@angular/core';

import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { Sort, MatSort } from '@angular/material/sort';

import { AtendimentosDialogComponent } from '../atendimentos-dialog/atendimentos-dialog.component';
import { DialogComponent } from '../../dialog/dialog.component';

import { AtendimentoService } from '../../../service/atendimento.service';
import { AtendimentoUtil } from '../../../util/atendimento.util';
import { AtendimentoConverter } from '../../../converter/atendimento.converter';

import { AtendimentoListDTO } from '../../../model/atendimento/atendimento-list.dto';
import { AtendimentoFormDTO } from '../../../model/atendimento/atendimento-form.dto';

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
    this.carregarAtendimentos();
  }

  ngOnInit(): void {
    this.service.novoAtendimentoObservable.subscribe({
      next: (atendimento: AtendimentoListDTO) => {
        this.dataSource.data.push(atendimento);
        this.dataSource._updateChangeSubscription();
      }
    });

    window.onresize = () => {
      this.screenWidth = window.innerWidth;
    };

    if (this.isScreenSmall()) {
      this.displayedColumns = ['tutor', 'pet', 'raca', 'action'];
    }
  }

  carregarAtendimentos(): void {
    this.service.getAllAtendimentos().subscribe({
      next: atendimentos => {
        this.listaAtendimentos = this.converter.toListAtendimentoListDTOs(atendimentos);
        // console.log('[atendimentos-list] carregarAtendimentos: ', this.listaAtendimentos);
        this.dataSource = new MatTableDataSource<AtendimentoListDTO>(this.listaAtendimentos);
        this.sortedData = this.listaAtendimentos.slice();
        this.dadosCarregados = true;
        
        setTimeout(() => {
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
          let label = document.querySelector('#mat-paginator-page-size-label-0') as HTMLElement;
          // let label2 = document.querySelector('.mat-mdc-paginator-range-label') as HTMLElement;
          
          if (label) {
            label.innerHTML = 'Itens por página:';
          }
        }, 200);

        this.spinnerOn();
        this.spinnerOff();
      },
      error: error => {
        console.error('Erro ao carregar atendimentos:', error);
      }
    });
  }

  openDialog(element?: AtendimentoFormDTO): void {
    const dialogRef = this.dialog.open(AtendimentosDialogComponent, {
      width: '600px',
      disableClose: true,
      data: element
    });

    dialogRef.afterClosed().subscribe(result => {
      this.spinnerOn();
      console.log('result: ', result);

      if (result) {
        const index = this.dataSource.data.findIndex(item => item.id === element?.id);

        if (index !== -1) {
          setTimeout(() => {
            this.dataSource.data[index] = this.service.atendimentoAtualizado;
            this.dataSource._updateChangeSubscription();
            this.dadosCarregados = true;
          }, 1000);
        }
      }

      this.spinnerOff();
    });
  }

  editItem(id: string): void {
    this.service.getAtendimentoById(id).subscribe(atendimento => {
      if (atendimento) {
        atendimento.id = id;
        let atendimentoFormDTO: AtendimentoFormDTO = this.converter.toAtendimentoFormDTO(atendimento);
        this.openDialog(atendimentoFormDTO);
      }
    });
  }

  removeItem(id: string): void {
    this.service.deleteAtendimento(id);
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
      this.spinnerOn();

      if (result) {
        this.removeItem(element);
      }

      this.spinnerOff();
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

  spinnerOn(): void {
    this.dadosCarregados = false;
  }

  spinnerOff(): void {
    setTimeout(() => {
      this.dadosCarregados = true;
    }, 1000);
  }
  
}
