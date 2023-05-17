package com.remedios.eder.curso.remedios.records;

import java.time.LocalDate;

import com.remedios.eder.curso.remedios.entidades.Remedio;
import com.remedios.eder.curso.remedios.enuns.Laboratorio;
import com.remedios.eder.curso.remedios.enuns.Via;

public record DadosDetalhamentoRemedio(Long id, String nome, Via via, String lote, Integer quantidade,
		LocalDate validade, Laboratorio laboratorio, Boolean ativo) {

	/**
	 * Metodo construtor
	 * @param remedio
	 */
	public DadosDetalhamentoRemedio(Remedio remedio) {
		this(remedio.getId(), remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getQuantidade(),
				remedio.getValidade(), remedio.getLaboratorio(), remedio.getAtivo());
	}

}
