import { Injectable } from "@angular/core";
import { Atendimento } from "../model/atendimento/atendimento";
import { AtendimentoListDTO } from "../model/atendimento/atendimento-list.dto";
import { AtendimentoEditDTO } from "../model/atendimento/atendimento-edit.dto.";

@Injectable({
    providedIn: 'root'
})
export class AtendimentoUtil {

    formatarData(dataParam: Date, formato: string = 'yyyy-MM-dd'): string {
        const data = new Date(dataParam);

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

    compareDates(a: string, b: string, isAsc: boolean): number {
        const dateA = new Date(a);
        const dateB = new Date(b);
        return (dateA < dateB ? -1 : 1) * (isAsc ? 1 : -1);
    }

}