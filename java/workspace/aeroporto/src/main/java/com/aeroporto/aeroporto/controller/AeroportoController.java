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

import com.aeroporto.aeroporto.controller.dto.AeroportoDTO;
import com.aeroporto.aeroporto.controller.form.AeroportoForm;
import com.aeroporto.aeroporto.model.Aeroporto;
import com.aeroporto.aeroporto.repository.AeroportoRepository;

@RestController
@RequestMapping("/aeroportos")
public class AeroportoController {
	
	@Autowired
	AeroportoRepository repository;
	
	@GetMapping
	public List<Aeroporto> listarAeroportos() {
		List<Aeroporto> listaAeroportos = repository.findAll();
		return listaAeroportos;
	}
	
	@PostMapping()
	public ResponseEntity<AeroportoDTO> cadastrar(@RequestBody AeroportoForm form, UriComponentsBuilder uriBuilder) {
		Aeroporto aeroporto = form.toAeroporto();
		repository.save(aeroporto);
		
		URI uri = uriBuilder.path("/aeroporto/{id}").buildAndExpand(aeroporto.getId()).toUri();
		return ResponseEntity.created(uri).body(new AeroportoDTO(aeroporto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AeroportoDTO> getAeroportoById(@PathVariable Long id) {
		try {			
			var aeroportoDto = repository.getReferenceById(id);
			return ResponseEntity.ok(new AeroportoDTO(aeroportoDto));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AeroportoDTO> atualizar(@PathVariable Long id, @RequestBody AeroportoForm form) {
		Optional<Aeroporto> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			Aeroporto aeroporto = form.atualizar(id, repository);
			return ResponseEntity.ok(new AeroportoDTO(aeroporto));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Aeroporto> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}