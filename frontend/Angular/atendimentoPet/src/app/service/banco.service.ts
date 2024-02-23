import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BancoService {
  tipo: any[] = [
    {value: '', viewValue: 'Selecione...'},
    {value: 'gato', viewValue: 'Gato'},
    {value: 'cachorro', viewValue: 'Cachorro'},
  ];

  racaGato: any[] = [
    {value: '', viewValue: 'Selecione...'},
    {value: 'angora', viewValue: 'Angorá'},
    {value: 'bengal', viewValue: 'Bengal'},
    {value: 'british', viewValue: 'British shorthair'},
    {value: 'persa', viewValue: 'Persa'},
    {value: 'exotico', viewValue: 'Exótico'},
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
    {value: 'rottweiler', viewValue: 'Rottweiler'},
    {value: 'labrador', viewValue: 'Labrador'}
  ];

  constructor() { }
}
