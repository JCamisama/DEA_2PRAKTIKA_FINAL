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
		
		zerre1.zerrendaHustu();
		peli1 = null;
	}

	@Test
	public void testRemove() { //DONE
		
		/* Proba kasuak:
		  
	
	 	- 7. Elementua zerrendan ez dagoenean eta elementu anitzeko zerrenda denean: Lehenengoa baino txikiagoa denean.
	 	- 8. Elementua zerrendan ez dagoenean eta elementu anitzeko zerrenda denean: Erdialdeko bat baino txikiagoa denean.
	 	- 9. Elementua zerrendan ez dagoenean eta elementu anitzeko zerrenda denean: Guztiak baino handiagoa denean.
	 */
		
		//1. Zerrenda hutsa denean
		OrderedDoubleLinkedList<Pelikula> zerreHutsa = new OrderedDoubleLinkedList<Pelikula>();
		assertNull(zerreHutsa.remove(peli1));
		
		//2. Elementua zerrendan dago eta elementu bakarreko zerrenda denean.
			//zerre1 peli1 bere baitan daukala jakinda
		assertEquals(peli1, zerre1.remove(peli1));
		
		
		//3. Elementu bakarreko zerrenda, ezabatu nahi dena ez egotea
		OrderedDoubleLinkedList<Pelikula> zerre2 = new OrderedDoubleLinkedList<Pelikula>();
		Pelikula	peli2	= new Pelikula("Zombie Party 2");
		zerre2.add(peli1);
		assertNull(zerreHutsa.remove(peli2));
		
		//4. Elementu anitzeko zerrenda, bilatutakoa hasieran egotea
			//zerre3 peli3 bere lehenengo posizioan daukala jakinda
		OrderedDoubleLinkedList<Pelikula> zerre3 = new OrderedDoubleLinkedList<Pelikula>();
		Pelikula	peli3	= new Pelikula("Zombie Party 2");
		Pelikula	peli4	= new Pelikula("Unlasting");
		zerre3.add(peli1);
		zerre3.add(peli2);
		zerre3.add(peli3);
		assertEquals(peli3, zerre3.remove(peli3));
		
		//5. Elementu anitzeko zerrenda, bilatutakoa erdian egotea
			//zerre3 peli2 bere erdialdeko posizioan (1) daukala jakinda (posizioak 0, 1 eta 2 direla)
		zerre3.add(peli3);
		assertEquals(peli2, zerre3.find(peli2));
		
		//6. Elementu anitzeko zerrenda, bilatutakoa amaieran egotea
			//zerre3 peli1 bere azkenengo posizioan daukala jakinda
		zerre3.add(peli1);
		assertEquals(peli1, zerre3.remove(peli1));
	
		//7. Elementu anitzeko zerrenda, bilatutakoa ez egotea
				assertNull(zerre3.remove(peli4));
				/*Kasu honetan ez du zerrenda osoa zeharkatuko ezabatu nahi den elementua aztertutakoa baino txikiagoa
				  bada.
				 */
		
		
	}

	@Test
	public void testFind() { //DONE
		
		//1. Zerrenda hutsa denean
		OrderedDoubleLinkedList<Pelikula> zerreHutsa = new OrderedDoubleLinkedList<Pelikula>();
		assertNull(zerreHutsa.find(peli1));
		
		//2. Elementu bakarreko zerrenda, bilatutakoa ez egotea
		OrderedDoubleLinkedList<Pelikula> zerre2 = new OrderedDoubleLinkedList<Pelikula>();
		Pelikula	peli2	= new Pelikula("K-POP: GRANDES EXITOS");
		zerre2.add(peli1);
		assertNull(zerreHutsa.find(peli2));
	
		//3. Elementu bakarreko zerrenda, bilatutakoa zerrendakoa izatea
			//zerre1 peli1 bere baitan daukala jakinda
		assertEquals(peli1, zerre1.find(peli1));
		
		//4. Elementu anitzeko zerrenda, bilatutakoa ez egotea
		OrderedDoubleLinkedList<Pelikula> zerre3 = new OrderedDoubleLinkedList<Pelikula>();
		Pelikula	peli3	= new Pelikula("Lollipop");
		Pelikula	peli4	= new Pelikula("Unlasting");
		zerre3.add(peli1);
		zerre3.add(peli2);
		zerre3.add(peli3);
		assertNull(zerre3.find(peli4));
		
		//5. Elementu anitzeko zerrenda, bilatutakoa hasieran egotea
			//zerre3 peli1 bere lehenengo posizioan daukala jakinda
		assertEquals(peli1, zerre3.find(peli1));
		assertEquals(peli1, zerre3.first());
		
		//6. Elementu anitzeko zerrenda, bilatutakoa amaieran egotea
			//zerre3 peli3 bere azkenengo posizioan daukala jakinda
		assertEquals(peli3, zerre3.find(peli3));
		assertEquals(peli3, zerre3.last());
	
		//7. Elementu anitzeko zerrenda, bilatutakoa erdian egotea
			//zerre3 peli2 bere erdialdeko posizioan (1) daukala jakinda (posizioak 0, 1 eta 2 direla)
		assertEquals(peli2, zerre3.find(peli2));
		assertEquals(1, zerre3.posizioaZerrendan(peli2));
	}

	@Test
	public void testAdd() { //DONE
		
		/* Proba kasuak:
		  
	 	- 5. Elementu berria zerrendan daudenak baino handiagoa izatea (azkenengo posizioan gehitzea).
	 */
		
		//1. Zerrenda hutsa denean
		OrderedDoubleLinkedList<Pelikula> zerreHutsa = new OrderedDoubleLinkedList<Pelikula>();
		zerreHutsa.add(peli1);
		assertEquals(zerre1.size(), 1);	
		
		
		//2. Elementu bakarrerko zerrenda denean	
		Pelikula	peli2	= new Pelikula("Zombie Party 2");
		zerre1.add(peli2);
		assertEquals(zerre1.size(), 2);		
		
		//3. Elementu berria zerrendan daudenak baino txikiagoa izatea (lehenengo posizioan gehitzea).
		OrderedDoubleLinkedList<Pelikula> zerreBerri = new OrderedDoubleLinkedList<Pelikula>();
		Pelikula	peliLehena	= new Pelikula("Agora");
		Pelikula	peli3	= new Pelikula("Blindsided");
		Pelikula	peli4	= new Pelikula("Cannibal");
		
		zerreBerri.add(peli3);
		zerreBerri.add(peli4);
		
			//peliLehena gehitzerakoan, lehenengo posizioan txertatuko da, A<B eta A<C
		zerreBerri.add(peliLehena);
		assertEquals(peliLehena, zerreBerri.first());
		
		
		//4. Elementu berria zerrendako erdialdeko posizio batean joatea.
			/*zerreBerri Agora(0), Blindsided(1) eta Cannibal(2) pelikulak bere barnean dituela,
				Blindsided-ren posizioa (1) konparatuko da.*/
		assertEquals(1, zerreBerri.posizioaZerrendan(peli3));
		
		//5. Elementu berria zerrendan daudenak baino handiagoa izatea (azkenengo posizioan gehitzea)
			//zerreBerri-n peli2 (Zombie Party 2) gehitzean, azkenengo posizioan egongo da.
		zerreBerri.add(peli2);
		assertEquals(peli2, zerreBerri.last());

	}

	@Test
	public void testMerge() {
		
		/*
		 	1. Zerrenda biak hutsak izatea {} ()
			2. Zerrendaren bat hutsa izatea {a,b} ( )
			3. Beste zerrenda hutsa izatea {} (a,b )
			4. Bi zerrenda eukita,euren arteko beste zerrenda ordenatu bat egitea {3,2} (1,4,5)
			5. Bi zerrenda eukita,euren arteko beste zerrenda ordenatu bat egitea, baina elementu bat erripikatzea {1,3,2} (3,4,5)
			
		 */
		
		// 1. Zerrenda biak hutsak izatea		
		OrderedDoubleLinkedList<Pelikula> zerreHutsa1 = new OrderedDoubleLinkedList<Pelikula>();
		OrderedDoubleLinkedList<Pelikula> zerreHutsa2 = new OrderedDoubleLinkedList<Pelikula>();
			//Zerrenda hutsa izaten jarraitzen duenez, bere luzeera 0 izango da
		zerreHutsa1.merge(zerreHutsa2);
		assertEquals(0, zerreHutsa1.size());
		
		// 2. Zerrendaren bat hutsa izatea
		OrderedDoubleLinkedList<Pelikula> zerre2 = new OrderedDoubleLinkedList<Pelikula>();		
		Pelikula	peli2	= new Pelikula("Zombie Party 2");
		zerre2.add(peli1);
		zerre2.add(peli2);
			//Zerre hutsa bat gehitzen denez, 2 elemntu bakarrik eukingo ditu
		zerre2.merge(zerreHutsa1);
		assertEquals(2, zerre2.size());
		
		// 3. Beste zerrenda hutsa izatea
		OrderedDoubleLinkedList<Pelikula> zerre3 = new OrderedDoubleLinkedList<Pelikula>();				
		zerre3.add(peli1);
		zerre3.add(peli2);
			//Zerre hutsa bat gehitzen denez, 2 elemntu bakarrik eukingo ditu
		zerreHutsa2.merge(zerre3);
		assertEquals(2, zerre3.size());
		
		
		
		
		
		
		
		
		
		
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
	public void testRemoveFirst() { //DONE
		
		//Elementu bakarrerko zerrenda denean		
		zerre1.removeFirst();
		assertEquals(zerre1.size(), 0);		
		
		//Elementu bat edo gehiako zerrenda denean
		Pelikula	peli2	= new Pelikula("Zombie Party 2");
		zerre1.add(peli1);
		zerre1.add(peli2);
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
		zerre1.add(peli1);
		zerre1.add(peli2);
		zerre1.removeLast();
		assertEquals(zerre1.size(), 1);
		
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
		OrderedDoubleLinkedList<Pelikula> zerreHutsa = new OrderedDoubleLinkedList<Pelikula>();
		assertNull(zerreHutsa.last());
		
		//Zerrenda elementu bakarra (zerre1 peli1 bere baitan daukala jakinda).
		assertEquals(peli1, zerre1.last());
		
		//Zerrenda elementu bat baino gehiago dituenean(zerre1 peli2 gehitzen).
		Pelikula	peli2	= new Pelikula("Zombie Party 2");
		zerre1.add(peli2);
		assertEquals(peli2, zerre1.last());
	}

	@Test
	public void testContains() { //DONE
		
	
	//1. Zerrenda hutsa izatea.
	OrderedDoubleLinkedList<Pelikula> zerreHutsa = new OrderedDoubleLinkedList<Pelikula>();
	assertFalse(zerreHutsa.contains(peli1));
	
	//2. Zerrenda ez hutsa izatea eta elementua zerrendan egotea.
	assertTrue(zerre1.contains(peli1));
	
	//3. Zerrenda ez hutsa izatea eta elementua zerrendan ez egotea. 	
	Pelikula	peli2	= new Pelikula("Zombie Party 2");
	assertFalse(zerre1.contains(peli2));
	
	/*Elementuaren posizioaren arabera erantzutea find() metodoaren menpe egongo da,
	  beraz, bere proba kasuak testfind()-en aurki daitezke */
	
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



}
