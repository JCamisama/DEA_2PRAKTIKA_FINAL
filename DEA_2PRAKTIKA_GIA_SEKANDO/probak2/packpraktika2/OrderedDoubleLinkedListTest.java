package packpraktika2;
import packpraktika1.*;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
		  
	 	
	 */
		
		//1. Zerrenda hutsa denean
		OrderedDoubleLinkedList<Pelikula> zerreHutsa = new OrderedDoubleLinkedList<Pelikula>();
		zerreHutsa.add(peli1);
		assertEquals(zerre1.size(), 1);	
		assertEquals(zerre1.find(peli1), peli1);	//pelikula barnean dagoela konprobatzen
		
		
		//2. Elementu bakarrerko zerrenda denean	
		Pelikula	peli2	= new Pelikula("Zombie Party 2");
		zerre1.add(peli2);
		
		assertEquals(zerre1.size(), 2);
		assertEquals(zerre1.find(peli1), peli1);	//pelikula barnean dagoela konprobatzen
		assertEquals(zerre1.find(peli2), peli2);	//pelikula barnean dagoela konprobatzen
		
		
		//3. Elementu berria zerrendan daudenak baino txikiagoa izatea (lehenengo posizioan gehitzea).
		OrderedDoubleLinkedList<Pelikula> zerreBerri = new OrderedDoubleLinkedList<Pelikula>();
		Pelikula	peliLehena	= new Pelikula("Agora");
		Pelikula	peli3		= new Pelikula("Blindsided");
		Pelikula	peli4		= new Pelikula("Cannibal");
		Pelikula 	peli5		= new Pelikula("Fast and Furious 18");
		Pelikula 	peli6		= new Pelikula("Mad Max");
		
		zerreBerri.add(peli3);
		zerreBerri.add(peli4);
		zerreBerri.add(peli5);
		zerreBerri.add(peli6);
		
			//peliLehena gehitzerakoan, lehenengo posizioan txertatuko da, A<B eta A<C
		zerreBerri.add(peliLehena);
		assertEquals(peliLehena, zerreBerri.first());
		
			//Beste pelikulak zerrendan daudela konrpobatzen (eta posizio egokian)
		assertEquals(zerreBerri.find(peli3), peli3);
		assertEquals(1, zerreBerri.posizioaZerrendan(peli3));
		
		assertEquals(zerreBerri.find(peli4), peli4);
		assertEquals(2, zerreBerri.posizioaZerrendan(peli4));
		
		assertEquals(zerreBerri.find(peli5), peli5);
		assertEquals(3, zerreBerri.posizioaZerrendan(peli5));
		
		assertEquals(zerreBerri.find(peli6), peli6);
		assertEquals(4, zerreBerri.posizioaZerrendan(peli6));
		
		
		//4. Elementu berria zerrendako erdialdeko posizio batean joatea.
			/*zerreBerri Agora(0), Blindsided(1), Cannibal(2), Fast and Furious 18(3) eta Mad Max(4) pelikulak bere barnean dituela,
			  Cannibal-ren posizioa (2) konparatuko da.*/
		
		Pelikula	peliErdialdekoa	= new Pelikula("Caballeros del Zodiaco");
		zerreBerri.add(peliErdialdekoa);
		assertEquals(2, zerreBerri.posizioaZerrendan(peliErdialdekoa));
		
		
		//5. Elementu berria zerrendan daudenak baino handiagoa izatea (azkenengo posizioan gehitzea)
			//zerreBerri-n peli2 (Zombie Party 2) gehitzean, azkenengo posizioan egongo da.
		zerreBerri.add(peli2);
		assertEquals(peli2, zerreBerri.last());
		
		Iterator<Pelikula> itr = zerreBerri.iterator();
		
		while (itr.hasNext()) {
			Pelikula peliHau = itr.next();
			peliHau.inprimatuIzena();
		}	

	}

	@Test
	public void testMerge() {
		
		// 1. Zerrenda biak hutsak izatea		
		OrderedDoubleLinkedList<Pelikula> zerreHutsa1 = new OrderedDoubleLinkedList<Pelikula>();
		OrderedDoubleLinkedList<Pelikula> zerreHutsa2 = new OrderedDoubleLinkedList<Pelikula>();
			//Zerrenda hutsa izaten jarraitzen duenez, bere luzeera 0 izango da
		zerreHutsa1.merge(zerreHutsa2);
		assertEquals(0, zerreHutsa1.size());
		
		// 2. Lehenengo zerrenda ez-hutsa eta bigarrena hutsa
		OrderedDoubleLinkedList<Pelikula> zerre2 = new OrderedDoubleLinkedList<Pelikula>();		
		Pelikula	peli2	= new Pelikula("Zombie Party 2");
		zerre2.add(peli1);
		zerre2.add(peli2);
			//Zerre hutsa bat gehitzen denez, 2 elemntu bakarrik eukingo ditu
		zerre2.merge(zerreHutsa1);
		assertEquals(2, zerre2.size());
		
		// 3. Lehenengo zerrenda hutsa eta bigarrena ez-hutsa
		OrderedDoubleLinkedList<Pelikula> zerre3 = new OrderedDoubleLinkedList<Pelikula>();				
		zerre3.add(peli1);
		zerre3.add(peli2);
			//Zerre hutsa bat gehitzen denez, 2 elemntu bakarrik eukingo ditu
		zerreHutsa2.merge(zerre3);
		assertEquals(2, zerreHutsa2.size());
		
		// 4. Bi zerrenda izanda, haien artean beste zerrenda ordenatu bat egitea 
		
			//Zerrenda bat
		OrderedDoubleLinkedList<Pelikula> zerreBat = new OrderedDoubleLinkedList<Pelikula>();
		Pelikula	peliBat	 = new Pelikula("Acha");
		Pelikula	peliBi	 = new Pelikula("Bazuka");
		Pelikula	peliHiru = new Pelikula("Casiopea");
		zerreBat.add(peliBat);
		zerreBat.add(peliBi);
		zerreBat.add(peliHiru);
		
			//Zerrenda bi
		OrderedDoubleLinkedList<Pelikula> zerreBi = new OrderedDoubleLinkedList<Pelikula>();
		Pelikula	peliBat2	 = new Pelikula("Asakura");
		Pelikula	peliBi2	 = new Pelikula("Bisuper");
		Pelikula	peliHiru2 = new Pelikula("Cerbero");
		zerreBi.add(peliBat2);
		zerreBi.add(peliBi2);
		zerreBi.add(peliHiru2);
		
			//Biak elkartzen
		zerreBat.merge(zerreBi);
		
			//Luzeraren eta inprimatutakoaren arabera gauzak ondo atera direla frogatuko da
		assertEquals(6, zerreBat.size());
		
		
		Iterator<Pelikula> it4 = zerreBat.iterator();
		
		while (it4.hasNext()) {
			Pelikula peliHau = it4.next();
			peliHau.inprimatuIzena();
		}
		System.out.println("\n\n\n");
		
		// 5. Bi zerrenda izanda, haien artean beste zerrenda ordenatu bat egitea, elementu berdin bat dutela
		zerreBat.zerrendaHustu();
		zerreBi.zerrendaHustu();
		Pelikula	peliErrepikatu	 = new Pelikula("Botica de la Abuela");
		
		zerreBat.add(peliBat);
		zerreBat.add(peliBi);
		zerreBat.add(peliHiru);
		zerreBat.add(peliErrepikatu);
		
		zerreBi.add(peliBat2);
		zerreBi.add(peliBi2);
		zerreBi.add(peliHiru2);
		zerreBi.add(peliErrepikatu);
		
			//Biak elkartzen
		zerreBat.merge(zerreBi);
			//Luzeraren eta inprimatutakoaren arabera gauzak ondo atera direla frogatuko da
		assertEquals(8, zerreBat.size());
		
		Iterator<Pelikula> it5 = zerreBat.iterator();
		
		while (it5.hasNext()) {
			Pelikula peliHau = it5.next();
			peliHau.inprimatuIzena();
		}
		System.out.println("\n\n\n");
		
		
	
		// 6. Bi zerrenda izanda, elementu guztiak errepikatuta daudenean
		zerreBat.zerrendaHustu();
		zerreBi.zerrendaHustu();
		
		zerreBat.add(peliErrepikatu);
		zerreBat.add(peliErrepikatu);
		zerreBat.add(peliErrepikatu);
		zerreBat.add(peliErrepikatu);
		
		zerreBi.add(peliErrepikatu);
		zerreBi.add(peliErrepikatu);
		zerreBi.add(peliErrepikatu);
		zerreBi.add(peliErrepikatu);
		
		//Biak elkartzen
		zerreBat.merge(zerreBi);
			//Luzeraren eta inprimatutakoaren arabera gauzak ondo atera direla frogatuko da
		assertEquals(8, zerreBat.size());
		
		Iterator<Pelikula> it6 = zerreBat.iterator();
		
		while (it6.hasNext()) {
			Pelikula peliHau = it6.next();
			peliHau.inprimatuIzena();
		}	
		System.out.println("\n\n\n");
		
		// 7. Lehenengo zerrenda bigarrena baino elementu gehiago dituenean
		zerreBat.zerrendaHustu();
		zerreBi.zerrendaHustu();
		
		zerreBat.add(peliBat);
		zerreBat.add(peliBi);
		zerreBat.add(peliHiru);
		zerreBat.add(peliErrepikatu);
		
		zerreBi.add(peliBat2);
		zerreBi.add(peliBi2);
		
			//Biak elkartzen
		zerreBat.merge(zerreBi);
			//Luzeraren eta inprimatutakoaren arabera gauzak ondo atera direla frogatuko da
		assertEquals(6, zerreBat.size());
		
		Iterator<Pelikula> it7 = zerreBat.iterator();
		
		while (it7.hasNext()) {
			Pelikula peliHau = it7.next();
			peliHau.inprimatuIzena();
		}
		System.out.println("\n\n\n");
		
		
		// 8. Bigarren zerrenda lehenengoa baino elementu gehiago dituenean
		zerreBat.zerrendaHustu();
		zerreBi.zerrendaHustu();
		
		zerreBat.add(peliBat);
		zerreBat.add(peliHiru);
	
		
		zerreBi.add(peliBat2);
		zerreBi.add(peliBi2);
		zerreBi.add(peliHiru2);
		zerreBi.add(peliErrepikatu);
		
		//Biak elkartzen
		zerreBat.merge(zerreBi);
			//Luzeraren eta inprimatutakoaren arabera gauzak ondo atera direla frogatuko da
		assertEquals(6, zerreBat.size());
		
		Iterator<Pelikula> it8 = zerreBat.iterator();
		
		while (it8.hasNext()) {
			Pelikula peliHau = it8.next();
			peliHau.inprimatuIzena();
		}
		System.out.println("\n\n\n");
		
		//9. Lehenengo zerrendako elementu guztiak bigarren zerrendarenak baino txikiagoak direnean
		zerreBat.zerrendaHustu();
		zerreBi.zerrendaHustu();
		
		Pelikula	peliA1	 = new Pelikula("Aaron's Destruction");
		Pelikula	peliA2	 = new Pelikula("Aaaron's Real Destruction");
		Pelikula	peliA3	 = new Pelikula("Aaaaron's, like, super tough Destruction");
		
		zerreBat.add(peliA1);
		zerreBat.add(peliA2);
		zerreBat.add(peliA3);
		
		zerreBi.add(peliBat2);
		zerreBi.add(peliBi2);
		zerreBi.add(peliHiru2);
		zerreBi.add(peliErrepikatu);
		
			//Biak elkartzen
		zerreBat.merge(zerreBi);
			//Luzeraren eta inprimatutakoaren arabera gauzak ondo atera direla frogatuko da
		assertEquals(7, zerreBat.size());
		
		Iterator<Pelikula> it9 = zerreBat.iterator();
		
		while (it9.hasNext()) {
			Pelikula peliHau = it9.next();
			peliHau.inprimatuIzena();
		}
		System.out.println("\n\n\n");
		
		//10. Bigarren zerrendako elementu guztiak lehenengo zerrendarenak baino txikiagoak direnean
		zerreBat.zerrendaHustu();
		zerreBi.zerrendaHustu();
		
		zerreBi.add(peliA1);
		zerreBi.add(peliA2);
		zerreBi.add(peliA3);
		
		zerreBat.add(peliBat2);
		zerreBat.add(peliBi2);
		zerreBat.add(peliHiru2);
		zerreBat.add(peliErrepikatu);
		
			//Biak elkartzen
		zerreBat.merge(zerreBi);
			//Luzeraren eta inprimatutakoaren arabera gauzak ondo atera direla frogatuko da
		assertEquals(7, zerreBat.size());
		
		Iterator<Pelikula> it10 = zerreBat.iterator();
		
		while (it10.hasNext()) {
			Pelikula peliHau = it10.next();
			peliHau.inprimatuIzena();
		}
		System.out.println("\n\n\n");
		
		//11. Bigarren zerrendako elementu guztiak lehenengo zerrendaren lehenengo eta azkenen artean egotea
		zerreBat.zerrendaHustu();
		zerreBi.zerrendaHustu();
		
		zerreBat.add(peliA1); 		 //Aaron's Destruction
		zerreBat.add(peli2);		 //Zombie Party 2
		
		zerreBi.add(peliBi2);		 //Bisuper
		zerreBi.add(peliHiru2);		 //Cerbero
		zerreBi.add(peliErrepikatu); //Botica de la Abuela
		
			//Biak elkartzen
		zerreBat.merge(zerreBi);
			//Luzeraren eta inprimatutakoaren arabera gauzak ondo atera direla frogatuko da
		assertEquals(5, zerreBat.size());
		
		Iterator<Pelikula> it11 = zerreBat.iterator();
		
		while (it11.hasNext()) {
			Pelikula peliHau = it11.next();
			peliHau.inprimatuIzena();
		}
		System.out.println("\n\n\n");
		
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
	public void testIterator() { //DONE

		//1. Zerrenda hutsa denean, hasNext() false eman beharko du
		OrderedDoubleLinkedList<Pelikula> zerreHutsa = new OrderedDoubleLinkedList<Pelikula>();
		Iterator<Pelikula> itrHutsa = zerreHutsa.iterator();
		assertFalse(itrHutsa.hasNext());
		
		
		//2. Zerrenda hutsa denean, next() NoSuchElementException botako du
		try{
			
			Pelikula peliEzDaAterako = itrHutsa.next();
		}
		
		catch(NoSuchElementException e){
			
			System.out.println("Salbuespena jaurti du.\n\n");
			assertTrue(true); //fail()-en kontrakoa egiteko;
		}
	
		
		//3. Zerrenda elementu bakarra daukanean, hasNext() true eman beharko du, BEHIN BAINO GEHIAGOTAN
		Iterator<Pelikula> itr1	=	zerre1.iterator();
		assertTrue(itr1.hasNext());
		assertTrue(itr1.hasNext());
		assertTrue(itr1.hasNext());
		
		
		/*4. Zerrenda elementu bakarra daukanean: hasNext() true eman beharko du lehenengo saiakeran,
		 	 next() egiterakoan elementua bueltatuko du, eta hasNext() berriz ere behin baino gehiagotan
		 	 egiterakoan, false bueltatuko du kasu guztietan. */
				//itr1 jadanik sortuta dagoela:
		assertTrue(itr1.hasNext());
		Pelikula pelikulaBakarra = itr1.next();
		assertEquals(pelikulaBakarra, peli1);
		assertFalse(itr1.hasNext());
		assertFalse(itr1.hasNext());
		
		
		
		/*5. Zerrenda bi elementu baino gehiago daukanean: hasNext() true eman beharko du lehenengo saiakeran,
	 	 next() egiterakoan elementuak bueltatuko ditu (zerrendaren aurreko ordena mantenduz), 
	 	 eta behin zerrenda guztia errekorritua izan dela, hasNext() berriz ere behin baino gehiagotan
	 	 egiterakoan, false bueltatuko du kasu guztietan. */
		
		OrderedDoubleLinkedList<Pelikula> zerreAnitz = new OrderedDoubleLinkedList<Pelikula>();
		Pelikula peliBat	=	new Pelikula("Zombie Gehiago");
		Pelikula peliBi		=	new Pelikula("Vuelve a casa, vuelve");
		Pelikula peliHiru	=	new Pelikula("Mad Max");
		Pelikula peliLau	=	new Pelikula("Fast and Furious 18");
		Pelikula peliBost	=	new Pelikula("Avatar 6");
		
		zerreAnitz.add(peliBat);
		zerreAnitz.add(peliBi);
		zerreAnitz.add(peliHiru);
		zerreAnitz.add(peliLau);
		zerreAnitz.add(peliBost);
		
		Iterator<Pelikula>	itrAnitz	= zerreAnitz.iterator();
		Pelikula			peliHau		= null;				
		
		while (itrAnitz.hasNext()) {
			
			peliHau = itrAnitz.next();
			peliHau.inprimatuIzena();
		}
		
		assertFalse(itrAnitz.hasNext());
		assertFalse(itrAnitz.hasNext());
		
		
	}



}
