package com.aeroporto.aeroporto.controller.dto;

import com.aeroporto.aeroporto.model.Aeroporto;

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
public class AeroportoDTO {
	private Long id;
	private String icao;
	private String nome;
	
	public AeroportoDTO(Aeroporto a) {
		this.id = a.getId();
		this.icao = a.getIcao();
		this.nome = a.getNome();
	}
}
