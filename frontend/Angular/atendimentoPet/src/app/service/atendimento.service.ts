import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable, Subject, map } from 'rxjs';

import { AtendimentoUtil } from '../util/atendimento.util';

import { TipoDescricaoEnum, TipoEnum } from '../enum/tipo-enum';
import { AtendimentoListDTO } from '../model/atendimento/atendimento-list.dto';
import { Atendimento } from '../model/atendimento/atendimento';
import { AtendimentoCreateDTO } from '../model/atendimento/atendimento-create.dto';

@Injectable({
  providedIn: 'root'
})
export class AtendimentoService {
  baseUrl = 'https://atendimento-pet-default-rtdb.firebaseio.com';

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

  private novoAtendimentoSubject = new Subject<AtendimentoListDTO>();
  private novoAtendimento: AtendimentoListDTO = {} as AtendimentoListDTO;

  novoAtendimentoAdicionado() {
    setTimeout(() => {
      // console.log('[atendimentos.component] novoAtendimentoObservable: ', this.novoAtendimento);
      this.novoAtendimentoSubject.next(this.novoAtendimento);
    }, 1000);
  }

  get novoAtendimentoObservable() {
    return this.novoAtendimentoSubject.asObservable();
  }

  constructor(
    private http: HttpClient,
    private util: AtendimentoUtil
  ) {
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

  receberDadosFormulario(form: any): void {
    const [ano, mes, dia] = form.data.split('-');
    // console.log('dados recebidos no service: ', form);

    // Meses são 0-based, então subtraímos 1
    const data = new Date(Number(ano), Number(mes) - 1, Number(dia)); 

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

    // let atendimento: AtendimentoListDTO;

    this.http.post(`${this.baseUrl}/atendimento.json`, atendimentoCreate).subscribe({
      next: (data: any) => {
        this.novoAtendimento = {
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

}