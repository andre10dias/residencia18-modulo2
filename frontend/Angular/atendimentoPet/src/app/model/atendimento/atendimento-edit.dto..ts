export interface AtendimentoEditDTO {
    id: string;
    nomeTutor: string;
    nomePet: string;
    dataAtendimento: Date;
    tipo: number;
    observacao: string;
    raca: string;
    updateAt: Date | null;
}