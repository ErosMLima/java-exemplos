package digytal.java.exemplos.jdbcjpa.repository.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import digytal.java.exemplos.jdbcjpa.util.StartHSQLDB;

public abstract class JDBCConnection {
	protected Connection connecton;
	public JDBCConnection() {
		try {
			//http://www.hsqldb.org/doc/2.0/guide/running-chapt.html
			//create table tab_produto(id int, nome varchar (50), codigo_barras varchar (20),valor_venda numeric (8,2));
			connecton= DriverManager.getConnection(StartHSQLDB.JDBC_FILE_URL, "SA", "");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
	}
}
