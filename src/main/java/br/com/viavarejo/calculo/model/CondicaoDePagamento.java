package br.com.viavarejo.calculo.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CondicaoDePagamento {
	private BigDecimal valorEntrada;
	private Integer qtdParcelas;

}
