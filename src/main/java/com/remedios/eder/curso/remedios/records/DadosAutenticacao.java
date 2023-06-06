package com.remedios.eder.curso.remedios.records;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(@NotBlank String login,@NotBlank String senha) {
	
	
	
	

}
