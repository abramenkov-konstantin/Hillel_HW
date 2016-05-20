package bstree;

import static org.junit.Assert.*;

import org.junit.Test;

public class BsTreeTest {

	//================================
	// Size
	//================================
	@Test
	public void testSize0()
	{
		int[]ar = {};
		BsTree tree = new BsTree(ar);
		int act = tree.size();
		assertEquals(0,act);
	}
	@Test
	public void testSize1()
	{
		int[]ar = {1};
		BsTree tree = new BsTree(ar);
		int act = tree.size();
		assertEquals(1,act);
	}
	@Test
	public void testSize2()
	{
		int[]ar = {1,2};
		BsTree tree = new BsTree(ar);
		int act = tree.size();
		assertEquals(2,act);
	}
	@Test
	public void testSizeMany()
	{
		int[]ar = {5,4,9};
		BsTree tree = new BsTree(ar);
		int act = tree.size();
		assertEquals(3,act);
	}

	//================================
	// leaves
	//================================

	@Test
	public void testLeaves0()
	{
		int[]ar = {};
		BsTree tree = new BsTree(ar);
		int act = tree.leaves();
		assertEquals(0,act);
	}
	@Test
	public void testLeaves1()
	{
		int[]ar = {1};
		BsTree tree = new BsTree(ar);
		int act = tree.leaves();
		assertEquals(1,act);
	}
	@Test
	public void testLeaves2()
	{
		int[]ar = {2,1,3};
		BsTree tree = new BsTree(ar);
		int act = tree.leaves();
		assertEquals(2,act);
	}

	@Test
	public void testLeavesMany()
	{
		int[]ar = {8,3,10,1,6,14,4,7,13};
		BsTree tree = new BsTree(ar);
		int act = tree.leaves();
		assertEquals(4,act);
	}

	//================================
	// nodes
	//================================

	@Test
	public void testNodes0()
	{
		int[]ar = {};
		BsTree tree = new BsTree(ar);
		int act = tree.nodes();
		assertEquals(0,act);
	}
	@Test
	public void testNodes1()
	{
		int[]ar = {1};
		BsTree tree = new BsTree(ar);
		int act = tree.nodes();
		assertEquals(0,act);
	}
	@Test
	public void testNodes2()
	{
		int[]ar = {2,1,3};
		BsTree tree = new BsTree(ar);
		int act = tree.nodes();
		assertEquals(1,act);
	}

	@Test
	public void testNodesMany()
	{
		int[]ar = {8,3,10,1,6,14,4,7,13};
		BsTree tree = new BsTree(ar);
		int act = tree.nodes();
		assertEquals(5,act);
	}

	//================================
	// height
	//================================

	@Test
	public void testHeight0()
	{
		int[]ar = {};
		BsTree tree = new BsTree(ar);
		int act = tree.height();
		assertEquals(0,act);
	}
	@Test
	public void testHeight1()
	{
		int[]ar = {1};
		BsTree tree = new BsTree(ar);
		int act = tree.height();
		assertEquals(1,act);
	}
	@Test
	public void testHeight2()
	{
		int[]ar = {2,1,3};
		BsTree tree = new BsTree(ar);
		int act = tree.height();
		assertEquals(2,act);
	}

	@Test
	public void testHeightMany()
	{
		int[]ar = {8,3,10,1,6,14,4,7,13};
		BsTree tree = new BsTree(ar);
		int act = tree.height();
		assertEquals(4,act);
	}

	//================================
	// width
	//================================

	@Test
	public void testWidth0()
	{
		int[]ar = {};
		BsTree tree = new BsTree(ar);
		int act = tree.width();
		assertEquals(0,act);
	}
	@Test
	public void testWidth1()
	{
		int[]ar = {1};
		BsTree tree = new BsTree(ar);
		int act = tree.width();
		assertEquals(1,act);
	}
	@Test
	public void testWidth2()
	{
		int[]ar = {2,1,3};
		BsTree tree = new BsTree(ar);
		int act = tree.width();
		assertEquals(2,act);
	}

	@Test
	public void testWidthMany()
	{
		int[]ar = {8,3,10,1,6,14,4,7,13};
		BsTree tree = new BsTree(ar);
		int act = tree.width();
		assertEquals(3,act);
	}


	//================================
	// Add
	//================================
	@Test
	public void testAdd0()
	{
		int[]ar = {};
		BsTree tree = new BsTree(ar);
		tree.add(1);
		int[] act = tree.toArray();
		int[] exp = {1};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testAdd1()
	{
		int[]ar = {1};
		BsTree tree = new BsTree(ar);
		tree.add(2);
		int[] act = tree.toArray();
		int[] exp = {1,2};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testAdd3()
	{
		int[]ar = {1,2};
		BsTree tree = new BsTree(ar);
		tree.add(3);
		int[] act = tree.toArray();
		int[] exp = {1,2,3};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testAddMany()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.add(2);
		int[] act = tree.toArray();
		int[] exp = {1,2,3,4,5,6,7,8,9,10,15,18,25,26};
		assertArrayEquals(exp,act);	
	}

	//================================
	// Delete1 (insertion)
	//================================
	@Test (expected = IllegalArgumentException.class)
	public void testDelete1_0_1()  
	{
		int[]ar = {};
		BsTree tree = new BsTree(ar);
		tree.delete1(0);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testDelete1_0_2()  
	{
		int[]ar = {1};
		BsTree tree = new BsTree(ar);
		tree.delete1(5);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testDelete1_0_3()  
	{
		int[]ar = {2,4};
		BsTree tree = new BsTree(ar);
		tree.delete1(5);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testDelete1_0_4()  
	{
		int[]ar = {2,4,6,3,7};
		BsTree tree = new BsTree(ar);
		tree.delete1(5);
	}
	@Test
	public void testDelete1_1()
	{
		int[]ar = {1};
		BsTree tree = new BsTree(ar);
		tree.delete1(1);
		int[] act = tree.toArray();
		int[] exp = {};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete1_2_1()
	{
		int[]ar = {1,2};
		BsTree tree = new BsTree(ar);
		tree.delete1(2);
		int[] act = tree.toArray();
		int[] exp = {1};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete1_2_2()
	{
		int[]ar = {1,2};
		BsTree tree = new BsTree(ar);
		tree.delete1(1);
		int[] act = tree.toArray();
		int[] exp = {2};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete1_3_1()
	{
		int[]ar = {2,1,3};
		BsTree tree = new BsTree(ar);
		tree.delete1(1);
		int[] act = tree.toArray();
		int[] exp = {2,3};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete1_3_2()
	{
		int[]ar = {2,1,3};
		BsTree tree = new BsTree(ar);
		tree.delete1(2);
		int[] act = tree.toArray();
		int[] exp = {1,3};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete1_3_3()
	{
		int[]ar = {2,1,3};
		BsTree tree = new BsTree(ar);
		tree.delete1(3);
		int[] act = tree.toArray();
		int[] exp = {1,2};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete1_Many_1()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.delete1(5);
		int[] act = tree.toArray();
		int[] exp = {1,3,4,6,7,8,9,10,15,18,25,26};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete1_Many_2()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.delete1(4);
		int[] act = tree.toArray();
		int[] exp = {1,3,5,6,7,8,9,10,15,18,25,26};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete1_Many_3()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.delete1(9);
		int[] act = tree.toArray();
		int[] exp = {1,3,4,5,6,7,8,10,15,18,25,26};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete1_Many_4()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.delete1(3);
		int[] act = tree.toArray();
		int[] exp = {1,4,5,6,7,8,9,10,15,18,25,26};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete1_Many_5()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.delete1(8);
		int[] act = tree.toArray();
		int[] exp = {1,3,4,5,6,7,9,10,15,18,25,26};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete1_Many_6()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.delete1(15);
		int[] act = tree.toArray();
		int[] exp = {1,3,4,5,6,7,8,9,10,18,25,26};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete1_Many_7()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.delete1(6);
		int[] act = tree.toArray();
		int[] exp = {1,3,4,5,7,8,9,10,15,18,25,26};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete1_Many_8()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.delete1(26);
		int[] act = tree.toArray();
		int[] exp = {1,3,4,5,6,7,8,9,10,15,18,25};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete1_Many_9()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.delete1(25);
		int[] act = tree.toArray();
		int[] exp = {1,3,4,5,6,7,8,9,10,15,18,26};
		assertArrayEquals(exp,act);	
	}

	//================================
	// Delete2 (rotation)
	//================================
	@Test (expected = IllegalArgumentException.class)
	public void testDelete2_0_1()  
	{
		int[]ar = {};
		BsTree tree = new BsTree(ar);
		tree.delete2(0);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testDelete2_0_2()  
	{
		int[]ar = {1};
		BsTree tree = new BsTree(ar);
		tree.delete2(5);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testDelete2_0_3()  
	{
		int[]ar = {2,4};
		BsTree tree = new BsTree(ar);
		tree.delete2(5);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testDelete2_0_4()  
	{
		int[]ar = {2,4,6,3,7};
		BsTree tree = new BsTree(ar);
		tree.delete2(5);
	}
	@Test
	public void testDelete2_1()
	{
		int[]ar = {1};
		BsTree tree = new BsTree(ar);
		tree.delete2(1);
		int[] act = tree.toArray();
		int[] exp = {};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete2_2_1()
	{
		int[]ar = {1,2};
		BsTree tree = new BsTree(ar);
		tree.delete2(2);
		int[] act = tree.toArray();
		int[] exp = {1};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete2_2_2()
	{
		int[]ar = {1,2};
		BsTree tree = new BsTree(ar);
		tree.delete2(1);
		int[] act = tree.toArray();
		int[] exp = {2};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete2_3_1()
	{
		int[]ar = {2,1,3};
		BsTree tree = new BsTree(ar);
		tree.delete2(1);
		int[] act = tree.toArray();
		int[] exp = {2,3};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete2_3_2()
	{
		int[]ar = {2,1,3};
		BsTree tree = new BsTree(ar);
		tree.delete2(2);
		int[] act = tree.toArray();
		int[] exp = {1,3};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete2_3_3()
	{
		int[]ar = {2,1,3};
		BsTree tree = new BsTree(ar);
		tree.delete2(3);
		int[] act = tree.toArray();
		int[] exp = {1,2};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete2_Many_1()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.delete2(5);
		int[] act = tree.toArray();
		int[] exp = {1,3,4,6,7,8,9,10,15,18,25,26};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete2_Many_2()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.delete2(4);
		int[] act = tree.toArray();
		int[] exp = {1,3,5,6,7,8,9,10,15,18,25,26};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete2_Many_3()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.delete2(9);
		int[] act = tree.toArray();
		int[] exp = {1,3,4,5,6,7,8,10,15,18,25,26};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete2_Many_4()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.delete2(3);
		int[] act = tree.toArray();
		int[] exp = {1,4,5,6,7,8,9,10,15,18,25,26};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete2_Many_5()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.delete2(8);
		int[] act = tree.toArray();
		int[] exp = {1,3,4,5,6,7,9,10,15,18,25,26};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete2_Many_6()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.delete2(15);
		int[] act = tree.toArray();
		int[] exp = {1,3,4,5,6,7,8,9,10,18,25,26};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete2_Many_7()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.delete2(6);
		int[] act = tree.toArray();
		int[] exp = {1,3,4,5,7,8,9,10,15,18,25,26};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete2_Many_8()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.delete2(26);
		int[] act = tree.toArray();
		int[] exp = {1,3,4,5,6,7,8,9,10,15,18,25};
		assertArrayEquals(exp,act);	
	}
	@Test
	public void testDelete2_Many_9()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		BsTree tree = new BsTree(ar);
		tree.delete2(25);
		int[] act = tree.toArray();
		int[] exp = {1,3,4,5,6,7,8,9,10,15,18,26};
		assertArrayEquals(exp,act);	
	}



	//================================
	// toArray
	//================================

	@Test
	public void testToArray0()
	{
		int[] ar = {};
		int[] exp = {};
		BsTree tree = new BsTree(ar);
		int[] act = tree.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testToArray1()
	{
		int[] ar = {10};
		int[] exp = {10};
		BsTree tree = new BsTree(ar);
		int[] act = tree.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testToArray2_1()
	{
		int[]ar = {20,10};
		int[] exp = {10,20};
		BsTree tree = new BsTree(ar);
		int[] act = tree.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testToArray2_2()
	{
		int[]ar = {10,20};
		int[] exp = {10,20};
		BsTree tree = new BsTree(ar);
		int[] act = tree.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testToArrayMany1()
	{
		int[]ar = {10,20,77,67,14};
		int[] exp = {10,14,20,67,77};
		BsTree tree = new BsTree(ar);
		int[] act = tree.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testToArrayMany2()
	{
		int[]ar = {5,4,9,3,8,15,1,6,10,18,7,25,26};
		int[] exp = {1,3,4,5,6,7,8,9,10,15,18,25,26};
		BsTree tree = new BsTree(ar);
		int[] act = tree.toArray();
		assertArrayEquals(exp,act);
	}
}
