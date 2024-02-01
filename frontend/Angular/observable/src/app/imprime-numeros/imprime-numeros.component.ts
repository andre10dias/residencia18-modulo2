import { Component, OnInit } from '@angular/core';
import { NumerosService } from '../service/numeros.service';

@Component({
  selector: 'app-imprime-numeros',
  templateUrl: './imprime-numeros.component.html',
  styleUrl: './imprime-numeros.component.css'
})
export class ImprimeNumerosComponent implements OnInit {

  numeros: number[] = [];

  constructor(private service: NumerosService) { }

  ngOnInit(): void {
    this.getNumeros();
  }

  getNumeros(): void {
    this.service.getNumeros().subscribe(numeros => {
      this.numeros.push(numeros);
      console.log(numeros);
    });
  }

}
