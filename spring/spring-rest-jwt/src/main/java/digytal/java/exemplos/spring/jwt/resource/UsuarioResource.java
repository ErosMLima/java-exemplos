package digytal.java.exemplos.spring.jwt.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digytal.java.exemplos.spring.jwt.model.Usuario;
import digytal.java.exemplos.spring.jwt.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public List<Usuario> list(){
		return repository.findAll(); 
	}
	@PostMapping
	public void save(@RequestBody Usuario usuario){
		repository.save(usuario);
	}
}
