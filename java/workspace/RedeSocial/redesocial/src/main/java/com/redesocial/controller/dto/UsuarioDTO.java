package com.redesocial.controller.dto;

import com.redesocial.modelo.Usuario;

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
public class UsuarioDTO {
	private Long id;
	private String nome;
	private String email;
	
	public UsuarioDTO(Usuario usuario) {
		id = usuario.getId();
		nome = usuario.getNome();
		email = usuario.getEmail();
	}
}
