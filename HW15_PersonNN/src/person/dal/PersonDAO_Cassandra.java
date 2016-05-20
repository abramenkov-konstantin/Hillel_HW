package person.dal;

import java.util.ArrayList;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class PersonDAO_Cassandra implements PersonDAO 
{
 Cluster cluster;  
 Session session;  
 
 @Override
 public void create(Person p) 
 {
  try 
  {
   cluster = Cluster.builder().addContactPoint("localhost").withPort(9042).build();
   session = cluster.connect();
   String  sqlAdd = "INSERT INTO PERSON (id, fname, lname, age) VALUES"
     + " (" + p.id + ", '" + p.fname + "', '" + p.lname + "', " + p.age + ");";
   session.execute(sqlAdd);
   session.close();
   cluster.close();
  } 
  catch (Exception e) 
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
   cluster = Cluster.builder().addContactPoint("localhost").withPort(9042).build();
   session = cluster.connect("testDB");
   ResultSet rs = session.execute("SELECT * FROM PERSON");
   
   for (Row row : rs) 
   {
    ar.add(new Person(row.getInt("id"), row.getString("fname"), row.getString("lname"), row.getInt("age")) );
   }

   session.close();
   cluster.close();
  } 
  catch (Exception e) 
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
   cluster = Cluster.builder().addContactPoint("localhost").withPort(9042).build();
   session = cluster.connect();
   String  sqlUpd = "UPDATE PERSON SET fname='" + p.fname + 
    "', lname='" + p.lname +"', age=" + p.age +
    " WHERE id=" + p.id +";";
   session.execute(sqlUpd);
   session.close();
   cluster.close();
  } 
  catch (Exception e) 
  {
   e.printStackTrace();
  } 
 }

 @Override
 public void delete(Person p) 
 {
  try 
  {
   cluster = Cluster.builder().addContactPoint("localhost").withPort(9042).build();
   session = cluster.connect();
   String  sqlDel = "DELETE FROM PERSON WHERE id=" + p.id + "";
   session.execute(sqlDel);
   session.close();
   cluster.close();
   
  } 
  catch (Exception e) 
  {
   e.printStackTrace();
  }
 }

}