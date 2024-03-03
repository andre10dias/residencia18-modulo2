import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable, Subject, map } from 'rxjs';

import { AtendimentoUtil } from '../util/atendimento.util';

import { TipoDescricaoEnum, TipoEnum } from '../enum/tipo-enum';
import { AtendimentoListDTO } from '../model/atendimento/atendimento-list.dto';
import { Atendimento } from '../model/atendimento/atendimento';
import { AtendimentoCreateDTO } from '../model/atendimento/atendimento-create.dto';
import { AtendimentoEditDTO } from '../model/atendimento/atendimento-edit.dto.';

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
  
  private novoAtendimentoSubject = new Subject<any>();
  private novoAtendimento: AtendimentoListDTO = {} as AtendimentoListDTO;
  private _atendimentoAtualizado: AtendimentoListDTO = {} as AtendimentoListDTO;

  novoAtendimentoAdicionado() {
    setTimeout(() => {
      // console.log('[atendimentos.component] novoAtendimentoObservable: ', this.novoAtendimento);
      this.novoAtendimentoSubject.next(this.novoAtendimento);
    }, 1000);
  }

  get novoAtendimentoObservable() {
    return this.novoAtendimentoSubject.asObservable();
  }

  get atendimentoAtualizado() {
    return this._atendimentoAtualizado;
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
    // return this.http.get<Atendimento>(`${this.baseUrl}/atendimento/${id}.json`);
    return this.http.get<Atendimento>(`${this.baseUrl}/atendimento/${id}.json`).pipe(
      map((data: any) => {
        data.id = data.name;
        console.log('getAtendimentoById: ', data);
        return data as Atendimento;
      })
    );
  }

  receberDadosFormulario(form: any): void {
    const [ano, mes, dia] = form.dataAtendimento.split('-');
    // console.log('dados recebidos no service: ', form);

    // Meses são 0-based, então subtraímos 1
    const data = new Date(Number(ano), Number(mes) - 1, Number(dia)); 

    let atendimentoCreate: AtendimentoCreateDTO = {
      id: null,
      nomeTutor: form.nomeTutor,
      nomePet: form.nomePet,
      dataAtendimento: data,
      tipo: form.tipo,
      observacao: form.observacao,
      raca: form.raca,
      createAt: new Date(),
      updateAt: null
    }

    this.http.post(`${this.baseUrl}/atendimento.json`, atendimentoCreate).subscribe({
      next: (data: any) => {
        this.novoAtendimento = {
          id: data.name,
          nomeTutor: atendimentoCreate.nomeTutor,
          nomePet: atendimentoCreate.nomePet,
          dataAtendimento: this.util.formatarData(atendimentoCreate.dataAtendimento, 'dd/MM/yyyy'),
          raca: atendimentoCreate.raca
        };
      },
      error: (error: any) => {
        console.log('error: ', error)
      }
    });
  }

  receberDadosFormularioEdit(form: any): void {
    const [ano, mes, dia] = form.dataAtendimento.split('-');
    // console.log('dados recebidos no service: ', form);

    // Meses são 0-based, então subtraímos 1
    const data = new Date(Number(ano), Number(mes) - 1, Number(dia)); 

    let atendimentoEdit: AtendimentoEditDTO = {
      id: form.id,
      nomeTutor: form.nomeTutor,
      nomePet: form.nomePet,
      dataAtendimento: data,
      tipo: form.tipo,
      observacao: form.observacao,
      raca: form.raca,
      updateAt: new Date()
    }

    this.http.put(`${this.baseUrl}/atendimento/${form.id}.json`, atendimentoEdit).subscribe({
      next: (data: any) => {
        this._atendimentoAtualizado = {
          id: data.name,
          nomeTutor: atendimentoEdit.nomeTutor,
          nomePet: atendimentoEdit.nomePet,
          dataAtendimento: this.util.formatarData(atendimentoEdit.dataAtendimento, 'dd/MM/yyyy'),
          raca: atendimentoEdit.raca
        };
      },
      error: (error: any) => {
        console.log('error: ', error)
      }
    });
  }

  deleteAtendimento(id: string) {
    return this.http.delete(`${this.baseUrl}/atendimento/${id}.json`).subscribe({
      next: (data: any) => {
        console.log(data);
      },
      error: (error: any) => {
        console.log('error: ', error);
      }
    });
  }

}