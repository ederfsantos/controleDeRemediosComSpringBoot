package com.remedios.eder.curso.remedios.records;

import java.time.LocalDate;

import com.remedios.eder.curso.remedios.entidades.Remedio;
import com.remedios.eder.curso.remedios.enuns.Laboratorio;
import com.remedios.eder.curso.remedios.enuns.Via;

public record DadosListagemRemedio(Long id, String nome, Via via, String lote, Laboratorio laboratorio, LocalDate validade) {

	public DadosListagemRemedio(Remedio remedio) {
		this(remedio.getId(), remedio.getNome(),remedio.getVia(),remedio.getLote(),remedio.getLaboratorio(),remedio.getValidade());
		
	}

}
