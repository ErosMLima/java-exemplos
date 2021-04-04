package digytal.java.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digytal.java.dto.Sessao;
import digytal.java.model.Login;
import digytal.java.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginResource {
	@Autowired
	private LoginService service;
	
	@PostMapping
	public Sessao logar(@RequestBody Login login) throws Exception {
		return service.logar(login);
	}
	
	@PostMapping(path = "/new")
	public void criar(@RequestBody Login login) throws Exception {
		service.criar(login);
	}
}
