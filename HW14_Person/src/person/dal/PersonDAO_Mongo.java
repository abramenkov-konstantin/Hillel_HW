package person.dal;

import java.util.ArrayList;
import com.mongodb.*;


public class PersonDAO_Mongo implements PersonDAO
{
	
	
	@Override
	public void create(Person p) 
	{
		Mongo m = new Mongo("localhost:27017");
        DB db = m.getDB( "hellomongodb" );
        DBCollection collection = db.getCollection( "hello" );
        DBObject helloDbObject = BasicDBObjectBuilder.start()
        .append("hello", "hellomongo!!!").get();
        collection.save(helloDbObject);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Person> read() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Person p) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Person p) 
	{
		// TODO Auto-generated method stub
		
	}

}
