package com.remedios.eder.curso.remedios.util;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErros {
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> tratador404() {
		return ResponseEntity.notFound().build();
	}
	/**
	 * Metodo faz o tratamento de exception do erro 400
	 * informando qual campo esta faltando
	 * @param er
	 * @return
	 */

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> tratador400(MethodArgumentNotValidException er) {
		var erros = er.getFieldErrors();// pegando uma lista de erros

		return ResponseEntity.badRequest().body(erros.stream().map(DadosErros::new).toList());

	}
/**
 * Metodo é um DTO (Record) para personalizar nossa
 * resposta para o erro 400, informando o campo e a mensagem de erro
 * @author ederf
 *
 */
	public record DadosErros(String campo, String mensagem) {

		public DadosErros(FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}
	}

}
