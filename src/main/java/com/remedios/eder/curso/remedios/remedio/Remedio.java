package com.remedios.eder.curso.remedios.remedio;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "remedios")
@Table(name = "remedio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Remedio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	@Enumerated(EnumType.STRING)
	private Via via;
	private String lote;
	private Integer quantidade;
	private LocalDate validade;
	@Enumerated(EnumType.STRING)
	private Laboratorio laboratorio;
	
	private Boolean ativo;
	
	
	/**
	 * Método contructor recebe um objeto DTO e 
	 * instancia um objeto Remedio.
	 * @param dados
	 */
	public Remedio(DadosCadastroRemedio dados) {
		this.ativo=true;
		this.laboratorio = dados.laboratorio();
		this.lote = dados.lote();
		this.nome = dados.nome();
		this.quantidade = dados.quantidade();
		this.validade = dados.validade();
		this.via = dados.via();
	
	}

/**
 * Metodo utilizado para veirificar se tem dados nulos
 * @param dados
 */
	public void atualizarInformacoes(@Valid DadosAtualizarRemedio dados) {
		// TODO Auto-generated method stub
		if(dados.nome()!=null) {
			this.nome = dados.nome();
		}
		if(dados.via()!=null) {
			this.via = dados.via();
		}
		
		if(dados.laboratorio()!=null) {
			this.laboratorio = dados.laboratorio();
		}
		
	}

public void inativar() {
	// TODO Auto-generated method stub
	this.ativo = false;
	
}

public void ativar() {
	// TODO Auto-generated method stub
	this.ativo = true;
	
}
	
	

}
