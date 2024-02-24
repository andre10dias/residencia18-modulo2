import { Component, EventEmitter, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { BancoService } from '../../../../service/banco.service';
import { TipoEnum } from '../../../../enum/tipo-enum';

@Component({
  selector: 'app-atendimentos-form',
  templateUrl: './atendimentos-form.component.html',
  styleUrl: './atendimentos-form.component.css'
})
export class AtendimentosFormComponent {
  @Output() 
  emiteFormulario: EventEmitter<string> = new EventEmitter<string>();

  atendimentosForm: FormGroup;
  tipos: any[] = this.service.tipo;
  racas: any[] = [];

  constructor(private service: BancoService) {
    this.atendimentosForm = new FormGroup({
      'nomeTutor': new FormControl(null, Validators.required),
      'nomePet': new FormControl(null, Validators.required),
      'data': new FormControl(null, Validators.required),
      'tipo': new FormControl(null, Validators.required),
      'raca': new FormControl(null, Validators.required),
      'observacao': new FormControl(null, Validators.required)
    });
  }

  changeTipo(tipo: string) {
    this.racas = [];

    if (tipo == TipoEnum.GATO) {
      this.racas = this.service.racaGato;
    } 
    else if (tipo == TipoEnum.CACHORRO) {
      this.racas = this.service.racaCachorro;
    }
  }

  onSubmit() {
    if (this.atendimentosForm.valid) {
      this.emiteFormulario.emit(this.atendimentosForm.value);
    }
  }

}