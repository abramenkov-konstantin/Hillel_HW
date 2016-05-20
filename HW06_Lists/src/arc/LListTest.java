package arc;

import hw06.LList1;

public class LListTest 
{
	public static void main(String[] args) 
	{
		int[] ar = {60,20,150,40,50,56};

		LList1 rr = new LList1(ar);
		rr.print();


		//System.out.println(rr.toString());
		//rr.swap (1,3);
		//rr.print();
		rr.sort();
		rr.print();
		
		
		/*rr.set (0,10);
		rr.print();
		rr.set (1,20);
		rr.print();*/
		/*System.out.println(rr.get(0));
		System.out.println(rr.get(1));*/
		//System.out.println(rr.get(2));
		//System.out.println(rr.get(3));
		/*System.out.println(rr.minElem());
		System.out.println(rr.maxElem());
		System.out.println(rr.minInd());
		System.out.println(rr.maxInd());*/
		
		/*rr.addStart (2);
		rr.addEnd (32);
		rr.print();
		System.out.println(rr.size());
		rr.addPos (3,1);
		rr.print();
		System.out.println(rr.size());*/
		/*rr.addPos (0,1);
		rr.print();
		rr.addPos (1,2);
		rr.print();*/
		

		/*rr.delStart();
		rr.print();
		rr.addPos(1,4);
		rr.print();



		System.out.println(rr.delStart());
		rr.print();
		System.out.println(rr.delEnd());
		rr.print();*/
		/*System.out.println(rr.delPos(1));
		rr.print();
		System.out.println(rr.delPos(2));
		rr.print();
		rr.set(1, 18);*/

	}
	}