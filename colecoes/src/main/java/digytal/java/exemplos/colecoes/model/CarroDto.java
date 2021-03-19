package digytal.java.exemplos.colecoes.model;

public class CarroDto {
	private String nome;
	private String marca;
	private String pais;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public CarroDto(String nome, String marca, String pais) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.pais = pais;
	}
	public CarroDto() {
		
	}
	@Override
	public String toString() {
		return "CarroDto [nome=" + nome + ", marca=" + marca + ", pais=" + pais + "]";
	}
	
}
