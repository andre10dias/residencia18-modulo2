import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';

import { AtendimentoUtil } from '../util/atendimento.util';
import { RacaCreateDTO } from '../model/raca/raca-create.dto';
import { RacaListDTO } from '../model/raca/raca-list.dto';
import { RacaTipoDTO } from '../model/raca/raca-tipo.dto';
import { FirebaseCredentials } from '../model/firebase/firebase-credentials';

@Injectable({
  providedIn: 'root'
})
export class RacaService {
  fire: FirebaseCredentials = new FirebaseCredentials();
  baseUrl: string = `${this.fire.baseUrl}/raca`;

  private novaRaca: RacaListDTO = {} as RacaListDTO;

  constructor(
    private http: HttpClient,
    private util: AtendimentoUtil
  ) { }

  getAllRacas(): Observable<RacaTipoDTO[]> {
    return this.http.get<{ [key: string]: RacaTipoDTO }>(`${this.baseUrl}.json`).pipe(
      map(data => {
        const listaRacas: RacaTipoDTO[] = [];

        for (const key in data) {
          if (data.hasOwnProperty(key)) {
            listaRacas.push({ ...(data as any)[key], id: key });
          }
        }

        return listaRacas;
      })
    );
  }

  receberDadosFormulario(form: any): void {
    // const [ano, mes, dia] = form.dataAtendimento.split('-');
    // console.log('dados recebidos no service: ', form);

    // Meses são 0-based, então subtraímos 1
    // const data = new Date(Number(ano), Number(mes) - 1, Number(dia)); 

    // let racas = this.getTipo1();

    // racas.forEach(form => {
      let racaCreate: RacaCreateDTO = {
        id: null,
        nome: form.nome,
        tipo: form.tipo,
        createAt: new Date(),
        updateAt: null
      }
  
      this.http.post(`${this.baseUrl}?tipo=1.json`, racaCreate).subscribe({
        next: (data: any) => {
          this.novaRaca = {
            id: data.name,
            nome: racaCreate.nome,
            tipo: racaCreate.tipo
          };
        },
        error: (error: any) => {
          console.log('error: ', error)
        }
      });
    // });
  }

  getRacasByTipo(tipo: number): Observable<RacaTipoDTO[]> {
    return this.getAllRacas().pipe(
      map(data => {
        return data.filter(raca => raca.tipo === tipo);
      })
    );
  }

  // getTipo1(): RacaCreateDTO[] {
  //   let racas: RacaCreateDTO[] = [];

  //   let racaCreate1: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Angorá',
  //     tipo: 1,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate1);

  //   let racaCreate2: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Bengal',
  //     tipo: 1,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate2);

  //   let racaCreate3: RacaCreateDTO = {
  //     id: null,
  //     nome: 'British Shorthair',
  //     tipo: 1,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate3);

  //   let racaCreate4: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Exótico',
  //     tipo: 1,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate4);

  //   let racaCreate5: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Persa',
  //     tipo: 1,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate5);

  //   let racaCreate6: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Ragdoll',
  //     tipo: 1,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate6);

  //   let racaCreate7: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Siamês',
  //     tipo: 1,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate7);

  //   let racaCreate8: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Sphynx',
  //     tipo: 1,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate8);

  //   return racas;
  // }

  // getTipo2(): RacaCreateDTO[] {
  //   let racas: RacaCreateDTO[] = [];

  //   let racaCreate9: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Buldogue',
  //     tipo: 2,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate9);

  //   let racaCreate10: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Dachshund',
  //     tipo: 2,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate10);

  //   let racaCreate11: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Pastor Alemão',
  //     tipo: 2,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate11);

  //   let racaCreate12: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Poodle',
  //     tipo: 2,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate12);

  //   let racaCreate13: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Labrador',
  //     tipo: 2,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate13);

  //   let racaCreate14: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Rottweiler',
  //     tipo: 2,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate14);

  //   return racas;
  // }

  // private getListaRacas(): RacaCreateDTO[] {
  //   let racas: RacaCreateDTO[] = [];

  //   let racaCreate1: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Angorá',
  //     tipo: 1,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate1);

  //   let racaCreate2: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Bengal',
  //     tipo: 1,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate2);

  //   let racaCreate3: RacaCreateDTO = {
  //     id: null,
  //     nome: 'British Shorthair',
  //     tipo: 1,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate3);

  //   let racaCreate4: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Exótico',
  //     tipo: 1,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate4);

  //   let racaCreate5: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Persa',
  //     tipo: 1,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate5);

  //   let racaCreate6: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Ragdoll',
  //     tipo: 1,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate6);

  //   let racaCreate7: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Siamês',
  //     tipo: 1,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate7);

  //   let racaCreate8: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Sphynx',
  //     tipo: 1,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate8);

  //   let racaCreate9: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Buldogue',
  //     tipo: 2,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate9);

  //   let racaCreate10: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Dachshund',
  //     tipo: 2,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate10);

  //   let racaCreate11: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Pastor Alemão',
  //     tipo: 2,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate11);

  //   let racaCreate12: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Poodle',
  //     tipo: 2,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate12);

  //   let racaCreate13: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Labrador',
  //     tipo: 2,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate13);

  //   let racaCreate14: RacaCreateDTO = {
  //     id: null,
  //     nome: 'Rottweiler',
  //     tipo: 2,
  //     createAt: new Date(),
  //     updateAt: null
  //   }

  //   racas.push(racaCreate14);

  //   return racas;

  // }

  // getRacasByTipo(tipo: number): Observable<RacaTipoDTO[]> {
  //   return this.http.get<RacaTipoDTO[]>(`${this.baseUrl}.json`, {
  //     params: { tipo: tipo.toString() }
  //   }).pipe(
  //     map((data: any) => {
  //       console.log('data: ', data);
  //       // Transforma o objeto em um array de objetos
  //       return Object.values(data) as RacaTipoDTO[];
  //     })
  //   );
  // }

  // getRacasByTipo(tipo: number): Observable<RacaTipoDTO[]> {
  //   const params = new HttpParams().set('tipo', tipo.toString());

  //   return this.http.get<RacaTipoDTO[]>(`${this.baseUrl}.json`, { params }).pipe(
  //     map((data: any) => {
  //       console.log('data: ', data);
  //       return data as RacaTipoDTO[];
  //     })
  //   );
  // }

}
