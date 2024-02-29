import { Injectable } from "@angular/core";
import { Atendimento } from "../model/atendimento";
import { AtendimentoListDTO } from "../model/atendimento-list.dto";
import { AtendimentoEditDTO } from "../model/atendimento-edit.dto.";

@Injectable({
    providedIn: 'root'
})
export class AtendimentoUtil {

    formatarData(data: Date, formato: string = 'yyyy-MM-dd'): string {
        // Adiciona um zero à esquerda se o dia/mês for menor que 10
        const dia = data.getDate().toString().padStart(2, '0'); 
        const mes = (data.getMonth() + 1).toString().padStart(2, '0'); 
        const ano = data.getFullYear();

        if (formato === 'dd/MM/yyyy') {
            return `${dia}/${mes}/${ano}`;
        }

        return `${ano}-${mes}-${dia}`;
    }

    stringToDate(dataString: string): Date | null {
        const partes = dataString.split('/');

        if (partes.length === 3) {
            const dia = parseInt(partes[0], 10);
            const mes = parseInt(partes[1], 10) - 1; // Mês começa do zero no objeto Date
            const ano = parseInt(partes[2], 10);
            
            // Verifica se os valores são válidos
            if (!isNaN(dia) && !isNaN(mes) && !isNaN(ano)) {
                return new Date(ano, mes, dia);
            }
        }
        
        // Retorna null se a string estiver em um formato inválido
        return null;
    }

    compare(a: number | string, b: number | string, isAsc: boolean) {
        return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
    }

    converterToListDTO(atendimento: Atendimento) {
        const atendimentoListDto: AtendimentoListDTO = {
            id: atendimento.id,
            nomeTutor: atendimento.nomeTutor,
            nomePet: atendimento.nomePet,
            data: this.formatarData(atendimento.data, 'dd/MM/yyyy'),
            raca: atendimento.raca
        };

        return atendimentoListDto;
    }

    converterToEditDTO(atendimento: Atendimento) {
        const atendimentoEditDto: AtendimentoEditDTO = {
            id: atendimento.id,
            nomeTutor: atendimento.nomeTutor,
            nomePet: atendimento.nomePet,
            data: this.formatarData(atendimento.data),
            tipo: atendimento.tipo,
            observacao: atendimento.observacao,
            raca: atendimento.raca
        };

        return atendimentoEditDto;
    }

}