package digytal.java.exemplos.colecoes.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import digytal.java.exemplos.colecoes.model.Carro;
import static digytal.java.exemplos.colecoes.model.Marca.*;
public class Repository {
	public static Carro[] CARROS = 
	{
			new Carro("ABC-1234","9700975","FORD FIESTA",2010,FORD),
			new Carro("FAT-7087","9700975","FORD KA",2021,FORD),
			new Carro("HGT-7658","7861236","FIAT PALIO",2020,FIAT),
			new Carro("ASD-0918","8798766","RENAULT DUSTER",2008,RENAULT),
			new Carro("HIQ-9823","1936630","JEEP RENEGADE",2021,JEEP)
			
	};

	public static List<Carro> listCarros(){
		return new ArrayList<Carro>(Arrays.asList(CARROS));
	}
}
