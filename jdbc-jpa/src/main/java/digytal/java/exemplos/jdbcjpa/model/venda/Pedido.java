package digytal.java.exemplos.jdbcjpa.model.venda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import digytal.java.exemplos.jdbcjpa.model.cadastro.Cadastro;
import digytal.java.exemplos.jdbcjpa.model.cadastro.Produto;

public class Pedido {
	private Integer id;
	private Date data;
	private Double valorTotal=0.0;
	private Cadastro cliente;
	
	private List<PedidoItem> itens = new ArrayList<PedidoItem>();

	public void addItem(Produto produto, Double quantidade) {
		PedidoItem item = new PedidoItem();
		item.setProduto(produto);
		item.setValorVenda(produto.getValorVenda());
		item.setQuantidade(quantidade);
		item.setValorTotal(item.getQuantidade() * item.getValorVenda());
		
		this.valorTotal = this.valorTotal + item.getValorTotal();
		
		this.itens.add(item);
		
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cadastro getCliente() {
		return cliente;
	}

	public void setCliente(Cadastro cliente) {
		this.cliente = cliente;
	}

	public List<PedidoItem> getItens() {
		return itens;
	}

	
	
}
