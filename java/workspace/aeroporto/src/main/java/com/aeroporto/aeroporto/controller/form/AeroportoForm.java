package com.aeroporto.aeroporto.controller.form;

import com.aeroporto.aeroporto.model.Aeroporto;
import com.aeroporto.aeroporto.repository.AeroportoRepository;

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
	
	public Aeroporto atualizar(Long id, AeroportoRepository repository) {
		Aeroporto aeroporto = repository.getReferenceById(id);
		aeroporto.setIcao(this.icao);
		aeroporto.setNome(this.nome);
		
		return aeroporto;
	}
}
