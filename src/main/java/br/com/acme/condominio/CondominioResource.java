package br.com.acme.condominio;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CondominioResource {
	
	@Autowired
	private CondominioRepository repository;
	
	@PostMapping("api/condominio")
	public Condominio save(@Valid @RequestBody Condominio entity) {
		return repository.save(entity);
		
	}
}
