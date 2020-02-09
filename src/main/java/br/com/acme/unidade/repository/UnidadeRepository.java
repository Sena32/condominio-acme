package br.com.acme.unidade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.acme.unidade.entity.UnidadeEntity;

public interface UnidadeRepository extends JpaRepository<UnidadeEntity, Long>{
	@Query("select u from UnidadeEntity u where u.multasUnidade is empty")
	public List<UnidadeEntity> findOnlyMultas();

	@Query("select u from UnidadeEntity u where u.id=?1")
	public UnidadeEntity findUnidadeById(Long id);
	
	@Query("select u from UnidadeEntity u where u.multasUnidade is not empty")
	public List<UnidadeEntity> findWithMultas();

}
