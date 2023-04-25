//https://github.com/ederfsantos/controleDeRemediosComSpringBoot

package com.remedios.eder.curso.remedios.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedios.eder.curso.remedios.remedio.DadosCadastroRemedio;
import com.remedios.eder.curso.remedios.remedio.DadosListagemRemedio;
import com.remedios.eder.curso.remedios.remedio.DadoslistagemRemedio;
import com.remedios.eder.curso.remedios.remedio.Remedio;
import com.remedios.eder.curso.remedios.remedio.RemedioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

	@Autowired
	private RemedioRepository repository;

	@GetMapping("/{id}")
	public Remedio listarPorId(@PathVariable Long id) {
		Optional<Remedio> remedio = repository.findById(id);
		return remedio.orElse(null);
	}

	// @PostMapping
	// public void cadastrar(@RequestBody String json) {
	// System.out.println(json);

//	}
	/**
	 * ESTE METODO RECEBE DADOS JSON VIA VERBO GET E É TRANSPORTADO PARA A CLASSE
	 * DadosCadastroRemedio(PADRAO DTO) que é um record, uma novo tipo de classe do
	 * Java , imutavel, e mais pratica para trabalhar no padrão DTO.
	 * 
	 * @param dados
	 */
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroRemedio dados) {
		// System.out.println(dados);
		repository.save(new Remedio(dados));

	}
	
	@GetMapping
	public List<DadosListagemRemedio> listar(){
		return repository.findAll().stream().map(DadosListagemRemedio::new).toList();
	}
	

}
