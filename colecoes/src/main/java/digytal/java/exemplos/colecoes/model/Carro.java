package digytal.java.exemplos.colecoes.model;

public class Carro {
	private String placa;
	private String chassi;
	private String nome;
	private Integer ano;
	private Marca marca;
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
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
	public Carro(String placa, String chassi, String nome, Integer ano, Marca marca) {
		super();
		this.placa = placa;
		this.chassi = chassi;
		this.nome = nome;
		this.ano=ano;
		this.marca = marca;
	}
	@Override
	public String toString() {
		return "Carro [placa=" + placa + ", chassi=" + chassi + ", nome=" + nome + ", ano=" + ano + ", marca=" + marca
				+ "]";
	}
	
	
	
}
