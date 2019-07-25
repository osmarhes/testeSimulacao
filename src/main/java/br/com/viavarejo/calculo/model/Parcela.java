package br.com.viavarejo.calculo.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Parcela {

    private int numeroParcela;
    private BigDecimal valor;
    private BigDecimal taxaJurosAoMes;

}
