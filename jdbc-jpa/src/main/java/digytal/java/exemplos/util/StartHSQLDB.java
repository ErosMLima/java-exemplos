package digytal.java.exemplos.util;

import org.hsqldb.util.DatabaseManagerSwing;

public class StartHSQLDB {
	static String FILE_URL = "file:/temp/db/exemplo-db";

	public static void main(String[] args) {
		local();
		//server();
	}

	public static void local() {
		final String[] dbArgs = { "--user", "sa", "--password", "", "--url", "jdbc:hsqldb:" + FILE_URL };
		DatabaseManagerSwing.main(dbArgs);

	}
	public static void server() {
		final String[] dbArgs = { "--database.0", FILE_URL, "--dbname.0", "webapidb", "--port", "5454" };
		org.hsqldb.server.Server.main(dbArgs);
		//final String[] serveArgs = { "--user", "sa", "--password", "", "--url", "jdbc:hsqldb:hsql://localhost:5454/webapidb"};
		//DatabaseManagerSwing.main(serveArgs);
	}
}
