package digytal.java.exemplos.jdbcjpa.util;

import org.hsqldb.util.DatabaseManagerSwing;

public class StartHSQLDB {
	public static String FILE_URL = "file:/temp/db/exemplo-db";
	public static String JDBC_FILE_URL = "jdbc:hsqldb:" + FILE_URL;
	public static void main(String[] args) {
		System.out.println(JDBC_FILE_URL);
		local();
		//server();
	}

	public static void local() {
		final String[] dbArgs = { "--user", "sa", "--password", "", "--url", JDBC_FILE_URL};
		DatabaseManagerSwing.main(dbArgs);

	}
	public static void server() {
		final String[] dbArgs = { "--database.0", FILE_URL, "--dbname.0", "webapidb", "--port", "5454" };
		org.hsqldb.server.Server.main(dbArgs);
		//final String[] serveArgs = { "--user", "sa", "--password", "", "--url", "jdbc:hsqldb:hsql://localhost:5454/webapidb"};
		//DatabaseManagerSwing.main(serveArgs);
	}
}
