package br.com.acme.condominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CondominioService {
	
	@Autowired
	private CondominioRepository repository;
	
	public Condominio findById(Long id) {
		return repository.findCondominioById(id);
		
	}

}
