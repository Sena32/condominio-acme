package br.com.acme.unidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.unidade.entity.dto.UnidadeDTO;
import br.com.acme.unidade.entity.dto.UnidadeDTOAssembler;
import br.com.acme.unidade.repository.UnidadeRepository;

@RestController
public class UnidadeResource {
	
    @Autowired
    private UnidadeRepository unidadeRepository;
     
    @Autowired
    private UnidadeDTOAssembler assembler;
    
    @GetMapping("/api/unidades/{id}")
    public ResponseEntity<UnidadeDTO> getUnidadeById(@PathVariable("id") Long id) 
    {
        return unidadeRepository.findById(id) 
                .map(assembler::toModel) 
                .map(ResponseEntity::ok) 
                .orElse(ResponseEntity.notFound().build());
    }

}
