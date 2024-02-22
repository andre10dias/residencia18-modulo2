package com.aeroporto.aeroporto.controller.dto;

import com.aeroporto.aeroporto.model.Piloto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PilotoDTO {
	private Long id;
	private String nome;
	private String numBreve;
	
	public PilotoDTO(Piloto p) {
		this.id = p.getId();
		this.nome = p.getNome();
		this.numBreve = p.getNumBreve();
	}
}
