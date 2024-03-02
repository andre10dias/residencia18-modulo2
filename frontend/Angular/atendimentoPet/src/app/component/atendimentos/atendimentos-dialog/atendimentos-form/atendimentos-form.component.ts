import { Component, ElementRef, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AtendimentoService } from '../../../../service/atendimento.service';
import { AtendimentoUtil } from '../../../../util/atendimento.util';
import { TipoEnum } from '../../../../enum/tipo-enum';

@Component({
  selector: 'app-atendimentos-form',
  templateUrl: './atendimentos-form.component.html',
  styleUrl: './atendimentos-form.component.css'
})
export class AtendimentosFormComponent implements OnInit {
  @Output() emiteFormulario: EventEmitter<string> = new EventEmitter<string>();
  @Input() dadosItemSelecionado: any;

  atendimentosForm: FormGroup;
  tipos: any[] = this.service.tipo;
  racas: any[] = [];
  btnText: string = 'Salvar';

  constructor(private service: AtendimentoService) {
    this.atendimentosForm = new FormGroup({
      'nomeTutor': new FormControl(null, Validators.required),
      'nomePet': new FormControl(null, Validators.required),
      'data': new FormControl(null, Validators.required),
      'tipo': new FormControl(null, Validators.required),
      'raca': new FormControl(null, Validators.required),
      'observacao': new FormControl(null, Validators.required)
    });
  }

  ngOnInit(): void {
    // console.log('[atendimentos-form] dadosItemSelecionado: ', this.dadosItemSelecionado);
    if (this.dadosItemSelecionado) {
      this.atendimentosForm.patchValue({
        'nomeTutor': this.dadosItemSelecionado.nomeTutor,
        'nomePet': this.dadosItemSelecionado.nomePet,
        'data': this.dadosItemSelecionado.data,
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

    if (tipo == TipoEnum.GATO) {
      this.racas = this.service.racaGato;
    } 
    else if (tipo == TipoEnum.CACHORRO) {
      this.racas = this.service.racaCachorro;
    }
  }

  onSubmit() {
    if (this.atendimentosForm.valid) {
      // console.log('[atendimentos-form] this.atendimentosForm.value: ', this.atendimentosForm.value);
      this.emiteFormulario.emit(this.atendimentosForm.value);
    }
  }

}