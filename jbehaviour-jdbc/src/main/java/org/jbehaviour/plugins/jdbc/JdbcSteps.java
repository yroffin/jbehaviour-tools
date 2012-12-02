package org.jbehaviour.plugins.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.jbehaviour.annotation.EnvReference;
import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Then;
import org.jbehaviour.annotation.When;
import org.jbehaviour.reflexion.IBehaviourEnv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcSteps {
	static Logger logger = LoggerFactory.getLogger(JdbcSteps.class);

	@EnvReference
	public IBehaviourEnv env = null;

	int columnLength = 16;
	Connection conn = null;

	enum databaseType {
		H2
	};
	databaseType type = null;

	@Given("column length to $length bytes")
	public void setColumnLength(Integer len) {
		columnLength = len;
	}

	@Given("connect with $driver and url $url $user $passwrd as $reference")
	public Connection connectJdbc(String driver, String url, String user, String pass,
			String reference) throws SQLException, ClassNotFoundException {
		Class.forName(driver);
        conn = DriverManager.getConnection(url,user,pass);
        logger.info(conn.toString());
        
        /**
         * H2 database type
         */
        if("H2".compareTo(conn.getMetaData().getDatabaseProductName()) == 0) {
        	type = databaseType.H2;
        }

        return conn;
	}

	IBehaviourResultSet lastResult = null;

	@Given("desc $table")
	public IBehaviourResultSet descTable(String table) throws SQLException {
		Statement stmt = conn.createStatement();
		switch(type) {
			case H2:
				lastResult = new JBehaviourResultSet(columnLength,stmt.executeQuery("SHOW COLUMNS FROM " + table));
			break;
			default:
				lastResult = new JBehaviourResultSet(columnLength,stmt.executeQuery("DESCRIBE " + table));
			break;
		}
		stmt.close();
        return lastResult;
	}

	@When("query $value as $reference")
	public IBehaviourResultSet query(String value, String reference) throws SQLException, ClassNotFoundException {
		Statement stmt = conn.createStatement();
		lastResult = new JBehaviourResultSet(columnLength,stmt.executeQuery(value));
		stmt.close();
        return (IBehaviourResultSet) env.store(reference, lastResult);
	}

	@Then("$reference have $nb lines")
	public boolean verifyNumberLine(IBehaviourResultSet reference, int value) throws SQLException, ClassNotFoundException {
		return reference.getRows() == value;
	}
}
