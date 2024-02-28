package com.redesocial.controller.form;

import com.redesocial.modelo.Usuario;
import com.redesocial.repository.UsuarioRepository;

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
public class AtualizarUserForm {
	private String nome;
	private String email;
	
	public Usuario atualizar(Long id, UsuarioRepository repository) {
		Usuario usuario = repository.getReferenceById(id);
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);
		
		return usuario;
	}
}
