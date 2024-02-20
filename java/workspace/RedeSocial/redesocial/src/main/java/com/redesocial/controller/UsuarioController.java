package com.redesocial.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.redesocial.DTO.UsuarioDTO;


@RestController
public class UsuarioController {
	
	private Integer valor = 99;
	private Integer sequencia = 1;
	private Integer primo = 2;
	
	@RequestMapping("/usuarios")
	public List<UsuarioDTO> listarUsuarios() {
		List<UsuarioDTO> lista = new ArrayList<>();
		
		UsuarioDTO u1 = new UsuarioDTO();
		UsuarioDTO u2 = new UsuarioDTO();
		UsuarioDTO u3 = new UsuarioDTO();
		
		lista.add(u1);
		lista.add(u2);
		lista.add(u3);
		
		return lista;
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
