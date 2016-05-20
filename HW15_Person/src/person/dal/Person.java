package person.dal;

public class Person 
{
	public int    id;
	public String fname;
	public String lname;
	public int    age;

	public Person()
	{
	}

	public Person(int id, String name, String lname, int age) 
	{
		this.id    = id;
		this.fname = name;
		this.lname = lname;
		this.age   = age;
	}

	@Override
	public String toString() 
	{
		return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + ", age=" + age + "]";
	}	

	public String toJSON() 
	{
		return "Person {id:" + id + ", fname:" + fname + ", lname:" + lname + ", age:" + age + "}";
	}

	public String toXML() 
	{
		return "Person {id:" + id + ", fname:" + fname + ", lname:" + lname + ", age:" + age + "}";
	}

}
