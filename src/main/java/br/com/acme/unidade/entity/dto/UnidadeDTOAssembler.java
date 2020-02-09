package br.com.acme.unidade.entity.dto;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;

import br.com.acme.multas.dto.MultaDTO;
import br.com.acme.multas.entity.Multa;
import br.com.acme.unidade.UnidadeResource;
import br.com.acme.unidade.entity.UnidadeEntity;

@Component
public class UnidadeDTOAssembler extends RepresentationModelAssemblerSupport<UnidadeEntity, UnidadeDTO> {

	public UnidadeDTOAssembler() {
		super(UnidadeResource.class, UnidadeDTO.class);
	}

	@Override
	public UnidadeDTO toModel(UnidadeEntity entity) {
		UnidadeDTO unidadeDto = instantiateModel(entity);

		unidadeDto.add(linkTo(methodOn(UnidadeResource.class).getUnidadeById(entity.getId())).withSelfRel());

		unidadeDto.setId(entity.getId());
		unidadeDto.setNumeroUnidade(entity.getNumeroUnidade());
		unidadeDto.setBlocoUnidade(entity.getBlocoUnidade());
		// unidadeDto.setReleaseDate(entity.getReleaseDate());
		unidadeDto.setMultasUnidade(toMultaModel(entity.getMultasUnidade()));
		return unidadeDto;
	}

	private Set<MultaDTO> toMultaModel(Set<Multa> multas) {
		// TODO Auto-generated method stub
		return multas.stream()
				.map(multa -> MultaDTO.builder().id(multa.getId()).build()
						.add(linkTo(methodOn(UnidadeResource.class)
						.getUnidadeById(multa.getId()))
						.withSelfRel()))
				.collect(Collectors.toSet());
	}

	@Override
	public CollectionModel<UnidadeDTO> toCollectionModel(Iterable<? extends UnidadeEntity> entities) {
		CollectionModel<UnidadeDTO> unidadeDto = super.toCollectionModel(entities);
	
		unidadeDto.add(linkTo(methodOn(UnidadeResource.class).getAllUnidades()).withSelfRel());

		return unidadeDto;
	}

	private List<MultaDTO> toMultaModelList(List<Multa> multas) {
		if (multas.isEmpty())
			return Collections.EMPTY_LIST;

		return multas.stream()
				.map(multa -> MultaDTO.builder().id(multa.getId()).build()
						.add(linkTo(methodOn(UnidadeResource.class)
						.getUnidadeById(multa.getId()))
						.withSelfRel()))
				.collect(Collectors.toList());
	}

}
