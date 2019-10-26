package packpraktika2;
import packpraktika1.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;


public class UnorderedDoubleLinkedListTest {
	
	UnorderedDoubleLinkedList<Pelikula>	zerre1	= null;
	Pelikula		peli1	= null;

	@Before
	public void setUp() throws Exception {
		
		zerre1	=	new UnorderedDoubleLinkedList();
		peli1	=	new Pelikula("Joker");
		
		zerre1.addToRear(peli1);
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		zerre1.zerrendaHustu();
		peli1 = null;
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testFind() {
		
		//assertEquals(zerre1.count, 1);
		assertTrue(peli1.equals(zerre1.find(peli1)));
	}

	@Test
	public void testAddToFront() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddToRear() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddAfter() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoubleLinkedList() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDeskr() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDeskr() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveFirst() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveLast() {
		fail("Not yet implemented");
	}

	@Test
	public void testFirst() {
		fail("Not yet implemented");
	}

	@Test
	public void testLast() {
		fail("Not yet implemented");
	}

	@Test
	public void testContains() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testIterator() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdabegiakInprimatu() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
