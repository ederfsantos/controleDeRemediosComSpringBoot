package com.remedios.eder.curso.remedios.records;

import com.remedios.eder.curso.remedios.enuns.Laboratorio;
import com.remedios.eder.curso.remedios.enuns.Via;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRemedio(
	@NotNull Long id,String nome,Via via,Laboratorio laboratorio) {

	
	
}
