package br.com.viavarejo.calculo.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.viavarejo.calculo.model.TaxaJurosDiario;

@FeignClient(name="taxaJurosSelicService", url="https://api.bcb.gov.br/dados/serie/bcdata.sgs.11")
public interface TaxaJurosSelicService {

    @GetMapping(value = "/dados/ultimos/{dias}?formato=json", consumes=MediaType.APPLICATION_JSON_VALUE)	
	List<TaxaJurosDiario> dadosUltimos(@PathVariable("dias") Integer dias);
}
