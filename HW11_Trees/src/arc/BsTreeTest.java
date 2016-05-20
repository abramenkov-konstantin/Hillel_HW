import static org.junit.Assert.*;

import org.junit.Test;

public class BsTreeTest 
{

	// =========================
	// Size
	// =========================
	
	@Test
	public void testSize_null() 
	{
		BsTree tree = new BsTree();
		int[] test = null;
		tree.init(test);
		int res = tree.size();
		assertEquals(0, res);
	}
	
	@Test
	public void testSize_0() 
	{
		BsTree tree = new BsTree();
		int[] test = {};
		tree.init(test);
		int res = tree.size();
		assertEquals(0, res);
	}
	
	@Test
	public void testSize_1() 
	{
		BsTree tree = new BsTree();
		int[] test = { 50 };
		tree.init(test);
		int res = tree.size();
		assertEquals(1, res);
	}
	
	@Test
	public void testSize_2() 
	{
		BsTree tree = new BsTree();
		int[] test = { 50, 25 };
		tree.init(test);
		int res = tree.size();
		assertEquals(2, res);
	}
	
	@Test
	public void testSize_many() 
	{
		BsTree tree = new BsTree();
		int[] test = { 50, 25, 33, 70, 11, 28, 5, 15, 60, 100, 51, 2 };
		tree.init(test);
		int res = tree.size();
		assertEquals(12, res);
	}

	// =========================
	// Nodes
	// =========================
	
	@Test
	public void testNodes_null() 
	{
		BsTree tree = new BsTree();
		int[] test = null;
		tree.init(test);
		int res = tree.nodes();
		assertEquals(0, res);
	}
	
	@Test
	public void testNodes_0() 
	{
		BsTree tree = new BsTree();
		int[] test = {};
		tree.init(test);
		int res = tree.nodes();
		assertEquals(0, res);
	}
	
	@Test
	public void testNodes_1() 
	{
		BsTree tree = new BsTree();
		int[] test = { 50 };
		tree.init(test);
		int res = tree.nodes();
		assertEquals(0, res);
	}
	
	@Test
	public void testNodes_2() 
	{
		BsTree tree = new BsTree();
		int[] test = { 50, 25 };
		tree.init(test);
		int res = tree.nodes();
		assertEquals(1, res);
	}
	
	@Test
	public void testNodes_many() 
	{
		BsTree tree = new BsTree();
		int[] test = { 50, 25, 33, 70, 11, 28, 5, 15, 60, 100, 51, 2 };
		tree.init(test);
		int res = tree.nodes();
		assertEquals(7, res);
	}

	// =========================
	// Leafs
	// =========================
	
	@Test
	public void testLeafs_null() 
	{
		BsTree tree = new BsTree();
		int[] test = null;
		tree.init(test);
		int res = tree.leafs();
		assertEquals(0, res);
	}
	
	@Test
	public void testLeafs_0() 
	{
		BsTree tree = new BsTree();
		int[] test = {};
		tree.init(test);
		int res = tree.leafs();
		assertEquals(0, res);
	}
	
	@Test
	public void testLeafs_1() 
	{
		BsTree tree = new BsTree();
		int[] test = { 50 };
		tree.init(test);
		int res = tree.leafs();
		assertEquals(1, res);
	}
	
	@Test
	public void testLeafs_2() 
	{
		BsTree tree = new BsTree();
		int[] test = { 50, 25 };
		tree.init(test);
		int res = tree.leafs();
		assertEquals(1, res);
	}
	
	@Test
	public void testLeafs_many() 
	{
		BsTree tree = new BsTree();
		int[] test = { 50, 25, 33, 70, 11, 28, 5, 15, 60, 100, 51, 2 };
		tree.init(test);
		int res = tree.leafs();
		assertEquals(5, res);
	}

	// =========================
	// Height
	// =========================
	
	@Test
	public void testHeight_null() 
	{
		BsTree tree = new BsTree();
		int[] test = null;
		tree.init(test);
		int res = tree.height();
		assertEquals(0, res);
	}
	
	@Test
	public void testHeight_0() 
	{
		BsTree tree = new BsTree();
		int[] test = {};
		tree.init(test);
		int res = tree.height();
		assertEquals(0, res);
	}
	
	@Test
	public void testHeight_1() 
	{
		BsTree tree = new BsTree();
		int[] test = { 50 };
		tree.init(test);
		int res = tree.height();
		assertEquals(1, res);
	}
	
	@Test
	public void testHeight_2() 
	{
		BsTree tree = new BsTree();
		int[] test = { 50, 25 };
		tree.init(test);
		int res = tree.height();
		assertEquals(2, res);
	}
	
	@Test
	public void testHeight_many() 
	{
		BsTree tree = new BsTree();
		int[] test = { 50, 25, 33, 70, 11, 28, 5, 15, 60, 100, 51, 2 };
		tree.init(test);
		int res = tree.height();
		assertEquals(5, res);
	}

	// =========================
	// Width
	// =========================
	
	@Test
	public void testWidth() 
	{
		
	}

	// =========================
	// ToArray
	// =========================
	
	@Test
	public void testToArray_null() 
	{
		BsTree tree = new BsTree();
		int[] test = null;
		tree.init(test);
		int[] res = tree.toArray();
		int[] exp = {};
		assertArrayEquals(exp, res);
	}
	
	@Test
	public void testToArray_0() 
	{
		BsTree tree = new BsTree();
		int[] test = {};
		tree.init(test);
		int[] res = tree.toArray();
		int[] exp = {};
		assertArrayEquals(exp, res);
	}
	
	@Test
	public void testToArray_1() 
	{
		BsTree tree = new BsTree();
		int[] test = { 50 };
		tree.init(test);
		int[] res = tree.toArray();
		int[] exp = { 50 };
		assertArrayEquals(exp, res);
	}
	
	@Test
	public void testToArray_2() 
	{
		BsTree tree = new BsTree();
		int[] test = { 50, 25 };
		tree.init(test);
		int[] res = tree.toArray();
		int[] exp = { 25, 50 };
		assertArrayEquals(exp, res);
	}
	
	@Test
	public void testToArray_many() 
	{
		BsTree tree = new BsTree();
		int[] test = { 50, 25, 33, 70, 11, 28, 5, 15, 60, 100, 51, 2 };
		tree.init(test);
		int[] res = tree.toArray();
		int[] exp = { 2, 5, 11, 15, 25, 28, 33, 50, 51, 60, 70, 100 };
		assertArrayEquals(exp, res);
	}
}
