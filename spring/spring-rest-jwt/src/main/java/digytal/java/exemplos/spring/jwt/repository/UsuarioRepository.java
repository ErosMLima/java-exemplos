package digytal.java.exemplos.spring.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import digytal.java.exemplos.spring.jwt.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
}
