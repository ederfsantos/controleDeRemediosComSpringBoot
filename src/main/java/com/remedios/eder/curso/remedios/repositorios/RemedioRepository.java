package com.remedios.eder.curso.remedios.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.remedios.eder.curso.remedios.entidades.Remedio;

public interface RemedioRepository extends JpaRepository<Remedio, Long>{

	/**
	 * Metodo para listar somente os registros ativos
	 * @return
	 */
List<Remedio> findAllByAtivoTrue();

}
