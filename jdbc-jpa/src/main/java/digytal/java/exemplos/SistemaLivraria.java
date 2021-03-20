package digytal.java.exemplos;

import java.util.Date;

import digytal.java.exemplos.model.cadastro.Cadastro;
import digytal.java.exemplos.model.cadastro.Produto;
import digytal.java.exemplos.model.venda.Pedido;
import digytal.java.exemplos.model.venda.PedidoItem;
import digytal.java.exemplos.repository.fake.FakeCadastroRepostory;
import digytal.java.exemplos.repository.fake.FakeProdutoRepostory;

public class SistemaLivraria {
	
	public static void main(String[] args) {
		fakeRepository();
	}
	
	private static void fakeRepository() {
		FakeCadastroRepostory cadastroRepositorio = new FakeCadastroRepostory();
		FakeProdutoRepostory livroRepositorio = new FakeProdutoRepostory();
		
		Produto livro = new Produto();
		livro.setCodigoBarras("123123");
		livro.setTitulo("A CINCO PESSOAS QUE VC ENCONTRA NO CEU");
		livro.setValorVenda(17.00);
		livroRepositorio.insert(livro);
		
		Cadastro cadastro = new Cadastro();
		cadastro.setEmail("gleyson@digytal.com.br");
		cadastro.setNome("GLEYSON SAMPAIO");
		cadastro.setTelefone(11978964563L);
		
		cadastroRepositorio.insert(cadastro);
		
		Pedido p = new Pedido();
		Cadastro c = cadastroRepositorio.select(1);
		p.setCliente(c);
		p.setData(new Date());
		
		Produto produto = livroRepositorio.select(1);
		
		p.addItem(produto, 10.0);
		
		System.out.println(p.getValorTotal());
		
		for(PedidoItem i: p.getItens()) {
			System.out.println(i.getProduto().getTitulo() + " -- " + i.getQuantidade() + " " + i.getValorVenda() + " " + i.getValorTotal());
		}
	}
}
