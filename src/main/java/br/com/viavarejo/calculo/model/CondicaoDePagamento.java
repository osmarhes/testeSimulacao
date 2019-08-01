package br.com.viavarejo.calculo.model;

import java.math.BigDecimal;

public class CondicaoDePagamento {
	private BigDecimal valorEntrada;
	private Integer qtdParcelas;

	public BigDecimal getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(BigDecimal valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public Integer getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(Integer qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

}
