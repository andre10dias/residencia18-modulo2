export class Usuario {
    constructor(
        public _id: string,
        public _email: string,
        private _token: string,
        private _tokenExpirationDate: Date
    ) {

    }

    get id(): string {
        return this._id;
    }

    get token(): string | null {
        if(!this._tokenExpirationDate || new Date() > this._tokenExpirationDate){
            return null;
        }

        return this._token;
    } 

    get mail(): string {
        return this._email;
    }

    set mail(value: string) {
        this._email = value;
    }

}
