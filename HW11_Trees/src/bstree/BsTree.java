package bstree;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import arc.BsTree.Node;

public class BsTree 
{
	public class Node
	{
		int val;
		Node left;
		Node right;

		public Node(int val) //public void setVal(int val)
		{
			this.val = val;
		}
		/*public int getVal() 
		{return this.val;}
		public Node getLeft() 
		{return this.left;}
		public void setLeft(Node left) 
		{this.left = left;}
		public Node getRight() 
		{return this.right;	}
		public void setRight(Node right) 
		{this.right = right;}*/
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
		
		int count = 0;
		count += sizeNode(p.left); 
		count ++; 
		count += sizeNode(p.right);
		
		return count;
	}
	

	//===========================
	// nodes
	//===========================
	public int nodes() 
	{	
		return nodesNode(root, 0);
	}
	private int nodesNode(Node p, int nodes) 
	{
		if (p != null)
		{
			nodes = nodesNode(p.left, nodes); 
			nodes = nodesNode(p.right,nodes);

			if (p.left!=null || p.right!=null)
			{
				nodes++;
			}
		}
		return nodes;
	}

	//===========================
	// leaves
	//===========================
	public int leaves() 
	{	
		return leavesNode(root, 0);
	}
	private int leavesNode(Node p, int leaves) 
	{
		if (p != null)
		{
			leaves = leavesNode(p.left, leaves); 
			leaves = leavesNode(p.right,leaves);

			if (p.left==null && p.right==null)
			{	
				leaves++;
			}
		}
		return leaves;
	}

	//===========================
	// height
	//===========================
	public int height() 
	{
		return heightNode(root, 0);
	}
	private int heightNode(Node p, int height)
	{
		if(p!= null)
		{
			height = Math.max(heightNode(p.left, height),heightNode(p.right, height))+1;
		}
		return height;
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
	// width
	//===========================
	public int width()
	{
		int[] ar1 = new int[size()];
		width(root,ar1,0);
		int max = 0;
		for (int a : ar1)
			max = max < a? a : max;

		return max;
	}
	private int width(Node p,int[]ar1,int step)
	{
		int max = 0;
		if ( p!=null )
		{ 
			ar1[step] = ar1[step] + 1;
			width(p.left,ar1,step + 1);
			width(p.right,ar1,step + 1); 
		}
		return max;
	}

	//===========================
	// toArray
	//===========================
	public int[] toArray()
	{
		ArrayList<Integer> result = new ArrayList<>();
		int ar[] = new int[size()];
		int i = 0;
		toArray(root, result);
		for (int a : result)
		{
			ar[i++] = a;
		}
		return ar;
	}

	private void toArray(Node p, ArrayList<Integer> result) 
	{
		if (p == null) 
			return;

		toArray(p.left, result); 
		result.add(p.val); 
		toArray(p.right, result); 
	}

	/* , обход дерева в ширину (итерационно, используетс€ очередь)
	 * 
    private ArrayList<Integer> toArray(Node p, ArrayList<Integer> result) 
	{
		Queue<Node> queue=new LinkedList<> ();
		do{
			result.add(p.val);
			if (p.left!=null) queue.add(p.left);
			if (p.right!=null) queue.add(p.right);
			if (!queue.isEmpty()) p=queue.poll();
		}while (!queue.isEmpty());
		return result;		
	}*/


	
	//===========================
	// reverse
	//===========================

	public void reverse() 
	{	
		reverseNode (root);
	}
	private void reverseNode( Node p) 
	{
		Node temp = new Node(0);
		if(p!=null)
		{
			if(p.left!=null  &&  p.right!=null)
			{
				temp = p.left;
				p.left = p.right;
				p.right = temp;
				reverseNode(p.left);
				reverseNode(p.right);
			}
			else if (p.left!=null  &&  p.right==null)
			{
				reverseNode(p.left);
			}
			else if (p.left==null  &&  p.right!=null)
			{
				reverseNode(p.right);
			}
		}
	}
}
