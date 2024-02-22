package com.redesocial.controller.form;

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
public class UserForm {
	private String nome;
	private String email;
	private String senha;
	
	public Usuario toUsuario() {
		return new Usuario(null, nome, email, senha);
	}
}
