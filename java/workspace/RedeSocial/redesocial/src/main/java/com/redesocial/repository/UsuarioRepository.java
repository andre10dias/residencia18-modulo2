package com.redesocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redesocial.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
