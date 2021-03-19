package digytal.java.exemplos.colecoes.stream.predicate;

import java.util.function.Predicate;

import digytal.java.exemplos.colecoes.model.Carro;
import digytal.java.exemplos.colecoes.model.Marca;

public class Predicates {
	public static Predicate<Carro> carroMarcaPredicate(Marca marca){
		return c -> c.getMarca() == marca;
	}
}
