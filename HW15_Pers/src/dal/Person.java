package dal;

public class Person 
{
	public int    id;
	public String fname;
	public String lname;
	public int    age;

	public Person(int id, String fname, String lname, int age) 
	{
		this.id    = id;
		this.fname = fname;
		this.lname = lname;
		this.age   = age;
	}

	@Override
	public String toString() 
	{
		return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + ", age=" + age + "]";
	}
	
	public String toXML()
	{
		String str = "<Person>\n";
		str += "\t<id>" + id + "</id>\n";
		str += "\t<fname>" + fname + "</fname>\n";
		str += "\t<lname>" + lname + "</lname>\n";
		str += "\t<age>" + age + "</age>\n";
		str += "</Person>";
		return str;		
	}
	public String toJSON()
	{
		return "(id:" + id + ", fname:" + fname + ", lname:" + lname + ", age:" + age + ")";	
	}
	public String toCSV()
	{
		return id + ", " + fname + ", "  + lname + ", " + id;
		
	}
}