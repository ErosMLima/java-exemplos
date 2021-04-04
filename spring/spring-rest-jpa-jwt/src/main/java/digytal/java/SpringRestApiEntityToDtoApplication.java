package digytal.java;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import digytal.java.repository.EnderecoRepository;

@SpringBootApplication
public class SpringRestApiEntityToDtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApiEntityToDtoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run(EnderecoRepository repository) throws Exception {
		return args -> {
			//Endereco end = new Endereco("01001000", "Praça da Sé", "Sé", "São Paulo");
			//repository.save(end);
		};
	}
}
