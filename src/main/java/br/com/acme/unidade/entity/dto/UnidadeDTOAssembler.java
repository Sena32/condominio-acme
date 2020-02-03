package br.com.acme.unidade.entity.dto;

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
                .getActorById(entity.getId()))
                .withSelfRel());
         
    	unidadeDto.setId(entity.getId());
    	unidadeDto.setTitle(entity.getTitle());
    	unidadeDto.setDescription(entity.getDescription());
    	unidadeDto.setReleaseDate(entity.getReleaseDate());
    	unidadeDto.setActors(toActorModel(entity.getActors()));
        return unidadeDto;
    }
     
	/*
	 * @Override public CollectionModel<UnidadeDTO> toCollectionModel(Iterable<?
	 * extends UnidadeEntity> entities) { CollectionModel<UnidadeDTO> unidadeDto =
	 * super.toCollectionModel(entities);
	 * 
	 * unidadeDto.add(linkTo(methodOn(UnidadeResource.class).getAllAlbums()).
	 * withSelfRel());
	 * 
	 * return unidadeDto; }
	 * 
	 * private List<ActorModel> toActorModel(List<ActorEntity> actors) { if
	 * (actors.isEmpty()) return Collections.emptyList();
	 * 
	 * return actors.stream() .map(actor -> ActorModel.builder() .id(actor.getId())
	 * .firstName(actor.getFirstName()) .lastName(actor.getLastName()) .build()
	 * .add(linkTo( methodOn(WebController.class) .getActorById(actor.getId()))
	 * .withSelfRel())) .collect(Collectors.toList()); }
	 */
}
