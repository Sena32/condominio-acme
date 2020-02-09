package br.com.acme.multas;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.multas.dto.MultaDTO;
import br.com.acme.multas.entity.Multa;
import br.com.acme.multas.service.MultaService;

@RestController
public class MultaResource {
	
	@Autowired
	private MultaService service;
	
	@GetMapping("api/multa")
	public List<Multa> list() {
		
		return service.list();
		

	}

	
	@PostMapping("api/multa")
	public Multa save(@Valid 
			@RequestBody MultaDTO multaDTO) {
		
		System.out.println("IdUnid"+multaDTO.getUnidadeMulta());
		return service.save(multaDTO);
		

	}

}
