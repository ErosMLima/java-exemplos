package digytal.java.exemplos.spring.jwt.model;

import io.swagger.annotations.ApiModelProperty;

public class Login {
	@ApiModelProperty(value = "Usuario", example = "user", name ="User" )
	private String usuario;
	@ApiModelProperty(value = "Senha", example = "123#123", name ="Password" )
	private String senha;
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public String getUsuario() {
		return usuario;
	}
	
}
