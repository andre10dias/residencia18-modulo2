import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

import { Observable, map } from 'rxjs';

import { TipoDescricaoEnum, TipoEnum } from '../enum/tipo-enum';
import { AtendimentoListDTO } from '../model/atendimento/atendimento-list.dto';
import { Atendimento } from '../model/atendimento/atendimento';
import { AtendimentoUtil } from '../util/atendimento.util';
import { AtendimentoCreateDTO } from '../model/atendimento/atendimento-create.dto';

@Injectable({
  providedIn: 'root'
})
export class AtendimentoService {
  baseUrl = 'https://atendimento-pet-default-rtdb.firebaseio.com';
  // https://atendimento-pet-default-rtdb.firebaseio.com/atendimento/-NrsIkBG1c-ZA29c9lSb
  // https://atendimento-pet-default-rtdb.firebaseio.com/atendimento

  tipo: any[] = [
    {value: '', viewValue: 'Selecione...'},
    {value: TipoEnum.GATO, viewValue: TipoDescricaoEnum.GATO},
    {value: TipoEnum.CACHORRO, viewValue: TipoDescricaoEnum.CACHORRO},
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

  // listaAtendimentos: AtendimentoListDTO[] = [];
  // atendimentos: AtendimentoListDTO[] = [];
  listaAtendimentos: Atendimento[] = [];

  constructor(
    private http: HttpClient,
    private util: AtendimentoUtil
  ) {
    // this.listaAtendimentos = this.gerarListaAtendimentos();

    // this.listaAtendimentos.forEach((atendimento: Atendimento) => {
    //   this.atendimentos.push(this.util.converterToListDTO(atendimento))
    // })
    this.getAllAtendimentos().subscribe({
      next: atendimentos => {
        this.listaAtendimentos = atendimentos;
      },
      error: error => {
        console.error('Erro ao carregar atendimentos:', error);
      }
    });
  }

  getAllAtendimentos(): Observable<Atendimento[]> {
    return this.http.get<{ [key: string]: Atendimento }>(`${this.baseUrl}/atendimento.json`).pipe(
      map(data => {
        const listaAtendimento: Atendimento[] = [];
        for (const key in data) {
          if (data.hasOwnProperty(key)) {
            listaAtendimento.push({ ...(data as any)[key], id: key });
          }
        }
        return listaAtendimento;
      })
    );
  }

  getAtendimentoById(id: string): Observable<Atendimento> {
    return this.http.get<Atendimento>(`${this.baseUrl}/atendimento/${id}.json`);
  }

  // private getListaAtendimentos(id?: string): Observable<Atendimento[]> {
  //   let url = `${this.baseUrl}/atendimento.json`;

  //   if (id) {
  //       url += `?name=${id}`;
  //   }

  //   return this.http.get<{ [key: string]: Atendimento }>(url)
  //       .pipe(
  //           map(data => {
  //               const listaAtendimento: Atendimento[] = [];

  //               for (const key in data) {
  //                   if (data.hasOwnProperty(key)) {
  //                       listaAtendimento.push({ ...(data as any)[key], id: key });
  //                   }
  //               }

  //               return listaAtendimento;
  //           })
  //       );
  // }

  receberDadosFormulario(form: any) {
    const [ano, mes, dia] = form.data.split('-');
    // console.log('dados recebidos no service: ', form);

    // Meses são 0-based, então subtraímos 1
    const data = new Date(Number(ano), Number(mes) - 1, Number(dia)); 
    // const id = this.gerarIdAtendimento();

    let atendimentoCreate: AtendimentoCreateDTO = {
      nomeTutor: form.nomeTutor,
      nomePet: form.nomePet,
      dataAtendimento: data,
      tipo: form.tipo,
      observacao: form.observacao,
      raca: form.raca,
      createAt: new Date(),
      updateAt: null
    }

    console.log('atendimentoCreate: ', atendimentoCreate);
    let atendimento: AtendimentoListDTO;

    this.http.post(`${this.baseUrl}/atendimento.json`, atendimentoCreate).subscribe({
      next: (data: any) => {
        console.log(data);
        atendimento = {
          id: data.name,
          nomeTutor: atendimentoCreate.nomeTutor,
          nomePet: atendimentoCreate.nomePet,
          dataAtendimento: this.util.formatarData(atendimentoCreate.dataAtendimento, 'dd/MM/yyyy'),
          raca: atendimentoCreate.raca
        };

        // this.listaAtendimentos.push(atendimento);
      },
      error: (error: any) => {
        console.log('error: ', error)
      }
    });
  }

  // gerarIdAtendimento(): number {
  //   let id: number = 1;

  //   if (this.listaAtendimentos.length == 0) {
  //     return id;
  //   }

  //   this.listaAtendimentos.forEach((atendimento: Atendimento) => {
  //     if (atendimento.id > id) {
  //       id = atendimento.id;
  //     }
  //   })

  //   return id + 1;
  // }

  // gerarListaAtendimentos(): Atendimento[] {
  //   let atendimentos: Atendimento[] = [];
  //   let atendimento: Atendimento = new Atendimento(
  //     this.gerarIdAtendimento(), 'Maria', 
  //     'Paçoca', new Date(2024, 2, 23), 1, 
  //     'Vacinado, castrado', 'exotico'
  //   );

  //   atendimentos.push(atendimento);

  //   atendimento = new Atendimento(
  //     this.gerarIdAtendimento(), 'José', 
  //     'Bolacha', new Date(2024, 2, 20), 1, 
  //     'Vacinado', 'bengal'
  //   );

  //   atendimentos.push(atendimento);

  //   atendimento = new Atendimento(
  //     this.gerarIdAtendimento(), 'Ana', 
  //     'Pipoca', new Date(2024, 2, 18), 2, 
  //     'Não Vacinado', 'buldogue'
  //   );

  //   atendimentos.push(atendimento);

  //   atendimento = new Atendimento(
  //     this.gerarIdAtendimento(), 'João', 
  //     'Bisteca', new Date(2024, 2, 10), 1, 
  //     'Vacinado, castrado', 'sianês'
  //   );

  //   atendimentos.push(atendimento);

  //   atendimento = new Atendimento(
  //     this.gerarIdAtendimento(), 'Antônio', 
  //     'Bisteca', new Date(2024, 2, 5), 2, 
  //     'Vacinado', 'labrador'
  //   );

  //   atendimentos.push(atendimento);

  //   atendimento = new Atendimento(
  //     this.gerarIdAtendimento(), 'Juliana', 
  //     'Cacau', new Date(2024, 1, 23), 2, 
  //     'Vacinado, castrado', 'poodle'
  //   );

  //   atendimentos.push(atendimento);

  //   atendimento = new Atendimento(
  //     this.gerarIdAtendimento(), 'Juliana', 
  //     'Cacau', new Date(2023, 12, 20), 2, 
  //     'Vacinado', 'poodle'
  //   );

  //   atendimentos.push(atendimento);

  //   return atendimentos;
  // }
}