package person.view;

import java.sql.SQLException;

//import com.mongodb.*;

public class XMain 
{

	public static void main(String[] args)
	{
		try 
		{
			new XFrame();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}