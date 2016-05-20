package bstree;

public class BMain 
{
	public static void main(String[] args)
	{
		//int[] ar = {2,1,3};
		//int[] ar = {50,25,33,70,11,28,60,100};
		//int[] ar = {8,3,10,1,6,14,4,7,13,2,9,5};
		//int[] ar = {5,4,9,3,8,15,1,6,10,18,25,26,7};
		
		int[] ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};

		BsTree tree = new BsTree(ar);

		System.out.print("Исходник:       ");
		for (int i=0; i<tree.size(); i++)
		{
			System.out.print(ar[i] + ", ");
		}
		
		System.out.println();
		//new XFrame();
		
		
		System.out.println(tree.minVal());
		System.out.println();
		tree.delete1(28);
		System.out.println();
		tree.print();
		
		
		
		
	}

}
