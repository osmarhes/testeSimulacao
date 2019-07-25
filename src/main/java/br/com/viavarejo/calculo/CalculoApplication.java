package br.com.viavarejo.calculo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CalculoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculoApplication.class, args);
	}

}
