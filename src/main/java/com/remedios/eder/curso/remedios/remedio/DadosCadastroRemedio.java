package com.remedios.eder.curso.remedios.remedio;

import java.time.LocalDate;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


/**
 * Record para criarmos um objeto DTO  da nossa entidade
 * @author ederf
 *@NotBlank valida se o campo esta vazio, ao utilizar nao precisa de @not null
 */
public record DadosCadastroRemedio(
		@NotBlank String nome,
		@Enumerated Via via,
		@NotBlank String lote,
		@NotNull
		Integer quantidade,
		@Future //nao permite data passada
		LocalDate validade,
		@Enumerated Laboratorio laboratorio) {

}
