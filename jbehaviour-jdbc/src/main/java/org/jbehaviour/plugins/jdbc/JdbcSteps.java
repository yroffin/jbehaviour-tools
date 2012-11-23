package org.jbehaviour.plugins.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcSteps {
	static Logger logger = LoggerFactory.getLogger(JdbcSteps.class);

	Connection conn = null;

	@Given("connect with $driver and url $url $user $passwrd as $reference")
	public Connection connectJdbc(String driver, String url, String user, String pass,
			String reference) throws SQLException, ClassNotFoundException {
		Class.forName(driver);
        conn = DriverManager.getConnection(url,user,pass);
        logger.info(conn.toString());
        return conn;
	}

	@Then("query $value")
	public int query(String value) throws SQLException, ClassNotFoundException {
		Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(value);
        return rs.getRow();
	}
}
