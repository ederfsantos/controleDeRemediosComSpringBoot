package com.remedios.eder.curso.remedios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.remedios.eder.curso.remedios.usuarios.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	UserDetails findByLogin(String login);

}
