package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDAO_MySQL implements PersonDAO
{

	@Override
	public void create(Person p) 
	{
			String query = "INSERT INTO PERSON VALUES (" + p.id + ", '" + p.fname + "', '" 
							+ p.lname + "', " + p.age + ");";
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                        "user=root&password=0000");
				Statement st = con.createStatement();
				st.execute(query);
				st.close();
				con.close();
			} 
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public ArrayList<Person> read()
	{
		ArrayList<Person> rr = new ArrayList<Person>();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                    "user=root&password=0000");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from person");

			while(rs.next())
			{
				rr.add( new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)) ); 
			}

			rs.close();
			st.close();
			con.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rr;
	}

	@Override
	public void update(Person p) 
	{	
		String query =  "UPDATE PERSON SET FNAME='"+ p.fname +"', LNAME='"
				+ p.lname +"', AGE=" + p.age + " WHERE ID=" + p.id;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                    "user=root&password=0000");
			Statement st = con.createStatement();
			st.execute(query);
			st.close();
			con.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Person p) {
		String query = "DELETE FROM PERSON WHERE ID=" + p.id;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                    "user=root&password=0000");
			Statement st = con.createStatement();
			st.execute(query);
			st.close();
			con.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{		
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}

