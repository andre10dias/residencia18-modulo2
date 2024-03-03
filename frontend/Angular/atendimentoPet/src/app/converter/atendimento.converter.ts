import { Injectable } from "@angular/core";

import { AtendimentoUtil } from "../util/atendimento.util";

import { Atendimento } from "../model/atendimento/atendimento";
import { AtendimentoListDTO } from "../model/atendimento/atendimento-list.dto";
import { AtendimentoEditDTO } from "../model/atendimento/atendimento-edit.dto.";
import { AtendimentoFormDTO } from "../model/atendimento/atendimento-form.dto";

@Injectable({
    providedIn: 'root'
})
export class AtendimentoConverter {

    constructor(private util: AtendimentoUtil) {}
    
    toAtendimentoListDTO(atendimento: Atendimento): AtendimentoListDTO {
        return {
            id: atendimento.id,
            nomeTutor: atendimento.nomeTutor,
            nomePet: atendimento.nomePet,
            dataAtendimento: this.util.formatarData(atendimento.dataAtendimento, 'dd/MM/yyyy'),
            raca: atendimento.raca
        };
    }

    toListAtendimentoListDTOs(listaAtendimentos: Atendimento[]): AtendimentoListDTO[] {
        let atendimentosListDTO: AtendimentoListDTO[] = [];
        let atendimento: AtendimentoListDTO;
        
        listaAtendimentos.forEach(data => {
            // console.log('[AtendimentoConverter] toListAtendimentoListDTOs: ', data);
            atendimento = {
                id: data.id,
                nomeTutor: data.nomeTutor,
                nomePet: data.nomePet,
                dataAtendimento: this.util.formatarData(data.dataAtendimento, 'dd/MM/yyyy'),
                raca: data.raca
            }

            atendimentosListDTO.push(atendimento);
        })

        return atendimentosListDTO;
    }

    toAtendimentoFormDTO(atendimento: Atendimento): AtendimentoFormDTO {
        let atendimentoFormDTO: AtendimentoFormDTO = {
            id: atendimento.id,
            nomeTutor: atendimento.nomeTutor,
            nomePet: atendimento.nomePet,
            dataAtendimento: this.util.formatarData(atendimento.dataAtendimento),
            tipo: atendimento.tipo,
            observacao: atendimento.observacao,
            raca: atendimento.raca
        };

        return atendimentoFormDTO;
    }
    
    toAtendimentoEditDTO(atendimento: Atendimento): AtendimentoEditDTO {
        let atendimentoEditDTO: AtendimentoEditDTO = {
            id: atendimento.id,
            nomeTutor: atendimento.nomeTutor,
            nomePet: atendimento.nomePet,
            dataAtendimento: atendimento.dataAtendimento,
            tipo: atendimento.tipo,
            observacao: atendimento.observacao,
            raca: atendimento.raca,
            updateAt: atendimento.updateAt
        };

        return atendimentoEditDTO;
    }

}