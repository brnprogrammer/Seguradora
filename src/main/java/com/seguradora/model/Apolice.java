package com.seguradora.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "apolice")
public class Apolice {

	@Id
	@JsonIgnore
	private String numero;

	@NotNull(message = "Campo vigencia obrigatório")
	private LocalDate inicioVigencia;
	
	@NotNull(message = "Campo fimVigencia obrigatório")
	private LocalDate fimVigencia;

	@NotNull(message = "Campo valor obrigatório")
	private BigDecimal valor;
	
	@CPF(message = "CPF inválido")
	@Indexed(unique = true)
	@NotNull(message = "Campo CPF obrigatório")
	private String cpfCliente;

	public Apolice() {
	}

	public Apolice(LocalDate inicioVigencia,BigDecimal valor,String cpfCliente, LocalDate fimVigencia) {
		this.inicioVigencia = inicioVigencia;
		this.valor = valor;
		this.cpfCliente = cpfCliente;
		this.fimVigencia = fimVigencia;
	}

	
	
	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpf(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}


	public LocalDate getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(LocalDate inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public LocalDate getFimVigencia() {
		return fimVigencia;
	}

	public void setFimVigencia(LocalDate fimVigencia) {
		this.fimVigencia = fimVigencia;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}


	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
