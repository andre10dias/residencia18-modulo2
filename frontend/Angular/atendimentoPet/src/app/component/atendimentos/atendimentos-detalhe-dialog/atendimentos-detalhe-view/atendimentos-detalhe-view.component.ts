import { Component, Input, OnInit } from '@angular/core';
import { AtendimentoFormDTO } from '../../../../model/atendimento/atendimento-form.dto';
import { AtendimentoDetailDTO } from '../../../../model/atendimento/atendimento-detail.dto';
import { ImagemService } from '../../../../service/imagem.service';
import { ImagemPet } from '../../../../model/imagem/imagem-pet';

@Component({
  selector: 'app-atendimentos-detalhe-view',
  templateUrl: './atendimentos-detalhe-view.component.html',
  styleUrl: './atendimentos-detalhe-view.component.css'
})
export class AtendimentosDetalheViewComponent implements OnInit {
  @Input() dadosItemSelecionado: AtendimentoFormDTO = {} as AtendimentoFormDTO;

  form: AtendimentoDetailDTO = {} as AtendimentoDetailDTO;
  imgUrl: string = '';

  constructor(private service: ImagemService) { }

  ngOnInit(): void {
    if (this.dadosItemSelecionado) {
      let img: ImagemPet = this.service.getImagem(this.dadosItemSelecionado.tipo);

      this.form = {
        id: this.dadosItemSelecionado.id,
        nomeTutor: this.dadosItemSelecionado.nomeTutor,
        nomePet: this.dadosItemSelecionado.nomePet,
        observacao: this.dadosItemSelecionado.observacao,
        raca: this.dadosItemSelecionado.raca,
        imagem: img
      }
    }
  }
}
