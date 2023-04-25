package com.remedios.eder.curso.remedios.remedio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedioRepository extends JpaRepository<Remedio, Long>{

	/**
	 * Metodo para listar somente os registros ativos
	 * @return
	 */
List<Remedio> findAllByAtivoTrue();

}
