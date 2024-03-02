export class Atendimento {
    private _id: string;
    private _nomeTutor: string;
    private _nomePet: string;
    private _dataAtendimento: Date;
    private _tipo: number;
    private _observacao: string;
    private _raca: string;
    private _createAt: Date;
    private _updateAt: Date | null;

    constructor(id: string, nomeTutor: string, nomePet: string, dataAtendimento: Date, 
        tipo: number, observacao: string, raca: string, createAt: Date, updateAt: Date | null) {
        
        this._id = id;
        this._nomeTutor = nomeTutor;
        this._nomePet = nomePet;
        this._dataAtendimento = dataAtendimento;
        this._tipo = tipo;
        this._observacao = observacao;
        this._raca = raca;
        this._createAt = createAt;
        this._updateAt = updateAt;
    }

    get id(): string {
        return this._id;
    }

    set id(value: string) {
        this._id = value;
    }

    get nomeTutor(): string {
        return this._nomeTutor;
    }

    set nomeTutor(value: string) {
        this._nomeTutor = value;
    }

    get nomePet(): string {
        return this._nomePet;
    }

    set nomePet(value: string) {
        this._nomePet = value;
    }

    get dataAtendimento(): Date {
        return this._dataAtendimento;
    }

    set dataAtendimento(value: Date) {
        this._dataAtendimento = value;
    }

    get tipo(): number {
        return this._tipo;
    }

    set tipo(value: number) {
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

    get createAt(): Date {
        return this._createAt;
    }

    set createAt(value: Date) {
        this._createAt = value;
    }

    get updateAt(): Date | null {
        return this._updateAt;
    }

    set updateAt(value: Date | null) {
        this._updateAt = value;
    }

}