package com.remedios.eder.curso.remedios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedios.eder.curso.remedios.records.DadosAutenticacao;
import com.remedios.eder.curso.remedios.records.DadosTokenJWT;
import com.remedios.eder.curso.remedios.service.TokenService;
import com.remedios.eder.curso.remedios.usuarios.Usuario;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager manager;
	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
		var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		var autenticacao = manager.authenticate(token);
		//return ResponseEntity.ok().build();
		//return ResponseEntity.ok(tokenService.gerarToken((Usuario)autenticacao.getPrincipal()));
		var tokenJWT = tokenService.gerarToken((Usuario)autenticacao.getPrincipal());
		
		return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
		
		
	}

	
}
