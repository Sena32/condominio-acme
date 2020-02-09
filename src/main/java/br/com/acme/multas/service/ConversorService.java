package br.com.acme.multas.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversorService {
	
	@Autowired
	private ModelMapper modelMapper;

	public <T> T converter(Object origem, Class<T> tipoDestino) {
		return modelMapper.map(origem, tipoDestino);

	}

}
