package com.aeroporto.aeroporto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.aeroporto.aeroporto.controller.dto.ModeloAeronaveDTO;
import com.aeroporto.aeroporto.controller.form.ModeloAeronaveForm;
import com.aeroporto.aeroporto.model.ModeloAeronave;
import com.aeroporto.aeroporto.repository.ModeloAeronaveRepository;

@RestController
@RequestMapping("/modelos")
public class ModeloAeronaveController {
	
	@Autowired
	ModeloAeronaveRepository repository;
	
	@GetMapping
	public List<ModeloAeronave> listarModeloAeronaves() {
		List<ModeloAeronave> listaModeloAeronaves = repository.findAll();
		return listaModeloAeronaves;
	}
	
	@PostMapping()
	public ResponseEntity<ModeloAeronaveDTO> cadastrar(@RequestBody ModeloAeronaveForm form, UriComponentsBuilder uriBuilder) {
		ModeloAeronave modeloAeronave = form.toModeloAeronave();
		repository.save(modeloAeronave);
		
		URI uri = uriBuilder.path("/modeloAeronave/{id}").buildAndExpand(modeloAeronave.getId()).toUri();
		return ResponseEntity.created(uri).body(new ModeloAeronaveDTO(modeloAeronave));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ModeloAeronaveDTO> getModeloAeronaveById(@PathVariable Long id) {
		try {			
			var modeloAeronaveDto = repository.getReferenceById(id);
			return ResponseEntity.ok(new ModeloAeronaveDTO(modeloAeronaveDto));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ModeloAeronaveDTO> atualizar(@PathVariable Long id, @RequestBody ModeloAeronaveForm form) {
		Optional<ModeloAeronave> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			ModeloAeronave modeloAeronave = form.atualizar(id, repository);
			return ResponseEntity.ok(new ModeloAeronaveDTO(modeloAeronave));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<ModeloAeronave> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
