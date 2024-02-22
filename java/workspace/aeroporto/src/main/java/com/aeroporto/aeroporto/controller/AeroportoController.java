package com.aeroporto.aeroporto.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		
		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(aeroporto.getId()).toUri();
		return ResponseEntity.created(uri).body(new AeroportoDTO(aeroporto));
	}

}