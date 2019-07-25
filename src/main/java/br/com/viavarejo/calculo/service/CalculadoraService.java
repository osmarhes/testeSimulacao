package br.com.viavarejo.calculo.service;

import java.util.List;

import br.com.viavarejo.calculo.model.Parcela;
import br.com.viavarejo.calculo.model.Simulacao;

public interface CalculadoraService {

	List<Parcela> calculaParcelas(Simulacao simulacao);
}
