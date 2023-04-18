package com.remedios.eder.curso.remedios.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedios.eder.curso.remedios.remedio.DadosCadastroRemedio;

@RestController
@RequestMapping("/remedios")
public class RemedioController {
	
	//@PostMapping
	//public void cadastrar(@RequestBody String json) {
	//	System.out.println(json);
		
//	}
	@PostMapping
	public void cadastrar(@RequestBody DadosCadastroRemedio dados) {
		System.out.println(dados);
		
	}
	
}
