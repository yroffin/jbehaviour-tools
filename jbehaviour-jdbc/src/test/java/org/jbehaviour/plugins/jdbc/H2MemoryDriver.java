package org.jbehaviour.plugins.jdbc;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class H2MemoryDriver {
	static Logger logger = LoggerFactory.getLogger(H2MemoryDriver.class);

	Server server = null;
	public void start() throws SQLException, ClassNotFoundException {
		server = Server.createTcpServer("-pgDaemon").start();
		connect();
	}

	public void stop() throws SQLException {
		conn.close();
		server.stop();
	}
	
	Connection conn = null;
	public Connection connect() throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:mem", "sa", "");
        return conn;
	}

	public void execute(String sql) throws SQLException {
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.execute();
	}

	public void load(File filename) throws IOException, SQLException {
		FileReader fr = new FileReader(filename);
		char[] cbuf = new char[16384];
		fr.read(cbuf);
		fr.close();
		for(String line : new String(cbuf).split("\n")) {
			logger.info(line);
			execute(line);
		}
	}

}
