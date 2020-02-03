package br.com.acme.unidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.unidade.entity.UnidadeEntity;

public interface UnidadeRepository extends JpaRepository<UnidadeEntity, Long>{

}
