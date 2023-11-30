export class Computador {

    constructor(id, marca, modelo, hd, placaMae, processador) {
        this._id = id;
        this._marca = marca;
        this._modelo = modelo;
        this._hd = hd;
        this._placaMae = placaMae;
        this._processador = processador;
    }

    ligar() {
        console.log('Ligando o computador...');
    }

    iniciarSO() {
        console.log('Iniciando o sistema operacional...');
    }

    desligar() {
        console.log('Desligando o computador...');
    }
}