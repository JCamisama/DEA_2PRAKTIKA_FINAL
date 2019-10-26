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
		//Zerrendaren deskribapena egiten...
		
		String deskribapen = "deskribapen hau ez da zuk ulertzeko";
		zerre1.setDeskr(deskribapen);
		assertEquals("deskribapen hau ez da zuk ulertzeko", zerre1.getDeskr());			

	}

	@Test
	public void testGetDeskr() {
		//Zerrendaren deskribapena egiten...
		
		String deskribapen = "deskribapen hau ez da zuk ulertzeko";
		zerre1.setDeskr(deskribapen);
		assertEquals("deskribapen hau ez da zuk ulertzeko", zerre1.getDeskr());			
		
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
		
		UnorderedDoubleLinkedList zerreHutsa = new UnorderedDoubleLinkedList();
		
		//Zerrenda hutsa denean
		assertTrue(zerreHutsa.isEmpty());
		
		//Zerrenda ez-hutsa denean (peli1 bere baitan dago)
		assertFalse(zerre1.isEmpty());
		
	}

	@Test
	public void testSize() {
		
		UnorderedDoubleLinkedList<Pelikula>	zerreHutsa	= new UnorderedDoubleLinkedList();
		UnorderedDoubleLinkedList<Pelikula>	zerre2		= new UnorderedDoubleLinkedList();
		Pelikula							peli2		= new Pelikula("Zombie Party 2");
		
		//Zerrenda hutsa denean
		assertEquals(zerreHutsa.size(), 0);
		
		//Zerrenda elementu bakarra daukanean (peli1 bere barnean)
		assertEquals(zerre1.size(), 1);
		
		//Zerrenda elementu bat baino gehiago dituenean (peli1 eta peli2 bere barnean)
		zerre2.addToRear(peli1);
		zerre2.addToRear(peli2);
		assertEquals(zerre2.size(), 2);
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
