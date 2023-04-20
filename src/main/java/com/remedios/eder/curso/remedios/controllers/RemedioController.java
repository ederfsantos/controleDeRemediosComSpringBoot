//https://github.com/ederfsantos/controleDeRemediosComSpringBoot

package com.remedios.eder.curso.remedios.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedios.eder.curso.remedios.remedio.DadosCadastroRemedio;
import com.remedios.eder.curso.remedios.remedio.RemedioRepository;

@RestController
@RequestMapping("/remedios")
public class RemedioController {
	
	@Autowired
	private RemedioRepository repository;
	
	//@PostMapping
	//public void cadastrar(@RequestBody String json) {
	//	System.out.println(json);
		
//	}
	/**
	 * ESTE METODO RECEBE DADOS JSON VIA VERBO GET
	 * E É TRANSPORTADO PARA A CLASSE DadosCadastroRemedio(PADRAO DTO) que 
	 * é um record, uma novo tipo de classe do Java , imutavel, e mais pratica
	 * para trabalhar no padrão DTO. 
	 * @param dados
	 */
	@PostMapping
	public void cadastrar(@RequestBody DadosCadastroRemedio dados) {
		//System.out.println(dados);
		repository.save(null);
		
	}
	
}
