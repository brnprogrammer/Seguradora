package com.seguradora.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ApoliceDTO {

	private LocalDate inicioVigencia;

	private LocalDate fimVigencia;

	private BigDecimal valor;

	private PrazoVigencia vencimentoApolice;

	private String msgPrazoVencimento;

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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public PrazoVigencia getVencimentoApolice() {
		return vencimentoApolice;
	}

	public void setVencimentoApolice(PrazoVigencia vencimentoApolice) {
		this.vencimentoApolice = vencimentoApolice;
	}

	public String getMsgPrazoVencimento() {
		return msgPrazoVencimento;
	}

	public void setMsgPrazoVencimento(String msgPrazoVencimento) {
		this.msgPrazoVencimento = msgPrazoVencimento;
	}

	

}
