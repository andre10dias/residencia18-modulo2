export interface AtendimentoCreateDTO {
    id: string | null
    nomeTutor: string
    nomePet: string
    dataAtendimento: Date
    tipo: number
    observacao: string
    raca: string
    createAt: Date
    updateAt: Date | null
}
