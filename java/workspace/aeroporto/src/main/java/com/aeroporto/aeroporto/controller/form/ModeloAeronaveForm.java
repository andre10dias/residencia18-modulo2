package com.aeroporto.aeroporto.controller.form;

import com.aeroporto.aeroporto.model.ModeloAeronave;
import com.aeroporto.aeroporto.repository.ModeloAeronaveRepository;

public class ModeloAeronaveForm {
	private String fabricante;
	private String nome;
	
	public ModeloAeronave toModeloAeronave() {
		return new ModeloAeronave(null, fabricante, nome);
	}
	
	public ModeloAeronave atualizar(Long id, ModeloAeronaveRepository repository) {
		ModeloAeronave modeloAeronave = repository.getReferenceById(id);
		modeloAeronave.setFabricante(this.fabricante);
		modeloAeronave.setNome(this.nome);
		
		return modeloAeronave;
	}

}
