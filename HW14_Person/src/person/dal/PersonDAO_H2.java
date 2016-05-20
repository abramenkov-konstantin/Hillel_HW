package person.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDAO_H2 implements PersonDAO
{

	@Override
	public void create(Person p) 
	{
		try {
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			Statement st = con.createStatement();

			String all = "INSERT INTO PERSON VALUES(" + p.id +", '" + p.fname +"', '"+ p.lname + "', "+ p.age+");";
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

		try {
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM PERSON ORDER BY ID;");

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
		try {
			Class.forName("org.h2.Driver");

			Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			Statement st = con.createStatement();

			String all = "UPDATE PERSON SET FNAME='" + p.fname +"' WHERE ID="+ p.id +";";
			st.execute(all);
			all = "UPDATE PERSON SET LNAME='" + p.lname +"' WHERE ID="+ p.id +";";
			st.execute(all);
			all = "UPDATE PERSON SET AGE='" + p.age +"' WHERE ID="+ p.id +";";
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
		try {
			Class.forName("org.h2.Driver");

			Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			Statement st = con.createStatement();
			
			String all = "DELETE FROM PERSON WHERE ID="+ p.id +";";
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
