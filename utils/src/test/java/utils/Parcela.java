package utils;

public class Parcela {
	private String parcela;
	private String date;
	private Double valor;
	public Parcela(String parcela, String date, Double valor) {
		super();
		this.parcela = parcela;
		this.date = date;
		this.valor = valor;
	}
	public String getParcela() {
		return parcela;
	}
	public String getDate() {
		return date;
	}
	public Double getValor() {
		return valor;
	}
	
}
