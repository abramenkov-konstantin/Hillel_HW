package mongo;

import java.net.UnknownHostException;
import java.util.Properties;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class WorkWithMongo 
{
	// ��� ������ ������� ��������� ����������� � ��
	private MongoClient mongoClient;
	 
	// � ����� ������, ���� ����� ���� 
	// ����������� ������������������� � MongoDB
	private DB db;
	 
	// ��� �� ����� ������� ��������� ����������� � ��
	private boolean authenticate;
	 
	// � ����� ������� ��������� ����������� �������� 
	// � ����������� / ��������� MongoDB
	private DBCollection table;
	 
	public WorkWithMongo(Properties prop) {
	    try {
	        // ������� �����������
	        mongoClient = new MongoClient( prop.getProperty("host"), Integer.valueOf(prop.getProperty("port")) );
	 
	        // �������� �� ��� ���������� ������
	        db = mongoClient.getDB(prop.getProperty("dbname"));
	 
	        // ������ ��� ��������� ������� � �������
	        authenticate = db.authenticate(prop.getProperty("login"), prop.getProperty("password").toCharArray());
	 
	        // �������� ���������/������� ��� ���������� ������
	        table = db.getCollection(prop.getProperty("table"));
	    } catch (UnknownHostException e) {
	        // ���� �������� �������� ��� ����������� �������� �� ����
	        System.err.println("Don't connect!");
	    }
	}
	
	public void add(User user){
	    BasicDBObject document = new BasicDBObject();
	 
	    // ��������� ���� � ������� User
	    // ��� ���� ����� ������������ � ���������/�������
	    document.put("login", user.getLogin());
	 
	    // ���������� ������ � ���������/�������
	    table.insert(document);
	}
	
	public User getByLogin(String login){
	    BasicDBObject query = new BasicDBObject();
	     
	    // ������ ���� � �������� ���� �� �������� ����� ������
	    query.put("login", login);
	 
	    // ������������ �����
	    DBObject result = table.findOne(query);
	    
	    // ��������� �������� ����������� ������� � ���������
	    User user = new User();
	    user.setLogin(String.valueOf(result.get("login")));
	    user.setId(String.valueOf(result.get("_id")));
	  
	    // ���������� ����������� ������������
	    return user;
	}
	
	// login - ��� ������ ����� ������������
	// newLogin - ��� ����� ����� ������� �� ����� ������
	public void updateByLogin(String login, String newLogin){
	    BasicDBObject newData = new BasicDBObject();
	 
	    // ������ ����� �����
	    newData.put("login", newLogin);
	 
	    // ��������� ����������� ���� � ������� ��� ��������
	    BasicDBObject searchQuery = new BasicDBObject().append("login", login);
	 
	    // ��������� ������
	    table.update(searchQuery, newData);
	}
	
	public void deleteByLogin(String login){
	    BasicDBObject query = new BasicDBObject();
	 
	    // ��������� ����� ������ ����� ������� � ��������� 
	    // ����� ���� � ��� ������� ��������
	    query.put("login", login);
	 
	    // ������� ������ � ���������/�������
	    table.remove(query);
	}
}
