import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;

public class BsTree 
{
	class Node
	{
		int value;
		Node left  = null;
		Node right = null;
		public Node(int value) 
		{
			this.value = value;
		}
	}

	Node root = null;
	
	public BsTree() 
	{
	}
	
	public BsTree(int[] a) 
	{
		init(a);
	}
	
	public void init(int[] a)
	{
		if(a == null)
			a = new int[0];
		for (int i = 0; i < a.length; i++) 
		{
			add(a[i]);
		}
	}
	
	public void add(int value)
	{
		if(root == null)
			root = new Node(value);
		else
			add(root, value);
	}
	
	private void add(Node a, int value) 
	{
		if(value < a.value)
		{
			if(a.left == null)
				a.left = new Node(value);
			else
				add(a.left, value);
		}
		else
		{
			if(a.right == null)
				a.right = new Node(value);
			else
				add(a.right, value);
		}
	}
	
	public void print() 
	{
		print(root);
	}
	
	private void print(Node a) 
	{
		if(a == null)
			return;
		print(a.left);
		System.out.print( a.value + " ");
		print(a.right);
	}
	
	public int size()
	{
		return sizeNode(root);
	}
	
	private int sizeNode(Node a)
	{
		if(a == null)
			return 0;
		
		int count = 0;
		count += sizeNode(a.left); 
		count ++; 
		count += sizeNode(a.right);
		
		return count;
	}

	private int sizeNode1(Node a)
	{
		if(a == null)
			return 0;
		
		return 1 + sizeNode(a.left) + sizeNode(a.right);
	}

	
	public int nodes()
	{
		return nodes(root);
	}
	
	private int nodes(Node a)
	{
		if(a == null)
			return 0;
		
		int count = 0;
		count += nodes(a.left);
		if(a.left != null || a.right != null)
		{
			count++;
		}
		count += nodes(a.right);
		return count;
	}
	
	public int leafs()
	{
		return leafs(root);
	}
	
	private int leafs(Node a)
	{
		if(a == null)
			return 0;
		
		int count = 0;
		count += leafs(a.left);
		if(a.left == null && a.right == null)
		{
			count++;
		}
		count += leafs(a.right);
		return count;
	}
	
	public int height()
	{
		return height(root);
	}
	
	private int height(Node a) 
	{
        if(a == null) 
        	return 0;
        
        int leftHeight = height(a.left);
        int rightHeight = height(a.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
	
	public int width()
	{
		int[] ar = new int[height()];
		width(root, ar, 0);
		return maxElem(ar);
	}
	private void width(Node a, int[] ar, int level) 
	{
        if(a == null) 
        	return;
        
        width(a.left, ar, level + 1); 
		ar[level]++;
		width(a.right, ar, level + 1 );
    }
	
	private int maxElem(int[] ar)
	{
		if (ar.length == 0) 
		{
			throw new IllegalArgumentException();
		}
		
		int max=ar[0];
		for (int i = 1; i < ar.length; i++)
		{
			if (max<ar[i])
			{
				max = ar[i];
			}
		}
		return max;	
	}

	class Iter
	{
		int i = 0;
	}
	
	public int[] toArray()
	{
		int[] arr = new int[size()];		
		toArray(root, arr, new Iter());
		return arr;
	}
	
	public void toArray(Node a, int[] ar, Iter ii)
	{
		if(a == null)
			return;
		
		toArray(a.left, ar, ii);
		ar[ii.i++] = a.value;
		toArray(a.right, ar, ii);
	}
	
	
	
	
	
	//===========================
		// delete
		//===========================
		public int delete(int val) 
		{
			//Node tmp = deleteNode(val);

			//Node refToDel = findRef(val);
			//Node refParent = findParentRef(val);
			System.out.println("!!!");
			/*System.out.println("val" + val);
			System.out.println("refToDel" + refToDel);
			System.out.println("refToDel.val" + refToDel.val);
			System.out.println("refParent.val" + refParent.val);*/
			return 12; 
		}

		/*private Node deleteNode(int val)
		{
			Node refToDel = findRef(val);
			Node refParent = findParentRef(val);

			if (refToDel==null)              //если нет такого элемента
			{
				System.out.println("null");
			}

			//----------------------
			if (refToDel.left==null && refToDel.right==null)     //1 если у удаляемого элемента нет детей
			{
				if (refParent.left==refToDel)  refParent.left=null;  //если удаляемый элемент - левый потомок родителя
				else 		 	               refParent.right=null; //если удаляемый элемент - правый потомок родителя
			}

			//----------------------
			else if (refToDel.left!=null || refToDel.right!=null) //2 если у удаляемого элемента 1 наследник
			{
				if (refParent.left==refToDel)                       //если удаляемый элемент - левый потомок родителя
				{
					if (refToDel.left!=null) refParent.left=refToDel.left; //а)
					else refParent.left=refToDel.right;					   //б)
				}
				else //if (refParent.right==refToDel)               //если удаляемый элемент - правый потомок родителя
				{
					if (refToDel.left!=null) refParent.right=refToDel.left;//в)
					else refParent.right=refToDel.right;   				   //г)
				}
			}*/

		/*//----------------------
			else if (refToDel.left!=null && refToDel.right!=null)                         //если у удаляемого элемента 2 наследника
			{
				Node refMinInRightSubtree = findMin(refToDel.right);

				if (refParent.left==refToDel)  //refParent.left=null;  //если удаляемый элемент - левый потомок родителя
				{
					if(refToDel.left!=refMinInRightSubtree)
					{
						refParent.left = refMinInRightSubtree;      //если минимальный элемент в правом поддереве
						refMinInRightSubtree.left=refToDel.left;    // не следует сразу за удаляемым
						refMinInRightSubtree.right=refToDel.right;
					}
					else
					{
						refParent.left = refMinInRightSubtree;          //если минимальный элемент в правом поддереве
						refMinInRightSubtree.left=refToDel.left;		//следует сразу за удаляемым
						refMinInRightSubtree.right=refToDel.right.right;
					}
				}
				else 		 	               //refParent.right=null; //если удаляемый элемент - правый потомок родителя
				{
					if(refToDel.right!=refMinInRightSubtree)
					{
						refParent.right = refMinInRightSubtree;      //если минимальный элемент в правом поддереве
						refMinInRightSubtree.left=refToDel.left;    // не следует сразу за удаляемым
						refMinInRightSubtree.right=refToDel.right;
					}
					else
					{
						refParent.right = refMinInRightSubtree;          //если минимальный элемент в правом поддереве
						refMinInRightSubtree.left=refToDel.left;		//следует сразу за удаляемым
						refMinInRightSubtree.right=refToDel.right.right;
					}
				}
			}

			return refToDel;
		}*/

		public void show (Graphics g,int width)
		{
			showNode (root, (Graphics2D)g, 0, width, 1, 50);
		}
	
		private void showNode(Node p, Graphics2D gg, int left, int right, int level, int step)
		{
		if (p==null)
			return;
		
		int x =  (left + right)/2;
		int y =  level * step;
		gg.drawOval (x, y, 30, 30);
		gg.drawString(" "+ p.value,  x, y);
		
		showNode(p.left, gg,left,level+1, step);
		showNode(p.right, gg,left,level+1, step);
		
		}
		
	
}
