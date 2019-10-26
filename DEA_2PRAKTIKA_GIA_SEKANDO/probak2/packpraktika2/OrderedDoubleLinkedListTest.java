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
		
		zerre1	=	new OrderedDoubleLinkedList();
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
		
		OrderedDoubleLinkedList<Pelikula> zerreHutsa = new OrderedDoubleLinkedList();
		
		//Zerrenda hutsa denean
		assertTrue(zerreHutsa.isEmpty());
		
		//Zerrenda ez-hutsa denean (peli1 bere baitan dago)
		assertFalse(zerre1.isEmpty());
	}
	
	
	
	
	@Test
	public void testSize() {
		
		OrderedDoubleLinkedList<Pelikula>	zerreHutsa	= new OrderedDoubleLinkedList();
		OrderedDoubleLinkedList<Pelikula>	zerre2		= new OrderedDoubleLinkedList();
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
