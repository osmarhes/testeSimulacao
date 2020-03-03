package br.com.viavarejo.calculo.controller;

import br.com.viavarejo.calculo.CalculoApplication;
import br.com.viavarejo.calculo.model.CondicaoDePagamento;
import br.com.viavarejo.calculo.model.Produto;
import br.com.viavarejo.calculo.model.Simulacao;
import br.com.viavarejo.calculo.service.CalculadoraService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CalculoApplication.class)
//@WebMvcTest(SimulacaoController.class)
@AutoConfigureMockMvc
public class SimulacaoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CalculadoraService calculadora;

    @Test
    public void testCalculaParcelasSemJuros() throws Exception {
        Simulacao simulacao = new Simulacao();
        simulacao.setProduto(getProduto());
        simulacao.setCondicaoDePagamento(getCondicaoDePagamento(6, 1000d));

        mvc.perform(post("/simular/listarParcelas")
                .contentType(MediaType.APPLICATION_JSON).content(toJson(simulacao)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].numeroParcela", is(1)))
                .andExpect(jsonPath("$[0].valor", is(1166.67)))
                .andExpect(jsonPath("$[0].taxaJurosAoMes", is(0)))
                .andExpect(jsonPath("$[1].numeroParcela", is(2)))
                .andExpect(jsonPath("$[1].valor", is(1166.67)))
                .andExpect(jsonPath("$[1].taxaJurosAoMes", is(0)))
                .andExpect(jsonPath("$[2].numeroParcela", is(3)))
                .andExpect(jsonPath("$[2].valor", is(1166.67)))
                .andExpect(jsonPath("$[2].taxaJurosAoMes", is(0)))
                .andExpect(jsonPath("$[3].numeroParcela", is(4)))
                .andExpect(jsonPath("$[3].valor", is(1166.67)))
                .andExpect(jsonPath("$[3].taxaJurosAoMes", is(0)))
                .andExpect(jsonPath("$[4].numeroParcela", is(5)))
                .andExpect(jsonPath("$[4].valor", is(1166.67)))
                .andExpect(jsonPath("$[4].taxaJurosAoMes", is(0)))
                .andExpect(jsonPath("$[5].numeroParcela", is(6)))
                .andExpect(jsonPath("$[5].valor", is(1166.67)))
                .andExpect(jsonPath("$[5].taxaJurosAoMes", is(0)))
                .andExpect(jsonPath("$.*", hasSize(6)));
    }

    @Test
    public void testCalculaParcelasComJuros() throws Exception {
        Simulacao simulacao = new Simulacao();
        simulacao.setProduto(getProduto());
        simulacao.setCondicaoDePagamento(getCondicaoDePagamento(8, 1000d));

        mvc.perform(post("/simular/listarParcelas")
                .contentType(MediaType.APPLICATION_JSON).content(toJson(simulacao)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(8)))
                .andExpect(jsonPath("$[0].numeroParcela", is(1)))
                .andExpect(jsonPath("$[0].valor", is(909.82)))
                .andExpect(jsonPath("$[0].taxaJurosAoMes", is(0.497438)))
                .andExpect(jsonPath("$[1].numeroParcela", is(2)))
                .andExpect(jsonPath("$[1].valor", is(909.82)))
                .andExpect(jsonPath("$[1].taxaJurosAoMes", is(0.497438)))
                .andExpect(jsonPath("$[2].numeroParcela", is(3)))
                .andExpect(jsonPath("$[2].valor", is(909.82)))
                .andExpect(jsonPath("$[2].taxaJurosAoMes", is(0.497438)))
                .andExpect(jsonPath("$[3].numeroParcela", is(4)))
                .andExpect(jsonPath("$[3].valor", is(909.82)))
                .andExpect(jsonPath("$[3].taxaJurosAoMes", is(0.497438)))
                .andExpect(jsonPath("$[4].numeroParcela", is(5)))
                .andExpect(jsonPath("$[4].valor", is(909.82)))
                .andExpect(jsonPath("$[4].taxaJurosAoMes", is(0.497438)))
                .andExpect(jsonPath("$[5].numeroParcela", is(6)))
                .andExpect(jsonPath("$[5].valor", is(909.82)))
                .andExpect(jsonPath("$[5].taxaJurosAoMes", is(0.497438)))
                .andExpect(jsonPath("$[6].numeroParcela", is(7)))
                .andExpect(jsonPath("$[6].valor", is(909.82)))
                .andExpect(jsonPath("$[6].taxaJurosAoMes", is(0.497438)))
                .andExpect(jsonPath("$[7].numeroParcela", is(8)))
                .andExpect(jsonPath("$[7].valor", is(909.82)))
                .andExpect(jsonPath("$[7].taxaJurosAoMes", is(0.497438)));
    }

    private Produto getProduto(){
        Produto produto = new Produto();
        produto.setCodigo(200);
        produto.setNome("iPhone X");
        produto.setValor(new BigDecimal(8000));
        return produto;
    }

    private CondicaoDePagamento getCondicaoDePagamento(Integer qtdParcelas, Double valorEntrada){
        CondicaoDePagamento condicaoDePagamento = new CondicaoDePagamento();
        condicaoDePagamento.setQtdParcelas(qtdParcelas);
        condicaoDePagamento.setValorEntrada(new BigDecimal(valorEntrada));
        return condicaoDePagamento;
    }

    private byte[] toJson(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
}

