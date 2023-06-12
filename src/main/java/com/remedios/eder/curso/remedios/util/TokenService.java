package com.remedios.eder.curso.remedios.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.remedios.eder.curso.remedios.usuarios.Usuario;

@Service
public class TokenService {

	public String gerarToken(Usuario usuario) {

		try {
			var algorithm = Algorithm.HMAC256("654321");
			return JWT.create().withIssuer("Remedios_api").withSubject(usuario.getLogin())
					.withExpiresAt(dataExpiracao()).sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new RuntimeException("Erro ao gerar token", exception);
		}
	}

	private Instant dataExpiracao() {

		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}
