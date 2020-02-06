package br.com.acme.unidade.entity.dto;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;

import br.com.acme.unidade.UnidadeResource;
import br.com.acme.unidade.entity.UnidadeEntity;


@Component
public class UnidadeDTOAssembler 
    extends RepresentationModelAssemblerSupport<UnidadeEntity, UnidadeDTO> {
 
    public UnidadeDTOAssembler() {
        super(UnidadeResource.class, UnidadeDTO.class);
    }
 
    @Override
    public UnidadeDTO toModel(UnidadeEntity entity) 
    {
    	UnidadeDTO unidadeDto = instantiateModel(entity);
    	
    	unidadeDto.add(linkTo(
                methodOn(UnidadeResource.class)
                .getUnidadeById(entity.getId()))
                .withSelfRel());
                
        

         
    	unidadeDto.setId(entity.getId());
    	unidadeDto.setNumeroUnidade(entity.getNumeroUnidade());
    	unidadeDto.setBlocoUnidade(entity.getBlocoUnidade());
    	//unidadeDto.setReleaseDate(entity.getReleaseDate());
    	//unidadeDto.setActors(toActorModel(entity.getActors()));
        return unidadeDto;
    }
     
	
	  @Override public CollectionModel<UnidadeDTO> toCollectionModel(Iterable<?
	  extends UnidadeEntity> entities) { CollectionModel<UnidadeDTO> unidadeDto =
	  super.toCollectionModel(entities);
	  
	  unidadeDto.add(linkTo(methodOn(UnidadeResource.class).getAllUnidades()).
	  withSelfRel());
	  
	  return unidadeDto; }
	 
	  /*
	  private List<ActorModel> toActorModel(List<ActorEntity> actors) { if
	  (actors.isEmpty()) return Collections.emptyList();
	  
	  return actors.stream() .map(actor -> ActorModel.builder() .id(actor.getId())
	  .firstName(actor.getFirstName()) .lastName(actor.getLastName()) .build()
	  .add(linkTo( methodOn(WebController.class) .getActorById(actor.getId()))
	  .withSelfRel())) .collect(Collectors.toList()); }
	  */
	 
}
