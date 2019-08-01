package br.com.viavarejo.calculo.model;

public class Simulacao {
	private Produto produto;
	private CondicaoDePagamento condicaoDePagamento;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public CondicaoDePagamento getCondicaoDePagamento() {
		return condicaoDePagamento;
	}

	public void setCondicaoDePagamento(CondicaoDePagamento condicaoDePagamento) {
		this.condicaoDePagamento = condicaoDePagamento;
	}

}
