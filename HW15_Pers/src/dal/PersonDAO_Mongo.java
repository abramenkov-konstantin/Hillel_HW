package dal;
import java.util.ArrayList;
import org.bson.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class PersonDAO_Mongo implements PersonDAO 
{

	@SuppressWarnings("resource")
	@Override
	public void create(Person p) 
	{
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("test");
		  db.getCollection("person").insertOne(new Document()
				.append("_id", p.id).append("fname", p.fname)
		        .append("lname",p.lname).append("age", p.age));
	}
	
	@SuppressWarnings("resource")
	@Override
	public ArrayList<Person> read() 
	{
		ArrayList<Person> rr = new ArrayList<Person>();
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("test");
		FindIterable<Document> iterable = db.getCollection("person").find();
		iterable.forEach(new Block<Document>() 
		{
		    @Override
		    public void apply(final Document document) 
		    {
		        Person p = new Person(
		        		Integer.parseInt((document.get("_id").toString())),
		    			document.get("fname").toString(),
		    			document.get("lname").toString(), 
		    			Integer.parseInt(document.get("age").toString()));		        
		        rr.add(p);
		    }
		});	
		return rr;
	}

	@SuppressWarnings("resource")
	@Override
	public void update(Person p) 
	{
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = db.getCollection("person");
		BasicDBObject dbObject =new BasicDBObject();
		dbObject.put("fname", p.fname);
		dbObject.put("lname", p.lname);
		dbObject.put("age", p.age);
		BasicDBObject dbObjectId = new BasicDBObject();
		dbObjectId.put("_id", p.id);
		collection.findOneAndUpdate(dbObjectId,dbObject);
	}

	@SuppressWarnings("resource")
	@Override
	public void delete(Person p) 
	{	
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = db.getCollection("person");
		BasicDBObject dbObject = new BasicDBObject();
		dbObject.put("_id", p.id);
		collection.findOneAndDelete(dbObject);
		
	}

}
