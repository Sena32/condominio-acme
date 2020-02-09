package br.com.acme.condominio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CondominioRepository extends JpaRepository<Condominio, Long>{
	
	 @Query("select c from Condominio c where c.id=?1")
	    Condominio findCondominioById(Long id);

}
