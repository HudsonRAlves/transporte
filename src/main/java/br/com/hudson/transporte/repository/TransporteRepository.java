package br.com.hudson.transporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hudson.transporte.domain.Transporte;

public interface TransporteRepository extends JpaRepository<Transporte, Short> {

}
