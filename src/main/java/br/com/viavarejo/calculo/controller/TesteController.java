package br.com.viavarejo.calculo.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.viavarejo.calculo.model.TaxaJurosDiario;
import br.com.viavarejo.calculo.service.TaxaJurosSelicService;

@RestController
@RequestMapping("/teste")
public class TesteController {
	
	@Autowired
	private TaxaJurosSelicService service;
	
	@GetMapping("ok")
	public String teste() {
		return "ok";
	}
	
	@GetMapping("ok_2")
	public List<TaxaJurosDiario> teste_2() {
		
		List<TaxaJurosDiario> listaJuros = service.dadosUltimos(30);

		BigDecimal taxaJurosAoMes = listaJuros.stream().map(TaxaJurosDiario::getValor).reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO);
		
		System.out.println("********* " + taxaJurosAoMes.toString() + " *********");
		
		return service.dadosUltimos(30);
	}
}
