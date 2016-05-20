package hw06;

public class LList1 implements EList 
{

	class Node
	{
		int val;
		Node next;
		public Node(int val) 
		{
			this.val = val;
		}
	}

	Node root = null;

	public LList1()
	{
	}

	public LList1(int[] ini)
	{
		init(ini);
	}

	@Override
	public void init(int[] a)
	{
		if(a == null)
		{
			a = new int[0];
		}

		for(int i = a.length-1; i >= 0; i--)
		{
			addStart(a[i]);
		}
	}

	@Override
	public int size()
	{
		int ret = 0;
		Node p = root;
		while(p != null)
		{
			ret++;
			p = p.next;
		}
		return ret;
	}

	@Override
	public void clear()
	{
		root = null;
	}

	@Override
	public int[] toArray()
	{
		int[] ret = new int[size()];
		Node p = root;
		int i = 0;
		while(p != null)
		{
			ret[i++] = p.val;
			p = p.next;
		}
		return ret;
	}

	@Override
	public String toString()
	{
		String str="{";

		Node p=root;
		while (p!=null)
		{
			str += (p.next != null) ? p.val + ", " : p.val;
			p = p.next;
		}
		str+="}";
		return str;
	}

	@Override
	public void addStart(int val)
	{
		Node p = new Node(val);
		p.next = root;
		root = p;
	}

	@Override
	public void addEnd(int val) 
	{
		Node pLast = new Node(val);

		if(root==null) 
		{
			root = pLast;
		}
		else
		{ 
			Node p = root;
			while(p.next!=null) p=p.next;
			p.next = pLast;
		}
	}

	@Override
	public void addPos(int pos, int val) 
	{
		Node p = root;
		Node pPos = new Node(val);

		if (pos<0 || pos>size()) 
			throw new IllegalArgumentException();

		if(root==null || pos==0) 
		{
			addStart(val);
		}
		else
		{
			for (int i=1; i<=pos; i++)
			{
				if (i==pos)
				{
					pPos.next = p.next;
					p.next=pPos;
				}
				else
				{
					p = p.next;
				}
			}
		}
	}

	@Override
	public int delStart() 
	{
		if (root==null)
			throw new IllegalArgumentException();

		int deletedVal = root.val;
		if (root.next==null) 
		{
			root=null;
		}
		else
		{
			root=root.next;	
		}
		return deletedVal;
	}

	@Override
	public int delEnd() 
	{
		Node p = root;
		int deletedVal = 0;

		if (size()<=0)
			throw new IllegalArgumentException();

		if (root.next==null)
		{
			deletedVal = root.val;
			root=null;
		}
		else
		{
			while (p.next.next!=null)
			{
				p=p.next;
			}
			deletedVal = p.next.val;
			p.next=null;
		}
		return deletedVal;
	}

	@Override
	public int delPos(int pos) 
	{
		Node p = root;
		int deletedVal = 0;

		if (root==null || pos<0 || pos>size()-1) 
			throw new IllegalArgumentException();

		if(pos==0)  
		{
			deletedVal = root.val;
			root=p.next;
		}
		else if (root.next==null)
		{
			deletedVal = root.val;
			root=null;
		}
		else
		{
			for(int i=0; i<pos-1; i++)
			{
				p=p.next;
			}
			deletedVal = p.next.val;
			p.next=p.next.next;
		}
		return deletedVal;
	}


	@Override
	public void set(int pos, int val) 
	{
		Node p = root;

		if (pos<0 || pos>size()-1) 
			throw new IllegalArgumentException();

		for(int i=0; i<pos; i++)
		{
			p=p.next;
		}
		p.val=val;
	}

	@Override
	public int get(int pos) 
	{
		Node p = root;
		if (pos<0 || pos>size()-1) 
			throw new IllegalArgumentException();

		for(int i=0; i<pos; i++)
		{
			p=p.next;
		}
		return p.val;
	}

	@Override
	public int minElem() 
	{
		if (root==null)
			throw new NegativeArraySizeException();

		Node p = root;
		int min = root.val;

		for(int i=0; i<size(); i++)
		{
			min=min>p.val? p.val: min;
			p=p.next;
		}
		return min;
	}

	@Override
	public int maxElem() 
	{
		if (root==null)
			throw new NegativeArraySizeException();

		Node p = root;
		int max = root.val;

		for(int i=0; i<size(); i++)
		{
			max=max<p.val? p.val: max;
			p=p.next;
		}
		return max;
	}

	@Override
	public int minInd() 
	{
		if (root==null)
			throw new NegativeArraySizeException();

		Node p = root;
		int min = minElem(), minIndex=0;

		while (p.val>min)
		{
			minIndex++;
			p=p.next;
		}
		return minIndex;
	}

	@Override
	public int maxInd() 
	{
		if (root==null)
			throw new NegativeArraySizeException();

		Node p = root;
		int max = maxElem(), maxIndex=0;

		while (p.val<max)
		{
			maxIndex++;
			p=p.next;
		}
		return maxIndex;
	}

	@Override
	public void reverse()
	{
		if (root==null || root.next==null) // 0 or 1 element
			return;

		Node p;
		Node rootTmp;
		Node last;	
		if (root.next.next==null) // 2 elements
		{
			root.next.next=root;
			root=root.next;
			root.next.next=null;
		}
		else //more then 2 elements
		{
			p = root;
			while(p.next!=null) p=p.next;
			rootTmp = p;
			last = p; 

			while (root.next!=rootTmp)
			{
				p = root;
				while(p.next.next!=rootTmp) 
				{
					p=p.next;
				}
				last.next = p.next;
				last=last.next;
				last.next=null;
				p.next=rootTmp;
				p = root;
			}
			last.next=root;
			last=last.next;
			last.next=null;
			root=rootTmp;
		}
	}

	@Override
	public void reverseHalf() 
	{
		if (size()<0)
			throw new NegativeArraySizeException();

		if (root == null || root.next == null) //0 or 1 element
			return;

		Node p=root;
		Node root1=root;
		Node last1=null;
		Node middle=null;
		Node root2=null;
		Node last2=null;

		if (root.next.next==null) //2 elements
		{
			root.next.next=root;
			root=root.next;
			root.next.next=null;
		}
		else //more then 2 elements
		{
			p=root;
			int d = (size()%2==0) ? 0 : 1;
			for (int i=1; i<size()-1;i++)
			{
				if (i==size()/2) 
				{
					last1=p;
					middle = d==1 ? p.next : null;
					p =	d==1 ?	p.next : p;
					root2=p.next;					
				}
				p=p.next;
			}
			last2 =	d==1 ?	p : p.next;

			if (middle==null)
			{
				last2.next=root1;
				last1.next=null;
				root=root2;
			}
			else
			{
				last2.next=middle;
				middle.next=root1;
				last1.next=null;
				root=root2;
			}
		}
	}

	@Override
	public void sort() 
	{
		Node rootNew = null;
		Node minRef= null;
		Node pNew = rootNew;
		Node p = root;
		int min = 0;
		int size = size();

		for(int j=0; j<size; j++) //search of min element
		{
			minRef=root;
			p = root;
			min=minElem();
			while (p.val!=min) p=p.next;
			minRef=p;

			// sort by insertions
			if(minRef==root) // min element in the start
			{
				if (rootNew==null) 
				{
					rootNew=root; 
					root=root.next;
					rootNew.next=null;
				}
				else
				{
					pNew = rootNew;
					while (pNew.next!=null) pNew=pNew.next;
					pNew.next=root;
					root=root.next;
					pNew.next.next=null;
				}
			}
			else  // min element in the middle
			{
				p=root;
				while (p.next!=minRef) p=p.next;

				if (rootNew==null)
				{
					rootNew=p.next; 
					p.next=p.next.next;
					rootNew.next=null;
				}
				else
				{
					pNew = rootNew;
					while (pNew.next!=null) pNew=pNew.next;
					pNew.next=p.next;
					p.next=p.next.next;
					pNew.next.next=null;
				}
			}
		}
		root=rootNew;
	}
}