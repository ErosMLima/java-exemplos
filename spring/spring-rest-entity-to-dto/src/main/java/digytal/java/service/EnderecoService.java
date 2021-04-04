package digytal.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digytal.java.dto.EnderecoDto;
import digytal.java.model.Endereco;
import digytal.java.repository.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoRepository repository;
	public void save(EnderecoDto dto) {
		
		Endereco entity =null;
		
		repository.save(entity);
	}
}
