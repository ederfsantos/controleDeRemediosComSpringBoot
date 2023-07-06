package com.remedios.eder.curso.remedios.util;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.remedios.eder.curso.remedios.repositorios.UsuarioRepository;
import com.remedios.eder.curso.remedios.service.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	
	@Autowired
	private TokenService tokenService;
	@Autowired
	private UsuarioRepository repository;
	
	
// um filtro por requisição  tradução da classe herdada acima
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		var tokenJWT = recuperarToken(request);
		//System.out.println(tokenJWT);
		if(tokenJWT!=null) {
		var subject = tokenService.getSubject(tokenJWT);
		var usuario = repository.findByLogin(subject);
		var authentication = new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		filterChain.doFilter(request, response);

	}

	private String recuperarToken(HttpServletRequest request) {
		// TODO Auto-generated method stub
		var autorizacaoHeader = request.getHeader("Authorization");
		if (autorizacaoHeader != null) {
			//throw new RuntimeException("Token não enviado!");
			return autorizacaoHeader;
		}
		return null;
	}

}
