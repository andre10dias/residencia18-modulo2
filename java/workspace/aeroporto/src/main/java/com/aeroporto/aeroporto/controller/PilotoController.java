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

import com.aeroporto.aeroporto.controller.dto.PilotoDTO;
import com.aeroporto.aeroporto.controller.form.PilotoForm;
import com.aeroporto.aeroporto.model.Piloto;
import com.aeroporto.aeroporto.repository.PilotoRepository;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {
	
	@Autowired
	PilotoRepository repository;
	
	@GetMapping
	public List<Piloto> listarPilotos() {
		List<Piloto> listaPilotos = repository.findAll();
		return listaPilotos;
	}
	
	@PostMapping()
	public ResponseEntity<PilotoDTO> cadastrar(@RequestBody PilotoForm form, UriComponentsBuilder uriBuilder) {
		Piloto piloto = form.toPiloto();
		repository.save(piloto);
		
		URI uri = uriBuilder.path("/piloto/{id}").buildAndExpand(piloto.getId()).toUri();
		return ResponseEntity.created(uri).body(new PilotoDTO(piloto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PilotoDTO> getPilotoById(@PathVariable Long id) {
		try {			
			var pilotoDto = repository.getReferenceById(id);
			return ResponseEntity.ok(new PilotoDTO(pilotoDto));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PilotoDTO> atualizar(@PathVariable Long id, @RequestBody PilotoForm form) {
		Optional<Piloto> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			Piloto piloto = form.atualizar(id, repository);
			return ResponseEntity.ok(new PilotoDTO(piloto));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Piloto> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
