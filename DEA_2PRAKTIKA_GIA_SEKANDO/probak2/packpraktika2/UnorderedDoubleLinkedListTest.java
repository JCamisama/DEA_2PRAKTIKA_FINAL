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
		
		zerre1	=	new UnorderedDoubleLinkedList<Pelikula>();
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
	public void testAddToFront() { //DONE
		
		//Zerrenda hutsa danean
		UnorderedDoubleLinkedList<Pelikula> zerreHutsa = new UnorderedDoubleLinkedList<Pelikula>();
		zerreHutsa.addToFront(peli1);
		assertEquals(zerre1.size(), 1);	
		
		
		//Elementu bakarrerko zerrenda denean	
		Pelikula	peli2	= new Pelikula("Zombie Party 2");
		zerre1.addToFront(peli2);
		assertEquals(zerre1.size(), 2);		
				
		//Elementu bat edo gehiako zerrenda denean
		UnorderedDoubleLinkedList<Pelikula> zerre2 = new UnorderedDoubleLinkedList<Pelikula>();
		Pelikula	peli3	= new Pelikula("Zombie Party 2");
		zerre2.addToFront(peli1);
		zerre2.addToFront(peli2);
		zerre2.addToFront(peli3);		
		assertEquals(zerre2.size(), 3);
		
	}

	@Test
	public void testAddToRear() { //DONE
		
		//Zerrenda hutsa danean
		UnorderedDoubleLinkedList<Pelikula> zerreHutsa = new UnorderedDoubleLinkedList<Pelikula>();
		zerreHutsa.addToRear(peli1);
		assertEquals(zerre1.size(), 1);	
		
		
		//Elementu bakarrerko zerrenda denean	
		Pelikula	peli2	= new Pelikula("Zombie Party 2");
		zerre1.addToRear(peli2);
		assertEquals(zerre1.size(), 2);		
				
		//Elementu bat edo gehiako zerrenda denean
		UnorderedDoubleLinkedList<Pelikula> zerre2 = new UnorderedDoubleLinkedList<Pelikula>();
		Pelikula	peli3	= new Pelikula("Zombie Party 2");
		zerre2.addToRear(peli1);
		zerre2.addToRear(peli2);
		zerre2.addToRear(peli3);		
		assertEquals(zerre2.size(), 3);
		
		
	}

	@Test
	public void testAddAfter() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testSetDeskr() { //DONE
		//Zerrendaren deskribapena egiten...
		
		String deskribapen = "deskribapen hau ez da zuk ulertzeko";
		zerre1.setDeskr(deskribapen);
		assertEquals("deskribapen hau ez da zuk ulertzeko", zerre1.getDeskr());			

	}

	@Test
	public void testGetDeskr() {//DONE
		//Zerrendaren deskribapena egiten...
		
		String deskribapen = "deskribapen hau ez da zuk ulertzeko";
		zerre1.setDeskr(deskribapen);
		assertEquals("deskribapen hau ez da zuk ulertzeko", zerre1.getDeskr());			
		
	}

	@Test
	public void testRemoveFirst() { //DONE
		
		//Elementu bakarrerko zerrenda denean		
		zerre1.removeFirst();
		assertEquals(zerre1.size(), 0);		
		
		//Elementu bat edo gehiako zerrenda denean
		Pelikula	peli2	= new Pelikula("Zombie Party 2");
		zerre1.addToFront(peli1);
		zerre1.addToFront(peli2);
		zerre1.removeFirst();
		assertEquals(zerre1.size(), 1);
		
	}

	@Test
	public void testRemoveLast() { //DONE
		
		//Elementu bakarrerko zerrenda denean		
		zerre1.removeLast();
		assertEquals(zerre1.size(), 0);
		
		//Elementu bat edo gehiako zerrenda denean
		Pelikula	peli2	= new Pelikula("Zombie Party 2");
		zerre1.addToFront(peli1);
		zerre1.addToFront(peli2);
		zerre1.removeLast();
		assertEquals(zerre1.size(), 1);
		
	}

	
	
	@Test
	public void testFirst() { //DONE

		//Zerrenda hutsa denean.
		UnorderedDoubleLinkedList<Pelikula> zerreHutsa = new UnorderedDoubleLinkedList<Pelikula>();
		assertNull(zerreHutsa.first());
		
		//Zerrenda elementu bakarra (zerre1 peli1 bere baitan daukala jakinda).
		assertEquals(peli1, zerre1.first());
		
		//Zerrenda elementu bat baino gehiago dituenean(zerre1 peli2 gehitzen).
		Pelikula	peli2	= new Pelikula("Zombie Party 2");
		zerre1.addToFront(peli2);
		assertEquals(peli2, zerre1.first());
		
	}

	
	
	@Test
	public void testLast() { //DONE
		
		//Zerrenda hutsa denean.
		UnorderedDoubleLinkedList<Pelikula> zerreHutsa = new UnorderedDoubleLinkedList<Pelikula>();
		assertNull(zerreHutsa.last());
		
		//Zerrenda elementu bakarra (zerre1 peli1 bere baitan daukala jakinda).
		assertEquals(peli1, zerre1.last());
		
		//Zerrenda elementu bat baino gehiago dituenean(zerre1 peli2 gehitzen).
		Pelikula	peli2	= new Pelikula("Zombie Party 2");
		zerre1.addToFront(peli2);
		assertEquals(peli1, zerre1.last());
	}

	@Test
	public void testContains() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty() { //DONE
		
		UnorderedDoubleLinkedList<Pelikula> zerreHutsa = new UnorderedDoubleLinkedList<Pelikula>();
		
		//Zerrenda hutsa denean
		assertTrue(zerreHutsa.isEmpty());
		
		//Zerrenda ez-hutsa denean (peli1 bere baitan dago)
		assertFalse(zerre1.isEmpty());
		
	}

	@Test
	public void testSize() { //DONE
		
		UnorderedDoubleLinkedList<Pelikula>	zerreHutsa	= new UnorderedDoubleLinkedList<Pelikula>();
		UnorderedDoubleLinkedList<Pelikula>	zerre2		= new UnorderedDoubleLinkedList<Pelikula>();
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
