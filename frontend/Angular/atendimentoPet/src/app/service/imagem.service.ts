import { Injectable } from '@angular/core';
import { ImagemPet } from '../model/imagem/imagem-pet';

@Injectable({
  providedIn: 'root'
})
export class ImagemService {

  private listaImag: ImagemPet[] = [
    {tipo: 1, path: '../../../../../assets/gato1.jpg'},
    {tipo: 1, path: '../../../../../assets/gato2.jpg'},
    {tipo: 1, path: '../../../../../assets/gato3.jpg'},
    {tipo: 1, path: '../../../../../assets/gato4.jpg'},
    {tipo: 2, path: '../../../../../assets/cachorro1.jpg'},
    {tipo: 2, path: '../../../../../assets/cachorro2.jpg'},
    {tipo: 2, path: '../../../../../assets/cachorro3.jpg'},
    {tipo: 2, path: '../../../../../assets/cachorro4.jpg'},
  ];

  constructor() { }

  getImagem(tipo: number): ImagemPet {
    let id: number = -1;
    let imagem: ImagemPet = {} as ImagemPet;

    do {
      id = this.gerarNumeroAleatorio();
      imagem = this.listaImag[id];
    } while (imagem.tipo != tipo);

    return this.listaImag[id];
  }

  private gerarNumeroAleatorio(): number {
    // Gera um número aleatório entre 0 (inclusivo) e 1 (exclusivo)
    const randomNumber = Math.random();
  
    // Multiplica o número aleatório pelo intervalo desejado (8 - 1 + 1 = 8)
    // e adiciona 1 para garantir que o número gerado esteja entre 1 e 8
    // const randomNumberInRange = Math.floor(randomNumber * 8) + 1;
    const randomNumberInRange = Math.floor(randomNumber * 8);
  
    return randomNumberInRange;
  }

}
