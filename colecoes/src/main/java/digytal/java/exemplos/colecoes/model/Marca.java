package digytal.java.exemplos.colecoes.model;

public enum Marca {
	FORD("ALEMANHA"),
	FIAT("ESPANHA"),
	JEEP("INGLATERRA"),
	RENAULT("ESTADOS UNIDOS"),
	PEUGEOT("ESTADOS UNIDOS");
	
	private String pais;
	
	private Marca(String pais) {
		this.pais = pais;
	}
	public String getPais() {
		return pais;
	}
	public String getNome() {
		return name();
	}
}
