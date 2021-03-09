package br.com.hudson.transporte.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.hudson.transporte.domain.Transporte;

@SpringBootTest
public class TransporteRepositoryTests {

	@Autowired
	private TransporteRepository transporteRepository;
	
	@Test
	public void inserir() {
		Transporte t1 = new Transporte(
			null, 
			LocalDate.of(2020, 11, 12), 
			LocalDate.of(2021, 11, 13), 
			"BHZ", 
			"MOC",
			BigDecimal.valueOf(10.50),
			null
		);
		
		Transporte t2 = new Transporte(
			null, 
			LocalDate.of(2020, 11, 12), 
			LocalDate.of(2021, 11, 13), 
			"BHZ", 
			"MOC",
			BigDecimal.valueOf(200.50),
			null
		);
		
		transporteRepository.save(t1);
		transporteRepository.save(t2);
		
	}
}
