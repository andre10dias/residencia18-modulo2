import { Injectable } from '@angular/core';
import { TipoEnum } from '../enum/tipo-enum';
import { AtendimentoListDTO } from '../model/atendimento-list.dto';
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

  listaAtendimentos: Atendimento[] = [];
  atendimentos: AtendimentoListDTO[] = [];

  constructor(private util: AtendimentoUtil) {
    this.listaAtendimentos = this.gerarListaAtendimentos();

    this.listaAtendimentos.forEach((atendimento: Atendimento) => {
      this.atendimentos.push(this.util.converterToListDTO(atendimento))
    })
  }

  getDadosFormulario(form: any) {
    const [ano, mes, dia] = form.data.split('-');
    // console.log('dados recebidos no service: ', form);

    // Meses são 0-based, então subtraímos 1
    const data = new Date(Number(ano), Number(mes) - 1, Number(dia)); 
    const id = this.gerarIdAtendimento();

    let atendimento: Atendimento = new Atendimento(
      id,
      form.nomeTutor,
      form.nomePet,
      data,
      form.tipo,
      form.observacao,
      form.raca
    );

    this.listaAtendimentos.push(atendimento);

    let formDTO: AtendimentoListDTO = this.util.converterToListDTO(atendimento);
    this.atendimentos.push(formDTO);
  }

  getAtendimentoById(id: number): Atendimento | undefined {
    let atendimento: Atendimento | undefined = this.listaAtendimentos
      .find((atendimento: Atendimento) => atendimento.id === id
    );

    // console.log('atendimento: ', atendimento);
    return atendimento;
  }

  gerarIdAtendimento(): number {
    let id: number = 1;

    if (this.listaAtendimentos.length == 0) {
      return id;
    }

    this.listaAtendimentos.forEach((atendimento: Atendimento) => {
      if (atendimento.id > id) {
        id = atendimento.id;
      }
    })

    return id + 1;
  }

  gerarListaAtendimentos(): Atendimento[] {
    let atendimentos: Atendimento[] = [];
    let atendimento: Atendimento = new Atendimento(
      this.gerarIdAtendimento(), 'Maria', 
      'Paçoca', new Date(2024, 2, 23), 1, 
      'Vacinado, castrado', 'exotico'
    );

    atendimentos.push(atendimento);

    atendimento = new Atendimento(
      this.gerarIdAtendimento(), 'José', 
      'Bolacha', new Date(2024, 2, 20), 1, 
      'Vacinado', 'bengal'
    );

    atendimentos.push(atendimento);

    atendimento = new Atendimento(
      this.gerarIdAtendimento(), 'Ana', 
      'Pipoca', new Date(2024, 2, 18), 2, 
      'Não Vacinado', 'buldogue'
    );

    atendimentos.push(atendimento);

    atendimento = new Atendimento(
      this.gerarIdAtendimento(), 'João', 
      'Bisteca', new Date(2024, 2, 10), 1, 
      'Vacinado, castrado', 'sianês'
    );

    atendimentos.push(atendimento);

    atendimento = new Atendimento(
      this.gerarIdAtendimento(), 'Antônio', 
      'Bisteca', new Date(2024, 2, 5), 2, 
      'Vacinado', 'labrador'
    );

    atendimentos.push(atendimento);

    atendimento = new Atendimento(
      this.gerarIdAtendimento(), 'Juliana', 
      'Cacau', new Date(2024, 1, 23), 2, 
      'Vacinado, castrado', 'poodle'
    );

    atendimentos.push(atendimento);

    atendimento = new Atendimento(
      this.gerarIdAtendimento(), 'Juliana', 
      'Cacau', new Date(2023, 12, 20), 2, 
      'Vacinado', 'poodle'
    );

    atendimentos.push(atendimento);

    return atendimentos;
  }
}