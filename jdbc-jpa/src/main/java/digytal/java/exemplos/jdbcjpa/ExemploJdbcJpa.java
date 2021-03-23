package digytal.java.exemplos.jdbcjpa;

import java.util.Date;

import digytal.java.exemplos.jdbcjpa.model.cadastro.Cadastro;
import digytal.java.exemplos.jdbcjpa.model.cadastro.Produto;
import digytal.java.exemplos.jdbcjpa.model.venda.Pedido;
import digytal.java.exemplos.jdbcjpa.model.venda.PedidoItem;
import digytal.java.exemplos.jdbcjpa.repository.fake.FakeCadastroRepostory;
import digytal.java.exemplos.jdbcjpa.repository.fake.FakeProdutoRepostory;
import digytal.java.exemplos.jdbcjpa.repository.jdbc.JdbcProdutoRepository;
import digytal.java.exemplos.jdbcjpa.repository.jpa.JpaProdutoRepository;

public class ExemploJdbcJpa {
	
	public static void main(String[] args) {
		//fakeRepository();
		//jdbcRepository();
		jpaRepository();
	}
	private static void jpaRepository() {
		JpaProdutoRepository produtoRepository = new JpaProdutoRepository();
		
		Produto produto = new Produto();
		//produto.setId(2);
		produto.setCodigoBarras("89898");
		produto.setNome("O MONGE E O EXECUTIVO");
		produto.setValorVenda(19.35);
		produtoRepository.insert(produto);		
		//o HSQL DB PRECISA FECHAR a conexao
		produtoRepository.fechar();
		//System.exit(0);
	}
	private static void jdbcRepository() {
		JdbcProdutoRepository produtoRepository = new JdbcProdutoRepository();
		
		Produto produto = new Produto();
		produto.setId(1);
		produto.setCodigoBarras("123123");
		produto.setNome("A CINCO PESSOAS QUE VC ENCONTRA NO CEU");
		produto.setValorVenda(17.00);
		produtoRepository.insert(produto);
		
		
		Produto dbProd = produtoRepository.select(1);
		
		dbProd.setNome("FANTA");
		
		produtoRepository.update(dbProd);
		
		
		//o HSQL DB PRECISA FECHAR a conexao
		produtoRepository.fechar();
		//System.exit(0);
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
