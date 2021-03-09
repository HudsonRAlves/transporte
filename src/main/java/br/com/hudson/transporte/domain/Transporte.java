package br.com.hudson.transporte.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transporte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@Column
	private LocalDate dtEmissao;
	
	@Column
	private LocalDate dtPrevisaoEntrega;
		
	@Column(length = 50, nullable = false)
	private String origem;
	
	@Column(length = 50, nullable = false)
	private String destino;
	
	@Column(precision = 5, scale = 2, nullable = false)
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cliente cliente;
	
}

