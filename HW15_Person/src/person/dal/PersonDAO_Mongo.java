package person.dal;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.*;

public class PersonDAO_Mongo implements PersonDAO
{
	private static final String SERVER = "localhost"; 
	private static final int PORT = 27017; 
	private static final String DATABASE = "pdb";
	private static final String COLLECTION = "person";

	public static void main(String[] args) throws UnknownHostException 
	{
		PersonDAO_Mongo mongoClient = new PersonDAO_Mongo();
		
		mongoClient.create(new Person(1, "Vasya", "Pup", 10));
		mongoClient.create(new Person(2, "Vova", "Vasil", 11));
		mongoClient.create(new Person(3, "Petya", "Brivkin", 12));
		mongoClient.create(new Person(4, "Kolya", "Ivanov", 12));
				
		mongoClient.update(new Person(4, "NewKolya", "NewIvanov", 15));
		mongoClient.delete(new Person(3, "Petya", "Brivkin", 12));
				
		ArrayList<Person> persons = mongoClient.read();
		for (Person person : persons) 
		{
			System.out.println(person);
		}
	}

	@Override
	public void create(Person p) 
	{
		MongoClient mongoClient = null;
		try 
		{
			mongoClient = new MongoClient(SERVER, PORT);
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		}

		DB db = mongoClient.getDB(DATABASE);
		DBCollection collection = (DBCollection) db.getCollection(COLLECTION);
		DBObject dbObject = BasicDBObjectBuilder.start()
				.append("_id", p.id).append("fname", p.fname)
				.append("lname",p.lname).append("age", p.age).get();
		collection.save(dbObject);
		mongoClient.close();

	}

	@Override
	public ArrayList<Person> read() 
	{
		ArrayList<Person> p = new ArrayList<>();

		MongoClient mongoClient = null;
		try 
		{
			mongoClient = new MongoClient(SERVER, PORT);
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		}
		//		MongoDatabase db = mongoClient.getDatabase(DATABASE);
		//or
		DB db = mongoClient.getDB(DATABASE);
		//MongoCollection<Document> coll = db.getCollection(COLLECTION);
		//or		
		DBCollection collection = (DBCollection) db.getCollection(COLLECTION);

		DBCursor cur = collection.find();
		int id = Integer.parseInt((cur.next().get("_id").toString()));
		//String fname = (cur.getQuery().toString());
		//System.out.println(fname);
		//System.out.println("_id"+id);
		cur = collection.find();
		while(cur.hasNext()) 
		{
			DBObject dbo = cur.next();
			Person per = new Person(
					Integer.parseInt((dbo.get("_id").toString())),
					dbo.get("fname").toString(),
					dbo.get("lname").toString(), 
					Integer.parseInt(dbo.get("age").toString()));
			p.add(per);
			//System.out.println("person "+per);
		}	
		mongoClient.close();
		return p;
	}

	@Override
	public void update(Person p) 
	{
		MongoClient mongoClient = null;
		try 
		{
			mongoClient = new MongoClient(SERVER, PORT);
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		}
		DB db = mongoClient.getDB(DATABASE);
		DBCollection collection = (DBCollection) db.getCollection(COLLECTION);
		BasicDBObject newdb = new BasicDBObject();
		newdb.put("fname", p.fname);
		newdb.put("lname", p.lname);
		newdb.put("age", p.age);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("_id", p.id);
		collection.update(searchQuery,newdb);
	}

	@Override
	public void delete(Person p) 
	{
		MongoClient mongoClient = null;
		try 
		{
			mongoClient = new MongoClient(SERVER, PORT);
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		}
		DB db = mongoClient.getDB(DATABASE);
		DBCollection collection = (DBCollection) db.getCollection(COLLECTION);
		BasicDBObject query = new BasicDBObject();
		query.put("_id", p.id);
		collection.find();
		collection.remove(query);
		/*DBCursor cur = collection.find();
		while(cur.hasNext()) 
		{
			System.out.println("del"+cur.next());
		}*/
	}
}
