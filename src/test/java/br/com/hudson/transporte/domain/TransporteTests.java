package br.com.hudson.transporte.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransporteTests {

	@Test
	public void criar() {
		Transporte t = new Transporte(
				Short.valueOf("1"), 
				LocalDate.of(2020, 11, 12), 
				LocalDate.of(2021, 11, 13), 
				"BHZ", 
				"MOC",
				BigDecimal.valueOf(10.50),
				null
				);

		System.out.println(t);

	}

}
