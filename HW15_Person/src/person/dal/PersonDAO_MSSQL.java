package person.dal;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDAO_MSSQL implements PersonDAO 
{
	private String url = "jdbc:microsoft:sqlserver://localhost:1433;MyPersonDB";

	@Override
	public void create(Person p) 
	{
		try 
		{
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			Connection con = DriverManager.getConnection(url,"admin","admin");

			String  sqlAdd = "INSERT INTO PERSON (id, fname, lname, age) VALUES"
					+ " (" + p.id + ", '" + p.fname + "', '" + p.lname + "', " + p.age + ");";
			Statement st = con.createStatement();
			st.execute(sqlAdd); 
			st.close();
			con.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Person> read() 
	{
		ArrayList<Person> ar = new ArrayList<Person>();

		try 
		{
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			Connection con = DriverManager.getConnection(url,"admin","admin");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM PERSON");

			while(rs.next())
			{
				ar.add( new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)) ); 
			}
			rs.close();
			st.close();
			con.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return ar;
	}

	@Override
	public void update(Person p) 
	{
		try 
		{
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			Connection con = DriverManager.getConnection(url,"admin","admin");

			String  sqlAdd = "UPDATE PERSON SET fname='" + p.fname + 
					"', lname='" + p.lname +"', age=" + p.age +
					" WHERE id=" + p.id +";";

			Statement st = con.createStatement();
			st.execute(sqlAdd); 
			st.close();
			con.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}	
	}

	@Override
	public void delete(Person p) 
	{
		try 
		{
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			Connection con = DriverManager.getConnection(url,"admin","admin");

			String  sqlDel = "DELETE FROM PERSON WHERE id=" + p.id + "";
			Statement st = con.createStatement();
			st.execute(sqlDel); 
			st.close();
			con.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
