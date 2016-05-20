package arc;

import hw06.AList1;

public class AList1Test2 
{
	public static void main(String[] args) 
	{
		int[] ar = {10,15,20,25};

		AList1 rr = new AList1(ar);
		rr.print();
		System.out.println(rr.size());
		
		/*rr.delStart();
		rr.print();
		rr.addPos(1,4);
		rr.print();
				
		
		
		System.out.println(rr.delStart());
		rr.print();
		System.out.println(rr.delEnd());
		rr.print();*/
		System.out.println(rr.delPos(1));
		rr.print();
		System.out.println(rr.delPos(2));
		rr.print();
		/*rr.set(1, 18);
		rr.print();
		System.out.println(rr.get(1));
		System.out.println(rr.min());
		System.out.println(rr.minI());
		System.out.println(rr.max());
		System.out.println(rr.maxI());
		rr.sort();
		rr.print();
		rr.reverseHalf();
		rr.print();
		rr.reverse();
		rr.print();
		System.out.println(rr.delEnd());
		rr.print();
		System.out.println(rr.delEnd());
		rr.print();
		System.out.println(rr.toString());
		rr.print();*/
		
	}

}
