package archive;
//import java.util.*;
//import javax.swing.JOptionPane;

public class HW01_1_3 
{
	// 01 условные операторы
	// 03 найти сумму только положительных из 3-х чисел
	
	public static void main(String[] args) 
	{
		int num1=8, num2=-3, num3=6, summ=0;
	    
	    summ = summ3 (num1, num2, num3);
	    
	    System.out.println("Сумма положительных чисел составляет:" + summ);
	    
	}
	
	public static int summ3 (int n1, int n2, int n3)
	{
	   	int res=0;
    	if (n1>0)
    	{
    		res=res+n1;
    	}
    	if (n2>0)
    	{
    		res=res+n2;
    	}
    	if (n3>0)
    	{
    		res=res+n3;
    	}
    	return res;
	}
}
	
	
	
	/*JOptionPane.showMessageDialog(null, "Привет! Сейчас мы будем вводить числа.");
	String[] numbers = new String[3];

	numbers[0]=JOptionPane.showInputDialog("Введите первое число");
    numbers[1]=JOptionPane.showInputDialog("Введите второе число");
    numbers[2]=JOptionPane.showInputDialog("Введите третье число");
    int x=0;
    for(String ystring:numbers) 
    {
    	int yint = Integer.parseInt(ystring);
    	if (yint > 0)
    	{ 
    	x = x + yint;
        }
    	continue;
    }
    JOptionPane.showMessageDialog(null, "Сумма положительных чисел равна,\n"+x);
    */
	
