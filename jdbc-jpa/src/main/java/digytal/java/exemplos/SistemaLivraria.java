package digytal.java.exemplos;

import java.util.Date;

import digytal.java.exemplos.model.cadastro.Cadastro;
import digytal.java.exemplos.model.cadastro.Produto;
import digytal.java.exemplos.model.venda.Pedido;
import digytal.java.exemplos.model.venda.PedidoItem;
import digytal.java.exemplos.repository.fake.FakeCadastroRepostory;
import digytal.java.exemplos.repository.fake.FakeProdutoRepostory;
import digytal.java.exemplos.repository.jdbc.JdbcProdutoRepository;

public class SistemaLivraria {
	
	public static void main(String[] args) {
		//fakeRepository();
		jdbcRepository();
	}
	private static void jdbcRepository() {
		JdbcProdutoRepository produtoRepository = new JdbcProdutoRepository();
		
		Produto produto = new Produto();
		produto.setId(1);
		produto.setCodigoBarras("123123");
		produto.setNome("A CINCO PESSOAS QUE VC ENCONTRA NO CEU");
		produto.setValorVenda(17.00);
		produtoRepository.insert(produto);
		
		
		
		//o HSQL DB PRECISA FECHAR a conexao
		produtoRepository.fechar();
		
	}
	private static void fakeRepository() {
		FakeCadastroRepostory cadastroRepositorio = new FakeCadastroRepostory();
		FakeProdutoRepostory produtoRepository = new FakeProdutoRepostory();
		
		Produto produto = new Produto();
		produto.setId(1);
		produto.setCodigoBarras("123123");
		produto.setNome("A CINCO PESSOAS QUE VC ENCONTRA NO CEU");
		produto.setValorVenda(17.00);
		produtoRepository.insert(produto);
		
		Cadastro cadastro = new Cadastro();
		cadastro.setEmail("gleyson@digytal.com.br");
		cadastro.setNome("GLEYSON SAMPAIO");
		cadastro.setTelefone(11978964563L);
		
		cadastroRepositorio.insert(cadastro);
		
		Pedido p = new Pedido();
		Cadastro c = cadastroRepositorio.select(1);
		p.setCliente(c);
		p.setData(new Date());
		
		produto = produtoRepository.select(1);
		
		p.addItem(produto, 10.0);
		
		System.out.println(p.getValorTotal());
		
		for(PedidoItem i: p.getItens()) {
			System.out.println(i.getProduto().getNome() + " -- " + i.getQuantidade() + " " + i.getValorVenda() + " " + i.getValorTotal());
		}
	}
}
