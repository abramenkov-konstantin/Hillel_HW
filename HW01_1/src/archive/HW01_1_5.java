package archive;

public class HW01_1_5 
{
	// 01 условные операторы
	// определение оценки студента по его рейтингу

	public static void main(String[] args) 
	{
        int rating=-1;
        char res='N';
        
        res = rate (rating);
        		
    	System.out.println("–ейтинг студента =" + rating);
		System.out.print("ќценка студента:" + res);
	}
	
    public static char rate (int rating)
    {
    	if (rating>=0&rating<=19)
		{	
			return 'F';
		}
		if(rating>=20&rating<=39)
		{
			return 'E';
		} 
		if(rating>=40&rating<=59)
		{
			return 'D';
		}
		if(rating>=60&rating<=74)
		{
			return 'C';
		}
		if(rating>=75&rating<=89)
		{
			return 'B';
		}
		if(rating>=90&rating<=100)
		{
			return 'A';
		}
		return '0';
    }
}
