package com.remedios.eder.curso.remedios.util;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
// um filtro por requisição  tradução da classe herdada acima
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		var tokenJWT = recuperarToken(request);
		System.out.println(tokenJWT);

		filterChain.doFilter(request, response);

	}

	private String recuperarToken(HttpServletRequest request) {
		// TODO Auto-generated method stub
		var autorizacaoHeader = request.getHeader("Authorization");
		if (autorizacaoHeader == null) {
			throw new RuntimeException("Token não enviado!");
		}
		return autorizacaoHeader;
	}

}
