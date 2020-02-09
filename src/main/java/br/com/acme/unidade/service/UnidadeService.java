package br.com.acme.unidade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.unidade.entity.UnidadeEntity;
import br.com.acme.unidade.repository.UnidadeRepository;

@Service
public class UnidadeService {
	@Autowired
	private UnidadeRepository repository;
	
	@Transactional(readOnly=true)
	public List<UnidadeEntity> list(){
		return this.repository.findAll();
	}
	
	@Transactional(readOnly=true)
	public List<UnidadeEntity> listSemMultas(){
		return this.repository.findOnlyMultas();
	}
	
	public UnidadeEntity findById(Long id) {
		return repository.findUnidadeById(id);
	}

	public List<UnidadeEntity> listComMultas() {
		// TODO Auto-generated method stub
		return this.repository.findWithMultas();
	}

}
