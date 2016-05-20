package person.view;

import java.sql.SQLException;

//import com.mongodb.*;

public class XMain 
{
	
	public static void main(String[] args) throws SQLException
	{
		new XFrame();
		
		 /*try{
				
	         // To connect to mongodb server
	         MongoClient mongoClient = new MongoClient( "localhost:27017");
				
	         // Now connect to your databases
	         
	     	DB db = mongoClient.getDB("person");
	         
	         System.out.println("Connect to database successfully");
	         				
	      }catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }*/
		
		
		
		/*Connection dbConnection=null;
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
		} */
		
		
	}
}
