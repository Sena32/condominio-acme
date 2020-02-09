package br.com.acme.multas.dto;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.acme.multas.MultaResource;
import br.com.acme.multas.entity.Multa;
@Component
public class MultaDTOAssembler extends RepresentationModelAssemblerSupport<Multa, MultaDTO> {

	public MultaDTOAssembler() {
		super(MultaResource.class,MultaDTO.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public MultaDTO toModel(Multa entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
