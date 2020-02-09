package br.com.acme.multas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.acme.condominio.Condominio;
import br.com.acme.condominio.CondominioService;
import br.com.acme.multas.dto.MultaDTO;
import br.com.acme.multas.entity.Multa;
import br.com.acme.multas.repository.MultaRepository;
import br.com.acme.unidade.entity.UnidadeEntity;
import br.com.acme.unidade.service.UnidadeService;

@Service
public class MultaService {
	
	@Autowired
	private MultaRepository repository;
	@Autowired
	private UnidadeService uService;
	@Autowired
	private CondominioService cService;
	@Autowired
	private ConversorService converter;
	
	public Multa save(MultaDTO multaDTO) {
		
		
		/*
		 * UnidadeEntity unidade = uService.findById(multaDTO.getUnidadeMulta());
		 * Condominio condominio = cService.findById(multaDTO.getCondominoMulta());
		 */
	
		Multa multa = converter.converter(multaDTO, Multa.class);
		/*
		 * multa.setUnidadeMulta(unidade); multa.setCondominoMulta(condominio);
		 */
		return repository.save(multa);
		
	}
	
	public List<Multa> list(){
		return repository.findAll();
	}


	
	
}
