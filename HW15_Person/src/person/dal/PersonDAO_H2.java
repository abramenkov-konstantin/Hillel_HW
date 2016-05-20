package person.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDAO_H2 implements PersonDAO
{
	private static final String CLASS = "org.h2.Driver";
	private static final String SERVER = "jdbc:h2:~/test"; 
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "";
	private Connection con = null;
	private Statement st = null;

	
	public static void main(String[] args)
	{
		PersonDAO pd = new PersonDAO_H2(); //это мост (Bridge)
		System.out.println("TestH2");
		
		pd.create (new Person (106, "NewVova", "NewPupkins", 56));
		
		ArrayList<Person> rr = pd.read();
			
		for (Person p : rr) 
		{
			System.out.println(p);
		}
	}
		

	@Override
	public void create(Person p) 
	{
		String all = "INSERT INTO PERSON VALUES(" + p.id +", '" + p.fname +"', '"+ p.lname + "', "+ p.age+");";
		try {
			Class.forName(CLASS);
			con = DriverManager.getConnection(SERVER,USERNAME,PASSWORD);
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
		ResultSet rs = null;
		ArrayList<Person> ar = new ArrayList<Person>();
		try {
			Class.forName(CLASS);
			con = DriverManager.getConnection(SERVER,USERNAME,PASSWORD);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM PERSON ORDER BY ID;");
			while(rs.next())
			{
				ar.add( new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
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
		String all =  "UPDATE PERSON SET FNAME='" + p.fname +"' WHERE ID=" + p.id +";"
				    + "UPDATE PERSON SET LNAME='" + p.lname +"' WHERE ID=" + p.id +";"
				    + "UPDATE PERSON SET AGE='"   + p.age   +"' WHERE ID=" + p.id +";";
		try {
			Class.forName(CLASS);
			con = DriverManager.getConnection(SERVER,USERNAME,PASSWORD);
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
	public void delete(Person p) 
	{
		String all = "DELETE FROM PERSON WHERE ID="+ p.id +";";
		try {
			Class.forName(CLASS);
			con = DriverManager.getConnection(SERVER,USERNAME,PASSWORD);
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
