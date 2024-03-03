import { ImagemPet } from "../imagem/imagem-pet";


export interface AtendimentoDetailDTO {
    id: string;
    nomeTutor: string;
    nomePet: string;
    observacao: string;
    raca: string;
    imagem: ImagemPet;
}