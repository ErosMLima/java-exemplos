package digytal.java.exemplos.colecoes.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import digytal.java.exemplos.colecoes.model.Carro;

public class Repository {
	public static Carro[] CARROS = 
	{
			new Carro("ABC-1234","9700975","FORD FIESTA",2010),
			new Carro("FAT-7087","9700975","FORD KA",2021),
			new Carro("HGT-7658","7861236","FIAT PALIO",2020),
			new Carro("ASD-0918","8798766","RENAULT DUSTER",2008),
			new Carro("HIQ-9823","1936630","JEEP RENEGADE",2021)
			
	};

	public static List<Carro> listCarros(){
		return new ArrayList<Carro>(Arrays.asList(CARROS));
	}
}
