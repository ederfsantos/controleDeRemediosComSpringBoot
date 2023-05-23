//https://github.com/ederfsantos/controleDeRemediosComSpringBoot

package com.remedios.eder.curso.remedios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.remedios.eder.curso.remedios.entidades.Remedio;
import com.remedios.eder.curso.remedios.records.DadosAtualizarRemedio;
import com.remedios.eder.curso.remedios.records.DadosCadastroRemedio;
import com.remedios.eder.curso.remedios.records.DadosDetalhamentoRemedio;
import com.remedios.eder.curso.remedios.records.DadosListagemRemedio;
import com.remedios.eder.curso.remedios.repositorios.RemedioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

	@Autowired
	private RemedioRepository repository;
/*
	@GetMapping("/{id}")
	public Remedio listarPorId(@PathVariable Long id) {
		Optional<Remedio> remedio = repository.findById(id);
		return remedio.orElse(null);
	}
*/
	/**
	 * Este método realiza a busca do objeto pelo id
	 * informado por parametro(argumento).
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<DadosDetalhamentoRemedio> consultarPorId(@PathVariable Long id) {
		var remedio = repository.getReferenceById(id);
		return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));

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
	public ResponseEntity<DadosDetalhamentoRemedio> cadastrar(@RequestBody @Valid DadosCadastroRemedio dados,
			UriComponentsBuilder uriBuilder) {
		// System.out.println(dados);
		var remedio = new Remedio(dados);
		repository.save(remedio);
		var uri = uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoRemedio(remedio));

	}

	/**
	 * Metodo realiza uma listagem dos objetos no banco
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<DadosListagemRemedio>> listar() {
		// return repository.findAll().stream().map(DadosListagemRemedio::new).toList();
		var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemRemedio::new).toList();
		return ResponseEntity.ok(lista);
	}

	/**
	 * Metodo realiza update do objeto na base de dados.
	 * 
	 * @param dados
	 * @return
	 */
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoRemedio> atualizar(@RequestBody @Valid DadosAtualizarRemedio dados) {
		var remedio = repository.getReferenceById(dados.id());
		remedio.atualizarInformacoes(dados);
		return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
	}

	/**
	 * Exclusao total
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);

	}

	/**
	 * Metodo realiza a exclusão logica,inativação do objeto
	 * 
	 * @param id
	 */
	@DeleteMapping("/inativar/{id}")
	@Transactional
	public ResponseEntity<Void> inativarRemedio(@PathVariable Long id) {
		var remedio = repository.getReferenceById(id);
		remedio.inativar();
		return ResponseEntity.noContent().build();

	}

	/**
	 * Metodo realiza a ativação do remedio
	 * 
	 * @param id
	 */
	@PutMapping("/ativar/{id}")
	@Transactional
	public ResponseEntity<Void> ativarRemedio(@PathVariable Long id) {
		var remedio = repository.getReferenceById(id);
		remedio.ativar();
		return ResponseEntity.noContent().build();
	}
}
