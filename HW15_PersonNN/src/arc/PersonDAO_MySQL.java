package arc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import person.dal.Person;
import person.dal.PersonDAO;

public class PersonDAO_MySQL implements PersonDAO
{


	private static final String CLASS = "com.mysql.jdbc.Driver";
	//private static final String SERVER = "jdbc:mysql://localhost:3306/person?useSSL=false";
	private static final String SERVER = "jdbc:mysql://localhost/mysql";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs= null;

	@Override
	public void create(Person p) 
	{
		String all = "INSERT INTO PERSON VALUES(" + p.id + ", " + p.fname + ", " + p.lname + ", " + p.age + ");";
		//String  all = "INSERT INTO PERSON (id, fname, lname, age) VALUES"
		//		+ " (" + p.id + ", '" + p.fname + "', '" + p.lname + "', " + p.age + ");";
		try 
		{
			Class.forName(CLASS);
			con = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);
			st = con.createStatement();
			st.execute(all);
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
			Class.forName(CLASS);
			con = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM PERSON");
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
		String all = "UPDATE PERSON SET fname = " + p.fname + ", lname = " 
				+ p.lname + ", age = " + p.age + " WHERE id = " + p.id + ";";
		try 
		{
			Class.forName(CLASS);
			con = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);
			st = con.createStatement();
			st.execute(all);
			st.close();
			con.close();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete (Person p) 
	{
		String all = "DELETE FROM PERSON  Where ID = " + p.id + ";";
		try 
		{
			Class.forName(CLASS);
			con = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);
			st = con.createStatement();
			st.execute(all);
			st.close();
			con.close();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
