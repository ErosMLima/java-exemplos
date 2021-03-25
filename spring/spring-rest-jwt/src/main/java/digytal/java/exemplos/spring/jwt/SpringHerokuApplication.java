package digytal.java.exemplos.spring.jwt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import digytal.java.exemplos.spring.jwt.model.Usuario;
import digytal.java.exemplos.spring.jwt.repository.UsuarioRepository;

@SpringBootApplication
public class SpringHerokuApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHerokuApplication.class, args);
	}
	@Bean
    public CommandLineRunner run(UsuarioRepository r, PasswordEncoder encoder) throws Exception {
        return args -> {
        	Usuario u = new Usuario();
        	u.setLogin("admin");
        	String senhaCriptografada = encoder.encode("admin123");
        	u.setSenha(senhaCriptografada);
        	r.save(u);
        };
	}
}
