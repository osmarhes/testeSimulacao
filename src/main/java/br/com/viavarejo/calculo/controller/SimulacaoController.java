package br.com.viavarejo.calculo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.viavarejo.calculo.model.Parcela;
import br.com.viavarejo.calculo.model.Simulacao;
import br.com.viavarejo.calculo.service.CalculadoraService;

@RestController
@RequestMapping("/simular")
public class SimulacaoController {


	@Autowired
	private CalculadoraService calculadora;
	
	@PostMapping("listarParcelas")
	public ResponseEntity<List<Parcela>> calculaParcelas(@RequestBody final Simulacao simulacao){
		return ResponseEntity.ok(calculadora.calculaParcelas(simulacao));
	}
}
