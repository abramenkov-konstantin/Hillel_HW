package arc;

import hw06.AList2;

public class AList2Test 
{
	public static void main(String[] args) 
	{
		int[] ar = {9,73,43,2,5,65};
		AList2 rr = new AList2(ar);
		rr.print();
		
		rr.addPos(1, 1);
		rr.print();		

	}
}
