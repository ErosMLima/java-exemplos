package digytal.java.exemplos.colecoes.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import digytal.java.exemplos.colecoes.model.Carro;
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
		prePredicate(Marca.JEEP);
	}
	static void forEach() {
		List<Carro> carros = Repository.listCarros();
		
		System.out.println("FOR TRADICIONAL");
		
		for(Carro c: carros) {
			System.out.println(c);
		}
		
		System.out.println("\nJAVA 8 - STREAM ForEach");
		carros.forEach(c->System.out.println(c));
	}
	
	static void filter() {
		System.out.println("FILTRANDO CARROS COM ANO MAIOR OU IGUAL 2020\n");
		List<Carro> carros = Repository.listCarros()
				  .stream()
				  .filter(c -> c.getAno() >=2020)
				  .collect(Collectors.toList());
		
		
		carros.forEach(c->System.out.println(c));
	}
	static void predicate(String nome, Integer ano) {
		
		Predicate<Carro> nomeContains = c -> c.getNome().contains(nome);
		Predicate<Carro> anoGreaterThan = c -> c.getAno() > ano;
        
		System.out.println("FILTRANDO CARROS COM ANO MAIOR OU IGUAL 2020\n");
		List<Carro> carros = Repository.listCarros()
				  .stream()
				  .filter(nomeContains.and(anoGreaterThan))
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
}
