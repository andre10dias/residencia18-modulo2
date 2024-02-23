import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Atendimento } from '../../../model/atendimento';
import { AtendimentosDialogComponent } from '../atendimentos-dialog/atendimentos-dialog.component';

@Component({
  selector: 'app-atendimentos-list',
  templateUrl: './atendimentos-list.component.html',
  styleUrl: './atendimentos-list.component.css'
})
export class AtendimentosListComponent {
  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource: any; //= ELEMENT_DATA;

  // const ELEMENT_DATA: Atendimento[] = [
  //   {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  //   {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  //   {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  //   {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
  //   {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
  //   {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
  //   {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
  //   {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
  //   {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
  //   {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
  // ];

  constructor(public dialog: MatDialog) {}

  openDialog(): void {
    const dialogRef = this.dialog.open(AtendimentosDialogComponent, {
      // data: {name: this.name, animal: this.animal},
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      // this.animal = result;
    });
  }
}
