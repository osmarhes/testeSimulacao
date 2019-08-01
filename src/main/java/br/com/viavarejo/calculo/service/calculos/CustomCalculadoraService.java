package br.com.viavarejo.calculo.service.calculos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viavarejo.calculo.model.Parcela;
import br.com.viavarejo.calculo.model.Simulacao;
import br.com.viavarejo.calculo.service.CalculadoraService;
import br.com.viavarejo.calculo.service.TaxaJurosSelicService;
import br.com.viavarejo.calculo.service.calculos.util.CalcularUtil;
import br.com.viavarejo.calculo.service.calculos.util.Parcelas;

@Service
public class CustomCalculadoraService implements CalculadoraService {

	@Autowired
	private TaxaJurosSelicService taxaJurosSelicService;
	
	@Override
	public List<Parcela> calculaParcelas(Simulacao simulacao) {
		Integer numerosParcela = simulacao.getCondicaoDePagamento().getQtdParcelas();
		BigDecimal taxaJuros = numerosParcela > 6 ? CalcularUtil.getTaxaJurosMensal(taxaJurosSelicService.dadosUltimos(30)).calcular() : BigDecimal.ZERO;
		BigDecimal resto = simulacao.getProduto().getValor().subtract(simulacao.getCondicaoDePagamento().getValorEntrada());
		BigDecimal montante = CalcularUtil.getMontante(resto, taxaJuros, numerosParcela).calcular();
		BigDecimal valorParcela = CalcularUtil.getValorParcela(montante, numerosParcela).calcular(); 
		return Parcelas.gerar(valorParcela, taxaJuros, numerosParcela);
	}
}
