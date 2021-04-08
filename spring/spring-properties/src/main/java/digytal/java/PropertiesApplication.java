package digytal.java;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PropertiesApplication {
	public static void main(String[] args) {
		SpringApplication.run(PropertiesApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner run(FtpService ftp, EmailService email) {
        return args -> {
			System.out.println("Iniciando a leitura do applications.properties");
        	ftp.conectar();
        	email.enviar();
			System.out.println("Fim do processo");
			System.out.println("Ola mundo");

		};
    }
}
