package br.com.acme.responsavel;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponsavelResource {
	
	@Autowired
	private ResponsavelRepository repository;
	
	@PostMapping("api/responsavel")
	public Responsavel save(@Valid @RequestBody Responsavel responsavel) {
		return repository.save(responsavel);
		
	}
}
