package com.aeroporto.aeroporto.controller.form;

import com.aeroporto.aeroporto.model.Piloto;
import com.aeroporto.aeroporto.repository.PilotoRepository;

public class PilotoForm {
	private String nome;
	private String numBreve;
	
	public Piloto toPiloto() {
		return new Piloto(null, numBreve, nome);
	}
	
	public Piloto atualizar(Long id, PilotoRepository repository) {
		Piloto piloto = repository.getReferenceById(id);
		piloto.setNome(this.nome);
		piloto.setNumBreve(this.numBreve);
		
		return piloto;
	}
}
