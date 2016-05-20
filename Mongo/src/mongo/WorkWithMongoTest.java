package mongo;

import static org.junit.Assert.*;

import org.junit.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
import java.util.Properties;
 
public class WorkWithMongoTest {
 
    WorkWithMongo mongo;
 
    @BeforeMethod
    public void setUp() throws Exception {
        Properties prop = new Properties();
        prop.setProperty("host", "localhost");
        prop.setProperty("port", "27017");
        prop.setProperty("dbname", "admin");
        prop.setProperty("login", "root");
        prop.setProperty("password", "root");
        prop.setProperty("table", "users");
 
        mongo = new WorkWithMongo(prop);
    }
 
    @AfterMethod
    public void tearDown() throws Exception {
        mongo.close();
    }
 
    @Test
    public void testConnection() throws Exception {
        boolean authenticate = mongo.isAuthenticate();
        Assert.assertEquals(true, authenticate);
    }
 
    @Test
    public void testAddUser() throws Exception {
        mongo.add(new User("test"));
    }
 
    @Test
    public void testGet() throws Exception {
        User user = mongo.getByLogin("test");
        System.out.println(user);
    }
 
    @Test
    public void testDelete() throws Exception {
        mongo.deleteByLogin("test");
    }
 
    @Test
    public void testUpdate() throws Exception {
        mongo.updateByLogin("test", "DevColibri");
    }
 
}