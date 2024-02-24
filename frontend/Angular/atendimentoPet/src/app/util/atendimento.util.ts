import { Injectable } from "@angular/core";
import { Atendimento } from "../model/atendimento";
import { AtendimentoDTO } from "../model/atendimento.dto";

@Injectable({
    providedIn: 'root'
})
export class AtendimentoUtil {

    formatarData(data: Date): string {
        // Adiciona um zero à esquerda se o dia/mês for menor que 10
        const dia = data.getDate().toString().padStart(2, '0'); 
        const mes = (data.getMonth() + 1).toString().padStart(2, '0'); 
        const ano = data.getFullYear();

        return `${dia}/${mes}/${ano}`;
    }

    converterToDTO(atendimento: Atendimento) {
        const atendimentoDTO: AtendimentoDTO = {
            nomeTutor: atendimento.nomeTutor,
            nomePet: atendimento.nomePet,
            data: this.formatarData(atendimento.data),
            raca: atendimento.raca
        };

        return atendimentoDTO;
    }

}