export class Tarefa {
    constructor(nome) {
        this._nome = nome
    }
    
    get nome() {
        return this._nome;
    }
}
