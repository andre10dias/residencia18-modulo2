import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';

import { Atendimento } from '../../../model/atendimento';
import { AtendimentosDialogComponent } from '../atendimentos-dialog/atendimentos-dialog.component';
import { AtendimentoDTO } from '../../../model/atendimento-dto';

@Component({
  selector: 'app-atendimentos-list',
  templateUrl: './atendimentos-list.component.html',
  styleUrl: './atendimentos-list.component.css'
})
export class AtendimentosListComponent {
  displayedColumns: string[] = ['tutor', 'pet', 'data', 'raca'];

  ELEMENT_DATA: AtendimentoDTO[] = [
    {nomeTutor: 'Hydrogen', nomePet: 'Aparecida', data: '23/02/2024', raca: 'Pitbull'},
    {nomeTutor: 'Helium', nomePet: 'Aparecida', data: '23/02/2024', raca: 'Pitbull'},
    {nomeTutor: 'Lithium', nomePet: 'Aparecida', data: '23/02/2024', raca: 'Pitbull'},
    {nomeTutor: 'Beryllium', nomePet: 'Aparecida', data: '23/02/2024', raca: 'Pitbull'},
    {nomeTutor: 'Boron', nomePet: 'Aparecida', data: '23/02/2024', raca: 'Pitbull'},
    {nomeTutor: 'Carbon', nomePet: 'Aparecida', data: '23/02/2024', raca: 'Pitbull'},
    {nomeTutor: 'Nitrogen', nomePet: 'Aparecida', data: '23/02/2024', raca: 'Pitbull'},
    {nomeTutor: 'Oxygen', nomePet: 'Aparecida', data: '23/02/2024', raca: 'Pitbull'},
    {nomeTutor: 'Fluorine', nomePet: 'Aparecida', data: '23/02/2024', raca: 'Pitbull'},
    {nomeTutor: 'Neon', nomePet: 'Aparecida', data: '23/02/2024', raca: 'Pitbull'},
  ];

  dataSource = new MatTableDataSource<AtendimentoDTO>(this.ELEMENT_DATA);

  constructor(public dialog: MatDialog) {}

  openDialog(): void {
    const dialogRef = this.dialog.open(AtendimentosDialogComponent, {
      width: '600px',
      // data: {name: this.name, animal: this.animal},
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      // this.animal = result;
    });
  }
}
