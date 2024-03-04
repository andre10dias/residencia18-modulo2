import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

import { AtendimentoService } from '../../../../service/atendimento.service';

import { TipoEnum } from '../../../../enum/tipo-enum';
import { RacaService } from '../../../../service/raca.service';

@Component({
  selector: 'app-atendimentos-form',
  templateUrl: './atendimentos-form.component.html',
  styleUrl: './atendimentos-form.component.css'
})
export class AtendimentosFormComponent implements OnInit {
  @Output() emiteFormulario: EventEmitter<string> = new EventEmitter<string>();
  @Input() dadosItemSelecionado: any;

  atendimentosForm: FormGroup;
  tipos: any[] = this.atendimentoService.tipo;
  racas: any[] = [];
  btnText: string = 'Salvar';

  constructor(
    private racaService: RacaService,
    private atendimentoService: AtendimentoService
  ) {
    this.atendimentosForm = new FormGroup({
      'id': new FormControl(null),
      'nomeTutor': new FormControl(null, Validators.required),
      'nomePet': new FormControl(null, Validators.required),
      'dataAtendimento': new FormControl(null, Validators.required),
      'tipo': new FormControl(null, Validators.required),
      'raca': new FormControl(null, Validators.required),
      'observacao': new FormControl(null, Validators.required)
    });
  }

  ngOnInit(): void {
    // console.log('[atendimentos-form] dadosItemSelecionado: ', this.dadosItemSelecionado);
    if (this.dadosItemSelecionado) {
      this.atendimentosForm.patchValue({
        'id': this.dadosItemSelecionado.id,
        'nomeTutor': this.dadosItemSelecionado.nomeTutor,
        'nomePet': this.dadosItemSelecionado.nomePet,
        'dataAtendimento': this.dadosItemSelecionado.dataAtendimento,
        'tipo': this.dadosItemSelecionado.tipo,
        'raca': this.dadosItemSelecionado.raca,
        'observacao': this.dadosItemSelecionado.observacao
      });
      this.changeTipo(this.dadosItemSelecionado.tipo);
      this.btnText = 'Editar';
    }
  }

  changeTipo(tipo: number) {
    this.racas = [];

    this.racaService.getRacasByTipo(tipo).subscribe({
      next: (data: any) => {
        // console.log('data: ', data);
        this.racas = data;
      },
      error: (error: any) => {
        console.log('error: ', error)
      }
    });
  }

  onSubmit() {
    if (this.atendimentosForm.valid) {
      // console.log('[atendimentos-form] this.atendimentosForm.value: ', this.atendimentosForm.value);
      this.emiteFormulario.emit(this.atendimentosForm.value);
    }
  }

}