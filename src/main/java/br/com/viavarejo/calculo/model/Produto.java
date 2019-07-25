package br.com.viavarejo.calculo.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Produto {
	private Integer codigo;
	private String nome;
	private BigDecimal valor;

}
