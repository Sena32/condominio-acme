package br.com.acme.multas.dto;



import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.acme.condominio.Condominio;
import br.com.acme.unidade.entity.UnidadeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName(value = "multa")
@Relation(collectionRelation = "multas")
@JsonInclude(Include.NON_NULL)
public class MultaDTO extends RepresentationModel<MultaDTO>  {
	

	private Long id;
	
	private String descricaoMulta;
	
	private LocalDate dtMulta;

	private Long unidadeMulta;
	
	private Long condominoMulta;
	
	private BigDecimal valorMulta;

}
