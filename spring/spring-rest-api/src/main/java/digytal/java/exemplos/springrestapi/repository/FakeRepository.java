package digytal.java.exemplos.springrestapi.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import digytal.java.exemplos.springrestapi.model.Endereco;
@Component
public class FakeRepository {
	private Map<String, Endereco> enderecos = new HashMap<String, Endereco>();
	{
		enderecos.put("64180000", new Endereco("64180-000", "", "", "Esperantina"));
		enderecos.put("65304060", new Endereco("65304-060", "Rua da Palmeira", "Palmeira", "Santa Inês"));
		enderecos.put("01001000", new Endereco("01001-000", "Praça da Sé", "Sé", "São Paulo"));
		enderecos.put("03047000", new Endereco("03047-000", "Rua 21 de Abril", "Brás", "São Paulo"));
		enderecos.put("03807020", new Endereco("03807-020", "Rua 21 de Setembro", "Vila Robertina", "São Paulo"));
	}
	public List<Endereco> findAll(){
		return new ArrayList<Endereco>(enderecos.values());
	}
	public Endereco findByCep(String cep) {
		return enderecos.get(cep);
	}
	public void save(Endereco endereco) {
		enderecos.put(endereco.getCep(), endereco);
	}
	public void update(Endereco endereco) {
		if(!enderecos.containsKey(endereco.getCep()))
			throw new IllegalArgumentException("Não foi localizado um endereço com este cep " + endereco.getCep());
		
		enderecos.put(endereco.getCep(), endereco);
	}
	public void remove(String cep) {
		enderecos.remove(cep);
	}
}
