package archive;

//import javax.swing.JOptionPane;

public class HW01_1_1 
{
	// 01 условные операторы
	// 01 Если а - четное посчитать а*б, иначе а+б
	
	public static void main(String[] args) 
	{
		int a=3, b=3, res=0;
		//   int number=Integer.parseInt(JOptionPane.showInputDialog("Введите число:"));
		//   String text=number%2==0?"четное":"нечетное";
		//   JOptionPane.showMessageDialog(null,"Вы ввели "+text+" число!");
	
		res= func (a,b);
		
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("res=" + res);
	}	
		
	public static int func (int a, int b)
	{
		int res=0;
		if(a%2==0)
		{
			res = a*b;
		} 
		else
		{
			res=a+b;
		}
		return res;
	}
}




