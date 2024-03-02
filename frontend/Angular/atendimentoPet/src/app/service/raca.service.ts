import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { AtendimentoUtil } from '../util/atendimento.util';
import { RacaCreateDTO } from '../model/raca/raca-create.dto';
import { RacaListDTO } from '../model/raca/raca-list.dto';

@Injectable({
  providedIn: 'root'
})
export class RacaService {
  baseUrl = '';

  listaRacas: RacaListDTO[] = [];

  constructor(
    private http: HttpClient,
    private util: AtendimentoUtil
  ) { }
  
  receberDadosFormulario(form: any) {
    let racaCreate: RacaCreateDTO = {
      nome: form.nome,
      tipo: form.tipo,
      createAt: new Date(),
      updateAt: null
    }

    console.log('racaCreate: ', racaCreate);
    let raca: RacaListDTO;

    this.http.post(`${this.baseUrl}/raca.json`, racaCreate).subscribe({
      next: (data: any) => {
        console.log(data);
        raca = {
          id: data.name,
          nome: racaCreate.nome,
          tipo: racaCreate.tipo,
          createAt: this.util.formatarData(racaCreate.createAt, 'dd/MM/yyyy')
        };

        this.listaRacas.push(raca);
      },
      error: (error: any) => {
        console.log('error: ', error)
      }
    });
  }

}
