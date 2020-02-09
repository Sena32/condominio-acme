package br.com.acme.multas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.multas.entity.Multa;

public interface MultaRepository extends JpaRepository<Multa, Long> {

	
}
