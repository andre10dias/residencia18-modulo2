import { Injectable } from '@angular/core';
import { Observable, from } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NumerosService {

  constructor() { }

  getNumeros(): Observable<number> {
    const source = from([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);
    return source;
  }
}
