package br.com.acme.unidade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.acme.unidade.entity.UnidadeEntity;

public interface UnidadeRepository extends JpaRepository<UnidadeEntity, Long>{
	@Query("select u from UnidadeEntity u where u.numeroUnidade is null or u.numeroUnidade=''")
	public List<UnidadeEntity> findOnlyMultas();

}
