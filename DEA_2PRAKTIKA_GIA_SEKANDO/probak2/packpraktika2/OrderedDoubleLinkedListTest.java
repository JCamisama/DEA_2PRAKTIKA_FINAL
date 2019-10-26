package packpraktika2;
import packpraktika1.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class OrderedDoubleLinkedListTest {

	OrderedDoubleLinkedList<Pelikula>	zerre1	= null;
	Pelikula		peli1	= null;
	
	@Before
	public void setUp() throws Exception {
		
		zerre1	=	new OrderedDoubleLinkedList<Pelikula>();
		peli1	=	new Pelikula("Joker");
		
		zerre1.add(peli1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testFind() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		
		OrderedDoubleLinkedList<Pelikula>	zerre2		= null;
				zerre2 = new OrderedDoubleLinkedList();
		Pelikula							peli2		= null;
				peli2 = new Pelikula("Zombie Party 2");
		
		zerre2.add(peli2);
		assertEquals(zerre2.size(), 1);
		
		
		
		
	}

	@Test
	public void testMerge() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoubleLinkedList() {
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
	public void testGetDeskr() { //DONE
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
	public void testFirst() { //DONE

		//Zerrenda hutsa denean.
		OrderedDoubleLinkedList<Pelikula> zerreHutsa = new OrderedDoubleLinkedList<Pelikula>();
		assertNull(zerreHutsa.first());
		
		//Zerrenda elementu bakarra (zerre1 peli1 bere baitan daukala jakinda).
		assertEquals(peli1, zerre1.first());
		
		//Zerrenda elementu bat baino gehiago dituenean(zerre1 peli2 gehitzen).
		Pelikula	peli2	= new Pelikula("Zombie Party 2");
		zerre1.add(peli2);
		assertEquals(peli1, zerre1.first());
		
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
		zerre1.add(peli2);
		assertEquals(peli2, zerre1.last());
	}

	@Test
	public void testContains() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty() { //DONE
		
		OrderedDoubleLinkedList<Pelikula> zerreHutsa = new OrderedDoubleLinkedList<Pelikula>();
		
		//Zerrenda hutsa denean
		assertTrue(zerreHutsa.isEmpty());
		
		//Zerrenda ez-hutsa denean (peli1 bere baitan dago)
		assertFalse(zerre1.isEmpty());
	}
	
	
	
	
	@Test
	public void testSize() { //DONE
		
		OrderedDoubleLinkedList<Pelikula>	zerreHutsa	= new OrderedDoubleLinkedList<Pelikula>();
		OrderedDoubleLinkedList<Pelikula>	zerre2		= new OrderedDoubleLinkedList<Pelikula>();
		Pelikula							peli2		= new Pelikula("Zombie Party 2");
		
		//Zerrenda hutsa denean
		assertEquals(zerreHutsa.size(), 0);
		
		//Zerrenda elementu bakarra daukanean (peli1 bere barnean)
		assertEquals(zerre1.size(), 1);
		System.out.println("Hello mudafaka");
		
		//Zerrenda elementu bat baino gehiago dituenean (peli1 eta peli2 bere barnean)
		zerre2.add(peli1);
		zerre2.add(peli2);
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
