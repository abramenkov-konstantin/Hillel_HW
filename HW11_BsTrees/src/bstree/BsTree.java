package bstree;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class BsTree 
{
	public class Node
	{
		int val;
		Node left;
		Node right;

		public Node(int val)
		{
			this.val = val;
		}
	}

	Node root = null;

	public BsTree() 
	{
	}
	public BsTree(int[] ini) 
	{
		init(ini);
	}

	public void init(int[] ini)
	{
		for (int i = 0; i < ini.length; i++) 
		{
			add(ini[i]);
		}
	}

	//===========================
	// add
	//===========================
	public void add(int val)
	{
		if(root == null)
		{
			root = new Node(val);
		}
		else
		{
			addNode(root, val);
		}
	}
	private void addNode(Node p, int val) 
	{
		if(val < p.val)
		{
			if(p.left == null)
				p.left = new Node(val);
			else
				addNode(p.left, val);
		}
		else
		{
			if(p.right == null)
				p.right = new Node(val);
			else
				addNode(p.right, val);
		}
	}

	//===========================
	// print
	//===========================
	public void print() 
	{
		printNode(root);
	}

	private void printNode(Node p) 
	{
		if(p == null)
			return;

		printNode(p.left);                 // L   {inorderTraversal} Ч обход узлов в отсортированном пор€дке,
		System.out.print( p.val + ", ");   // V
		printNode(p.right);                // R 
	}

	//===========================
	// size
	//===========================
	public int size()
	{
		return sizeNode(root);
	}
	private int sizeNode(Node p)
	{
		if(p == null)
			return 0;

		return  sizeNode(p.left) + 1 + sizeNode(p.right);
	}

	//===========================
	// nodes
	//===========================
	public int nodes()
	{
		return nodes(root);
	}

	private int nodes(Node p)
	{
		if(p == null)
			return 0;

		int count = 0;
		count += nodes(p.left);
		if(p.left != null || p.right != null)
		{
			count++;
		}
		count += nodes(p.right);
		return count;
	}

	//===========================
	// leaves
	//===========================
	public int leaves()
	{
		return leavesNode(root);
	}

	private int leavesNode(Node p)
	{
		if(p == null)
			return 0;

		int count = 0;
		count += leavesNode(p.left);
		if(p.left == null && p.right == null)
		{
			count++;
		}
		count += leavesNode(p.right);
		return count;
	}

	//===========================
	// height
	//===========================
	public int height()
	{
		return heightNode(root);
	}

	private int heightNode(Node p) 
	{
		if(p == null) 
			return 0;

		return 1 + Math.max(heightNode(p.left), heightNode(p.right));
	}

	//===========================
	// width
	//===========================
	public int width()
	{
		if (height()==0) return 0;

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

	//===========================
	// maxElem
	//===========================
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

	//===========================
	// toArray
	//===========================
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
		ar[ii.i++] = a.val;
		toArray(a.right, ar, ii);
	}

	//===========================
	// findVal, findRef
	//===========================
	public int findVal(int val) 
	{
		return findNode(root, val).val;
	}
	public Node findRef(int val) 
	{
		return findNode(root, val);
	}
	private Node findNode(Node p, int val) 
	{
		if (p == null)
			return null;
		if (p.val == val)
			return p;
		if (val < p.val)
		{
			p = findNode(p.left, val); 
		}
		else
		{	
			p = findNode(p.right, val);
		}
		return p;
	}

	//===========================
	// findParentVal, findParentRef
	//===========================
	public int findParentVal(int val) 
	{
		return findParentNode(root, val).val;
	}
	public Node findParentRef(int val) 
	{
		return findParentNode(root, val);
	}
	private Node findParentNode(Node p, int val) 
	{
		if (p == null || findRef(val)==null)  
			return null;

		if (p.left != null && p.left.val == val)
		{
			return p;	
		}
		else if (p.right != null && p.right.val == val)
		{
			return p;	
		}
		else
		{
			if (val < p.val)
			{
				p= findParentNode(p.left, val); 
			}
			else
			{	
				p= findParentNode(p.right, val);
			}
			return p;
		}
	}

	//===========================
	// minVal, minRef
	//===========================
	public int minVal() 
	{
		return findMin(root).val;
	}
	public Node minRef() 
	{
		return findMin(root);
	}
	private Node findMin(Node p) 
	{
		Node min = p;
		if (min == null) return null;

		while (min.left != null) 
		{
			min = findMin (min.left);
		}
		return min;     
	}

	//===========================
	// maxVal, maxRef
	//===========================
	public int maxVal() 
	{
		return findMax(root).val;
	}
	public Node maxRef() 
	{
		return findMax(root);
	}
	private Node findMax(Node p) 
	{
		Node max = p;
		if (max == null) return null;
		while (max.right != null) 
		{
			max = findMax (max.right);
		}
		return max;     
	}

	//===========================
	// show
	//===========================
	public void show (Graphics g,int width)
	{
		showNode (root, (Graphics2D)g, 0, width, 1, 70, 0);
	}

	private void showNode(Node p, Graphics2D gg, int left, int right, int level, int step, int direct)
	{
		if (p==null)
			return;

		int x =  (left + right)/2;
		int y =  level * step;
		int parent = (direct==-1) ? right : (direct==1) ? left:x;
		//gg.drawLine (x+15, y, parent+15, y-step+30);
		gg.drawLine (x+15, y-step+40, parent+15, y-step+40);
		gg.drawLine (x+15, y, x+15, y-step+40);
		gg.drawLine (x+15, y+30, x+15, y+40);
		gg.drawOval (x, y, 30, 30);
		gg.drawString(" "+ p.val,  x+5, y+20);

		showNode(p.left, gg, left, x, level+1,  step, -1);
		showNode(p.right, gg, x, right, level+1, step, 1);

	}

	//===========================
	// delete1 insertion
	//===========================
	public int delete1(int val)
	{
		Node refToDel = findRef(val);
		Node refParent = findParentRef(val);

		if (refToDel==null)
			throw new IllegalArgumentException();

		if (refToDel==root)
		{
			if (refToDel.left==null && refToDel.right==null)     
			{
				root=null;
			}
			else if ((refToDel.left!=null && refToDel.right==null) || (refToDel.left==null && refToDel.right!=null) )
			{
				if (refToDel.left!=null) root=refToDel.left;
				else root=refToDel.right;									
			}
			else if (refToDel.left!=null && refToDel.right!=null)
			{
				Node refMinInRightSubtree = findMin(refToDel.right);
				if(refToDel.right!=refMinInRightSubtree)
				{
					Node refMinInRightSubtreeParent = findParentRef(refMinInRightSubtree.val);
					root = refMinInRightSubtree;
					refMinInRightSubtree.left=refToDel.left;    
					refMinInRightSubtreeParent.left = refMinInRightSubtree.right;
					refMinInRightSubtree.right=refToDel.right;
				}
				else
				{
					root = refMinInRightSubtree;
					refMinInRightSubtree.left=refToDel.left;		
					refMinInRightSubtree.right=refToDel.right.right;
				}
			}
		}
		else if (refToDel.left==null && refToDel.right==null)     
		{
			if (refParent.left==refToDel)  refParent.left=null;  
			else 		 	               refParent.right=null; 
		}

		else if ((refToDel.left!=null && refToDel.right==null) || (refToDel.left==null && refToDel.right!=null) )
		{
			if (refParent.left==refToDel)       
			{
				if (refToDel.left!=null) refParent.left=refToDel.left; 
				else refParent.left=refToDel.right;					   
			}
			else 
			{
				if (refToDel.left!=null) refParent.right=refToDel.left;
				else refParent.right=refToDel.right;   				   
			}
		}

		else if (refToDel.left!=null && refToDel.right!=null)
		{
			Node refMinInRightSubtree = findMin(refToDel.right);
			if(refToDel.right!=refMinInRightSubtree)
			{
				Node refMinInRightSubtreeParent = findParentRef(refMinInRightSubtree.val);
				if (refParent.left==refToDel) 	refParent.left = refMinInRightSubtree;
				else 							refParent.right = refMinInRightSubtree;
				refMinInRightSubtree.left=refToDel.left;    
				refMinInRightSubtreeParent.left = refMinInRightSubtree.right;
				refMinInRightSubtree.right=refToDel.right;
			}
			else
			{
				if (refParent.left==refToDel)  refParent.left = refMinInRightSubtree;
				else						   refParent.right = refMinInRightSubtree;
				refMinInRightSubtree.left=refToDel.left;		
				refMinInRightSubtree.right=refToDel.right.right;
			}
		}
		return refToDel.val;
	}	

	//===========================
	// delete2 rotation
	//===========================
	public int delete2(int val)
	{
		Node refToDel = findRef(val);
		Node refParent = findParentRef(val);

		if (refToDel==null)
			throw new IllegalArgumentException();

		if (refToDel==root)
		{
			if (refToDel.left==null && refToDel.right==null)     
			{
				root=null;
			}
			else if ((refToDel.left!=null && refToDel.right==null) || (refToDel.left==null && refToDel.right!=null) )
			{
				if (refToDel.left!=null) root=refToDel.left;
				else root=refToDel.right;									
			}
			else if (refToDel.left!=null && refToDel.right!=null)
			{
				Node refMinInRightSubtree = findMin(refToDel.right);
				root = refToDel.right;
				refMinInRightSubtree.left = refToDel.left; 
			}
		}

		else if (refToDel.left==null && refToDel.right==null)     
		{
			if (refParent.left==refToDel)  refParent.left=null; 
			else 		 	               refParent.right=null; 
		}

		else if ((refToDel.left!=null && refToDel.right==null) || (refToDel.left==null && refToDel.right!=null) )
		{
			if (refParent.left==refToDel) 
			{
				if (refToDel.left!=null) refParent.left=refToDel.left; 
				else refParent.left=refToDel.right;					   
			}
			else
			{
				if (refToDel.left!=null) refParent.right=refToDel.left;
				else refParent.right=refToDel.right;   				   
			}
		}

		else if (refToDel.left!=null && refToDel.right!=null)
		{
			Node refMinInRightSubtree = findMin(refToDel.right);

			if (refParent.left==refToDel) 
			{
				refParent.left = refToDel.right;
				refMinInRightSubtree.left = refToDel.left;
			}
			else
			{
				refParent.right = refToDel.right;
				refMinInRightSubtree.left = refToDel.left;
			}
		}
		return refToDel.val;
	}	
}
