
public class BMain 
{
	public static void main(String[] args)
	{
		int[] ar = {50, 25, 33, 70, 11, 28, 5, 15, 60, 100, 51, 2};
		BsTree tree = new BsTree(ar);
		ar = tree.toArray();
		for(int i = 0; i< ar.length; i++)
			System.out.print(ar[i] + " ");
//		tree.print();
//		System.out.println();
//		System.out.print(tree.size());
//		System.out.println();
//		System.out.print(tree.leafs());
//		System.out.println();
//		System.out.print(tree.nodes());
//		System.out.println();
//		System.out.print(tree.height());
//		System.out.println();
//		tree.toArray();
	}
}
