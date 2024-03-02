export class Raca {
    private _id: string;
    private _nome: string;
    private _tipo: number;
    private _createAt: Date;
    private _updateAt: Date | null;

    constructor(id: string, nome: string, tipo: number, createAt: Date, updateAt: Date | null) {
        this._id = id;
        this._nome = nome;
        this._tipo = tipo;
        this._createAt = createAt;
        this._updateAt = updateAt;
    }

    get id(): string {
        return this._id;
    }

    get nome(): string {
        return this._nome;
    }

    get tipo(): number {
        return this._tipo;
    }

    get createAt(): Date {
        return this._createAt;
    }

    get updateAt(): Date | null {
        return this._updateAt;
    }

    set updateAt(value: Date | null) {
        this._updateAt = value;
    }

    set id(value: string) {
        this._id = value;
    }

    set nome(value: string) {
        this._nome = value;
    }

    set tipo(value: number) {
        this._tipo = value;
    }

    set createAt(value: Date) {
        this._createAt = value;
    }
    
}
