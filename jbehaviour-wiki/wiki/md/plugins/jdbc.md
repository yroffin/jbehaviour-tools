Jdbc Extention
==============

1. Setup
--------

This step is stored in maven module : jbehaviour-jdbc

This step implements:
- jdbc connect
- describe table
- select from entities and store result

2. Jdbc connect
---------------

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
        	type = JdbcDatabaseType.H2;
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



2. Sample
---------

	Feature: Launch all test from jdbc feature
		In order to test this feature
		As an explicit system actor
		I want to verify this behaviour
		Register system  with "org.jbehaviour.plugins.system.SystemSteps" plugin
		Register jdbc    with "org.jbehaviour.plugins.jdbc.JdbcSteps" plugin
		Declare driverJdbc as String 'org.h2.Driver'

	Scenario: Verify we can use this jdbc driver
		Given connect with 'org.h2.Driver' and url 'jdbc:h2:mem' 'sa' '' as 'connexion01'
		Given column length to 20 bytes
		Given desc 'TEST1'
		When  query 'SELECT * FROM TEST1' as select1
		When  query 'SELECT * FROM TEST2' as select2
		When  query 'SELECT * FROM TEST3' as select3
		When  query 'SELECT * FROM TEST4' as select4
		Then  $select1 have 4 lines
		Then  $select2 have 4 lines
		Then  $select3 have 5 lines
		Then  $select4 have 6 lines
