package br.com.viavarejo.calculo.service.calculos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.viavarejo.calculo.model.TaxaJurosDiario;
import br.com.viavarejo.calculo.service.Calcular;

public class TaxaJurosMensalTest {

	
	private List<TaxaJurosDiario> getList(){
		TaxaJurosDiario jurosDiario = new TaxaJurosDiario();
		jurosDiario.setData("23/07/2019");
		jurosDiario.setValor(new BigDecimal(0.5));
		
		TaxaJurosDiario jurosDiario1 = new TaxaJurosDiario();
		jurosDiario1.setData("23/07/2019");
		jurosDiario1.setValor(new BigDecimal(0.5));
		
		TaxaJurosDiario jurosDiario2 = new TaxaJurosDiario();
		jurosDiario2.setData("23/07/2019");
		jurosDiario2.setValor(new BigDecimal(4));
		
		List<TaxaJurosDiario> diarios = new ArrayList<TaxaJurosDiario>();
		diarios.add(jurosDiario);
		diarios.add(jurosDiario1);
		diarios.add(jurosDiario2);
		
		return diarios;
	}
	
	@Test
	public void testeValor() {
		Calcular parcela = new TaxaJurosMensal(getList());
		System.out.println(parcela.calcular());
		Assert.assertTrue(parcela.calcular().equals(new BigDecimal(5).setScale(1, RoundingMode.HALF_UP)));
	}
}
