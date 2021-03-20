package digytal.java.exemplos.colecoes.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import digytal.java.exemplos.colecoes.model.Carro;
import digytal.java.exemplos.colecoes.model.CarroDto;
import digytal.java.exemplos.colecoes.model.Marca;
import digytal.java.exemplos.colecoes.repository.Repository;
import digytal.java.exemplos.colecoes.stream.predicate.Predicates;

public class ExemploStream {
	//forEach
	//filter
	//predicate
	//map
	//reduce
	//sorted
	//group by
	//distinct
	
	public static void main(String[] args) {
		//forEach();
		//filter();
		//predicate("FORD", 2020);
		//prePredicate(Marca.JEEP);
		//map();
		
		mapObject();
	}
	//INTERAÇÃO
	static void forEach() {
		List<Carro> carros = Repository.listCarros();
		
		System.out.println("FOR TRADICIONAL");
		
		for(Carro c: carros) {
			System.out.println(c);
		}
		
		System.out.println("\nJAVA 8 - STREAM ForEach");
		carros.forEach( c-> System.out.println(c) );
	}
	//FILTROS
	static void filter() {
		System.out.println("FILTRANDO CARROS COM ANO MAIOR OU IGUAL 2020\n");
		List<Carro> carros = Repository.listCarros()
				  .stream()
				  .filter(c -> c.getAno() >=2020 && c.getNome().contains("FORD") )
				  .collect(Collectors.toList());
		
		carros.forEach(c->System.out.println(c));
	}
	static void predicate(String nome, Integer ano) {
		
		Predicate<Carro> nomeContains = c -> c.getNome().contains(nome);
		Predicate<Carro> anoGreaterThan = c -> c.getAno() > ano;
		
		Predicate<Carro> filtro = nomeContains.and(anoGreaterThan);
        
		System.out.println("FILTRANDO CARROS COM ANO MAIOR OU IGUAL 2020\n");
		List<Carro> carros = 	Repository.listCarros()
				  .stream()
				  .filter(filtro)
				  .collect(Collectors.toList());
		
		
		carros.forEach(c->System.out.println(c));
	}
	static void prePredicate(Marca marca) {
		System.out.println("FILTRANDO CARROS COM ANO MAIOR OU IGUAL 2020\n");
		List<Carro> carros = Repository.listCarros()
				  .stream()
				  .filter(Predicates.carroMarcaPredicate(marca))
				  .collect(Collectors.toList());
		
		
		carros.forEach(c->System.out.println(c));
	}
	//CONVERSAO
	static void map() {
		cabecalho("CONVERTENDO LISTAS");
		cabecalho("OBTENDO SOMENTE O NOME DOS CARROS");
		rodape();
		List<Carro> carros = Repository.listCarros();
		
		List<String> nomes = carros.stream().map(c-> c.getNome()).collect(Collectors.toList());
		
		nomes.forEach(c->System.out.println(c));
		rodape();
	}
	static void mapObject() {
		cabecalho("CONVERTENDO LISTA DE OBJETOS PARA OUTROS OBJETOS");
		rodape();
		List<Carro> carros = Repository.listCarros();
		
		List<CarroDto> carrosDto = carros.stream()
					
				.map(c-> {
					
					CarroDto dto = new CarroDto();
					dto.setNome(c.getNome());
					dto.setMarca(c.getMarca().getNome());
					dto.setPais(c.getMarca().getPais());
					return dto;
					
				})
				
				.collect(Collectors.toList());
		
		carrosDto.forEach(c->System.out.println(c));
		rodape();
	}
	static void rodape() {
		System.out.println("---------------------------------------------------------------------------");
	}
	static void cabecalho(String titulo) {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(titulo);
	}
}
