package br.com.viavarejo.calculo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.viavarejo.calculo.model.CondicaoDePagamento;
import br.com.viavarejo.calculo.model.Parcela;
import br.com.viavarejo.calculo.model.Produto;
import br.com.viavarejo.calculo.model.Simulacao;
import br.com.viavarejo.calculo.service.CalculadoraService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculoServiceTests {

	@Autowired
	private CalculadoraService service;

	@Test
	public void testeService() {
		List<Parcela> parcelas = service.calculaParcelas(getSimulacaoSemJuros());
		Assert.assertEquals(parcelas.size(), 6);
		IntStream.range(0, parcelas.size()).forEach(index -> {
			Parcela parcela = parcelas.get(index);
			Assert.assertTrue(parcela.getNumeroParcela().equals(index + 1));
			Assert.assertTrue(parcela.getValor().equals(new BigDecimal(200).setScale(2, RoundingMode.HALF_UP)));
			Assert.assertTrue(parcela.getTaxaJurosAoMes().equals(BigDecimal.ZERO));
		});
	}

	@Test
	public void testeServiceComJuros() {
		List<Parcela> parcelas = service.calculaParcelas(getSimulacaoComJuros());
		Assert.assertEquals(parcelas.size(), 7);
		IntStream.range(0, parcelas.size()).forEach(index -> {
			Parcela parcela = parcelas.get(index);
			Assert.assertTrue(parcela.getNumeroParcela().equals(index + 1));
			Assert.assertTrue(parcela.getValor().equals(new BigDecimal(180.29).setScale(2, RoundingMode.HALF_UP)));
			Assert.assertTrue(parcela.getTaxaJurosAoMes().equals(new BigDecimal(0.738600).setScale(6, RoundingMode.HALF_UP)));
		});
		
		System.out.println(parcelas);
	}

	private Simulacao getSimulacaoSemJuros() {
		Simulacao simulacao = new Simulacao();
		CondicaoDePagamento condicaoDePagamento = new CondicaoDePagamento();
		condicaoDePagamento.setQtdParcelas(6);
		condicaoDePagamento.setValorEntrada(new BigDecimal(300));
		Produto produto = new Produto();
		produto.setCodigo(10);
		produto.setNome("Teste sem juros");
		produto.setValor(new BigDecimal(1500));
		simulacao.setProduto(produto);
		simulacao.setCondicaoDePagamento(condicaoDePagamento);

		return simulacao;
	}

	private Simulacao getSimulacaoComJuros() {
		Simulacao simulacao = new Simulacao();
		CondicaoDePagamento condicaoDePagamento = new CondicaoDePagamento();
		condicaoDePagamento.setQtdParcelas(7);
		condicaoDePagamento.setValorEntrada(new BigDecimal(300));
		Produto produto = new Produto();
		produto.setCodigo(10);
		produto.setNome("Teste sem juros");
		produto.setValor(new BigDecimal(1500));
		simulacao.setProduto(produto);
		simulacao.setCondicaoDePagamento(condicaoDePagamento);

		return simulacao;
	}
}
