package digytal.java.exemplos.colecoes.model;

public class Carro {
	private String placa;
	private String chassi;
	private String nome;
	private Integer ano;
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Carro() {
		
	}
	public Carro(String placa, String chassi, String nome, Integer ano) {
		super();
		this.placa = placa;
		this.chassi = chassi;
		this.nome = nome;
		this.ano=ano;
	}
	@Override
	public String toString() {
		return "Carro [placa=" + placa + ", chassi=" + chassi + ", nome=" + nome + ", ano=" + ano + "]";
	}
	
	
}
