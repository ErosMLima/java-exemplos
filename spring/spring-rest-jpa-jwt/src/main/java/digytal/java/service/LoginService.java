package digytal.java.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import digytal.java.dto.Sessao;
import digytal.java.model.Login;
import digytal.java.repository.LoginRepository;
import digytal.java.security.JWTUtils;

@Service
public class LoginService {
	@Autowired
	private LoginRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public void criar(Login login) {
		String pass = login.getPassword();
		//criptografando antes de salvar no banco
		login.setPassword(encoder.encode(pass));
		
		repository.save(login);
		
	}
	public Sessao logar(Login login) {
		//considerando que os dados serão válidos
		Login dbLogin = repository.findById(login.getUsername()).orElse(null);
		
		boolean passwordOk = encoder.matches(login.getPassword(),dbLogin.getPassword());

		if (!passwordOk) {
			throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
		}
		
		Sessao sessao = new Sessao();
		Date issuedAt = new Date(System.currentTimeMillis());
		Date expriration = (new Date(System.currentTimeMillis() + JWTUtils.TOKEN_EXPIRATION));
		
		sessao.setLogin(login.getUsername());

		sessao.setToken(JWTUtils.create(sessao.getLogin(), issuedAt, expriration));
		
		return sessao;
		
	}
}
