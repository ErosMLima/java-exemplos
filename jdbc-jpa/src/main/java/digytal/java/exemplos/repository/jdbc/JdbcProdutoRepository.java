package digytal.java.exemplos.repository.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digytal.java.exemplos.model.cadastro.Produto;
import digytal.java.exemplos.repository.Repository;
import digytal.java.exemplos.util.StartHSQLDB;

public class JdbcProdutoRepository implements Repository<Produto> {
	private Connection connecton;
	public JdbcProdutoRepository() {
		try {
			//http://www.hsqldb.org/doc/2.0/guide/running-chapt.html
			
			//create table tab_produto(id int, nome varchar (50), codigo_barras varchar (20),valor_venda numeric (8,2));
			
			connecton= DriverManager.getConnection(StartHSQLDB.JDBC_FILE_URL, "SA", "");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
	}
	public void insert(Produto e) {
		try {
			PreparedStatement st = connecton.prepareStatement("INSERT INTO tab_produto(id,nome,codigo_barras,valor_venda) values(?,?,?,?)");
			st.setInt(1, e.getId());
			st.setString(2, e.getNome());
			st.setString(3, e.getCodigoBarras());
			st.setDouble(4, e.getValorVenda());
			int i=st.executeUpdate();  
			System.out.println(i);
			
			st.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	public void update(Produto e) {
		try {
			PreparedStatement st = connecton.prepareStatement("UPDATE tab_produto set nome=?,codigo_barras=?,valor_venda=? WHERE ID = ?");
			st.setString(1, e.getNome());
			st.setString(2, e.getCodigoBarras());
			st.setDouble(3, e.getValorVenda());
			
			st.setInt(4, e.getId());
			int i=st.executeUpdate();  
			System.out.println(i);
			
			st.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public Produto select(Integer id) {
		String sql = "SELECT nome,codigo_barras,valor_venda,id FROM tab_produto WHERE id = ? ";
		try {
			PreparedStatement st = connecton.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			Produto registro=null;
			while(rs.next()){
				registro=converter(rs);
			}
			return registro;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Produto> selectAll() {
		String sql = "SELECT nome,codigo_barras,valor_venda,id FROM tab_produto WHERE id = ? ";
		List<Produto> produtos=new ArrayList<Produto>();
		try {
			PreparedStatement st = connecton.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				Produto registro=converter(rs);
				produtos.add(registro);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return produtos;
	}
	private Produto converter(ResultSet rs) throws Exception{
		
		Produto produto = new Produto();
		produto.setNome(rs.getString("nome"));
		produto.setCodigoBarras(rs.getString("codigo_barras"));
		produto.setValorVenda(rs.getDouble("valor_venda"));
		produto.setId(rs.getInt("id"));
		return produto;
	}
	public void fechar() {
		try {
			connecton.close();
			System.exit(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
