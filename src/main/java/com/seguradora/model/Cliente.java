package com.seguradora.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "cliente")
public class Cliente {
	
	@Id
	@JsonIgnore
	private String id;
	
	@NotNull(message = "Campo nome obrigatório")
	private String nome;
	
	@CPF(message = "CPF inválido")
	@Indexed(unique = true)
	@NotNull(message = "Campo CPF obrigatório")
	private String cpf;
	
	@NotNull(message = "Campo cidade obrigatório")
	private String cidade;
	
	@NotNull(message = "Campo uf obrigatório")
	@Length(min = 2, max = 2)
	private String uf;
	
	
	
	public Cliente() {}

	public Cliente(String nome, String cpf, String cidade, String uf) {
		this.nome = nome;
		this.cpf = cpf;
		this.cidade = cidade;
		this.uf = uf;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
