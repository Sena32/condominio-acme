package br.com.acme.unidade.entity.dto;

import java.util.List;
import java.util.Set;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

import br.com.acme.multas.dto.MultaDTO;
import br.com.acme.multas.entity.Multa;
import br.com.acme.responsavel.Responsavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "unidade")
@Relation(collectionRelation = "unidades")
@JsonInclude(Include.NON_NULL)
public class UnidadeDTO extends RepresentationModel<UnidadeDTO> {

	private Long id;
	
	private Responsavel responsavelUnidade;
	
	private String numeroUnidade;
	
	private String blocoUnidade;
	
	private Set<MultaDTO> multasUnidade;
}
