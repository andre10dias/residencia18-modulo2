export interface RacaCreateDTO {
    id: string | null
    nome: string;
    tipo: number;
    createAt: Date;
    updateAt: Date | null;
}