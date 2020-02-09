package br.com.acme.unidade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.unidade.entity.UnidadeEntity;
import br.com.acme.unidade.entity.dto.UnidadeDTO;
import br.com.acme.unidade.entity.dto.UnidadeDTOAssembler;
import br.com.acme.unidade.repository.UnidadeRepository;
import br.com.acme.unidade.service.UnidadeService;

@RestController
public class UnidadeResource {

	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@Autowired
	private UnidadeService service;

	@Autowired
	private UnidadeDTOAssembler assembler;

	@GetMapping("/api/unidades/sem-multas")
	public ResponseEntity<CollectionModel<UnidadeDTO>> getAllUnidades() {
		List<UnidadeEntity> unidadeList = this.service.listSemMultas();
		return new ResponseEntity<>(assembler.toCollectionModel(unidadeList), HttpStatus.OK);
	}
	

	@GetMapping("/api/unidades/multadas")
	public ResponseEntity<CollectionModel<UnidadeDTO>> getAllmultadas() {
		List<UnidadeEntity> unidadeList = this.service.listComMultas();
		return new ResponseEntity<>(assembler.toCollectionModel(unidadeList), HttpStatus.OK);
	}


	@GetMapping("/api/unidades/{id}")
	public ResponseEntity<UnidadeDTO> getUnidadeById(@PathVariable("id") Long id) {

		return unidadeRepository.findById(id).map(assembler::toModel)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

}
