export class Atendimento {
    private _nomePet: string;
    private _nomeTutor: string;
    private _data: Date;
    private _tipo: string;
    private _observacao: string;
    private _raca: string;

    constructor() {
        this._nomePet = '';
        this._nomeTutor = '';
        this._data = new Date();
        this._tipo = '';
        this._observacao = '';
        this._raca = '';
    }

    get nomePet(): string {
        return this._nomePet;
    }

    set nomePet(value: string) {
        this._nomePet = value;
    }

    get nomeTutor(): string {
        return this._nomeTutor;
    }

    set nomeTutor(value: string) {
        this._nomeTutor = value;
    }

    get data(): Date {
        return this._data;
    }

    set data(value: Date) {
        this._data = value;
    }

    get tipo(): string {
        return this._tipo;
    }

    set tipo(value: string) {
        this._tipo = value;
    }

    get observacao(): string {
        return this._observacao;
    }

    set observacao(value: string) {
        this._observacao = value;
    }

    get raca(): string {
        return this._raca;
    }

    set raca(value: string) {
        this._raca = value;
    }
}