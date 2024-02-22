package com.aeroporto.aeroporto.controller.form;

import com.aeroporto.aeroporto.model.Aeroporto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AeroportoForm {
	private String icao;
	private String nome;
	
	public Aeroporto toAeroporto() {
		return new Aeroporto(null, icao, nome);
	}
}
