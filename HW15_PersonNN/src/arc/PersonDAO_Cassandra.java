package arc;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class PersonDAO_Cassandra 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Cluster cluster;
		Session session;

		// Connect to the cluster and keyspace "demo"
		cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect("persons");

		// Insert one record into the users table
		session.execute("INSERT INTO Person (id, fname, lname, age) VALUES (10, 'Vasiliy', 'Pupkin', 20)");
		session.execute("INSERT INTO Person (id, fname, lname, age) VALUES (20, 'Ivan', 'Babkin', 30)");

		// Use select to get the user we just entered
		ResultSet results = session.execute("SELECT * FROM users WHERE lname='Pupkin'");
		for (Row row : results) {
			System.out.format("%s %d\n", row.getString("fname"), row.getInt("age"));
		}

		// Update the same user with a new age
		session.execute("update users set age = 36 where lname='Pupkin'");

		// Select and show the change
		results = session.execute("select * from persons where lname='Pupkin'");
		for (Row row : results) {
			System.out.format("%s %d\n", row.getString("fname"), row.getInt("age"));
		}

		// Delete the person from the persons table
		session.execute("DELETE FROM persons WHERE lname = 'Pupkin'");

		// Show that the person is gone
		results = session.execute("SELECT * FROM persons");
		for (Row row : results) {
			System.out.format("%s %d %s \n", row.getString("lname"), row.getInt("age"), row.getString("fname"));
		}
		// Clean up the connection by closing it
		cluster.close();
	}
	
	
	
	
}
