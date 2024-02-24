import { Injectable } from '@angular/core';
import { TipoEnum } from '../enum/tipo-enum';
import { AtendimentoDTO } from '../model/atendimento.dto';
import { Atendimento } from '../model/atendimento';
import { AtendimentoUtil } from '../util/atendimento.util';

@Injectable({
  providedIn: 'root'
})
export class BancoService {
  tipo: any[] = [
    {value: '', viewValue: 'Selecione...'},
    {value: TipoEnum.GATO, viewValue: 'Gato'},
    {value: TipoEnum.CACHORRO, viewValue: 'Cachorro'},
  ];

  racaGato: any[] = [
    {value: '', viewValue: 'Selecione...'},
    {value: 'angora', viewValue: 'Angorá'},
    {value: 'bengal', viewValue: 'Bengal'},
    {value: 'british', viewValue: 'British shorthair'},
    {value: 'exotico', viewValue: 'Exótico'},
    {value: 'persa', viewValue: 'Persa'},
    {value: 'ragdoll', viewValue: 'Ragdoll'},
    {value: 'siames', viewValue: 'Siamês'},
    {value: 'sphynx', viewValue: 'Sphynx'}
  ];

  racaCachorro: any[] = [
    {value: '', viewValue: 'Selecione...'},
    {value: 'buldogue', viewValue: 'Buldogue'},
    {value: 'dachshund', viewValue: 'Dachshund'},
    {value: 'pastor', viewValue: 'Pastor Alemão'},
    {value: 'poodle', viewValue: 'Poodle'},
    {value: 'labrador', viewValue: 'Labrador'},
    {value: 'rottweiler', viewValue: 'Rottweiler'}
  ];

  atendimentos: any[] = [
    {nomeTutor: 'Maria', nomePet: 'Paçoca', data: '23/02/2024', raca: 'Exotico'},
    {nomeTutor: 'José', nomePet: 'Bolacha', data: '20/02/2024', raca: 'Bengal'},
    {nomeTutor: 'Ana', nomePet: 'Pipoca', data: '18/02/2024', raca: 'Buldogue'},
    {nomeTutor: 'João', nomePet: 'Bisteca', data: '10/02/2024', raca: 'Sianês'},
    {nomeTutor: 'Antônio', nomePet: 'Bisteca', data: '05/02/2024', raca: 'Labrador'},
    {nomeTutor: 'Francisco', nomePet: 'Mel', data: '23/01/2024', raca: 'Poodle'},
    {nomeTutor: 'Juliana', nomePet: 'Cacau', data: '20/12/2023', raca: 'Poodle'},
  ];

  listaAtendimentos: Atendimento[] = [];

  constructor(private util: AtendimentoUtil) { }

  setDadosFormulario(form: any) {
    const [ano, mes, dia] = form.data.split('-');
    console.log('dados recebidos no service: ', form);

    // Meses são 0-based, então subtraímos 1
    const data = new Date(Number(ano), Number(mes) - 1, Number(dia)); 

    let atendimento: Atendimento = new Atendimento(
      form.nomeTutor,
      form.nomePet,
      data,
      form.tipo,
      form.observacao,
      form.raca
    );

    this.listaAtendimentos.push(atendimento);

    let formDTO: AtendimentoDTO = this.util.converterToDTO(atendimento);
    this.atendimentos.push(formDTO);
  }
}
