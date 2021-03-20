package digytal.java.exemplos.model.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_produto")
public class Produto {
	@Id
	private Integer id;
	@Column(name = "codigo_barras")
	private String codigoBarras;
	private String nome;
	@Column(name = "valor_venda")
	private Double valorVenda;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}
	
}
