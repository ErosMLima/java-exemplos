package digytal.java.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class EnderecoDto {
	@ApiModelProperty(notes = "Número do CEP", name = "Cep", required = true,dataType = "string", example = "01001000" )
	private String cep;
	@ApiModelProperty(notes = "Nome da Rua, Avenida", name = "Logradouro", required = true,dataType = "string", example = "Praça da Sé" )
	private String logradouro;
	@ApiModelProperty(notes = "Bairro do endereço", name = "Bairro", required = true,dataType = "string", example = "Sé" )
	private String bairro;
	@ApiModelProperty(notes = "Nome da Cidade", name = "Localidade", required = true,dataType = "string", example = "São Paulo" )
	private String localidade;
	public EnderecoDto() {
		
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	
}
