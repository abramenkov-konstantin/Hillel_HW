package person.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDAO_MySQL implements PersonDAO
{

	@Override
	public void create (Person p)
	{
		Connection dbConnection=null;
		Statement statement =null;

		String createTableSQL = "CREATE TABLE DBUSER("
				+ "USER_ID NUMBER(5) NOT NULL, "
				+ "USERNAME VARCHAR(20) NOT NULL, "
				+ "CREATED_BY VARCHAR(20) NOT NULL, "
				+ "CREATED_DATE DATE NOT NULL, " + "PRIMARY KEY (USER_ID) "
				+ ")";
		try 
		{
			
			//DriverManager.getConnection("jdbc:mysql://localhost/person","root","0000");
			
			Class.forName("com.mysql.jdbc.Driver");
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","hawk7");
			statement = dbConnection.createStatement();

			// выполнить SQL запрос
			statement.execute(createTableSQL);
			System.out.println("Table \"dbuser\" is created!");

			statement.close();
			dbConnection.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			System.out.println(e.getMessage());
		} 
	}


	@Override
	public ArrayList<Person> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Person p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Person p) {
		// TODO Auto-generated method stub

	}


	

}
