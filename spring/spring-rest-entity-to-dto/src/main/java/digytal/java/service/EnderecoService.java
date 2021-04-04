package digytal.java.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digytal.java.dto.EnderecoDto;
import digytal.java.model.Endereco;
import digytal.java.repository.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	public void save(EnderecoDto dto) {

		Endereco entity =mapper.map(dto,Endereco.class);
		
		System.out.println(entity);
		
		repository.save(entity);
	
	}
}


