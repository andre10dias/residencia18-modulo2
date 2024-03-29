package com.redesocial.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

import com.redesocial.controller.dto.UsuarioDTO;
import com.redesocial.controller.form.AtualizarUserForm;
import com.redesocial.controller.form.UserForm;
import com.redesocial.modelo.Usuario;
import com.redesocial.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository repository;
	
	private Integer valor = 99;
	private Integer sequencia = 1;
	private Integer primo = 2;
	
	@GetMapping()
	public List<Usuario> listarUsuarios() {
		return repository.findAll();
	}
	
	@PostMapping()
	public ResponseEntity<UsuarioDTO> inserir(@RequestBody UserForm form, UriComponentsBuilder uriBuilder) {
		Usuario u = form.toUsuario();
		repository.save(u);
		
		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(u.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDTO(u));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id) {
		try {			
			var usuarioDto = repository.getReferenceById(id);
			return ResponseEntity.ok(new UsuarioDTO(usuarioDto));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long id, @RequestBody AtualizarUserForm form) {
		Optional<Usuario> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			Usuario usuario = form.atualizar(id, repository);
			return ResponseEntity.ok(new UsuarioDTO(usuario));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Usuario> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@RequestMapping("/valor")
	public Integer getValor() {
		return valor;
	}
	
	@RequestMapping("/aleatorio")
	public Integer numerosAleatorios() {
		Random r = new Random();
		return r.nextInt();
	}
	
	@RequestMapping("/sequencia")
	public Integer sequencia() {
		return sequencia++;
	}
	
	@RequestMapping("/primos")
	public Integer sequenciaPrimos() {
		int count = 0;
		int i;
		
		for (i = 1; i < primo; i++) {
			count = 0;
			
			if (primo % i == 0) {
				count++;
			}
		}
		
		if (count == 2) {
			primo = i;
		}
		
		return primo;
	}
	
}
