package br.com.viavarejo.calculo.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TaxaJurosDiario {
	private String data;
	private BigDecimal valor;

}
