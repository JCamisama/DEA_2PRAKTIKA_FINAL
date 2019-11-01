package packpraktika2;
import packpraktika1.*;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
	public void testRemove() { //DONE
		
		
		//1. Zerrenda hutsa denean
		UnorderedDoubleLinkedList<Pelikula> zerreHutsa = new UnorderedDoubleLinkedList<Pelikula>();
		assertNull(zerreHutsa.remove(peli1));
		
		//2. Elementua zerrendan dago eta elementu bakarreko zerrenda denean.
			//zerre1 peli1 bere baitan daukala jakinda
		assertEquals(peli1, zerre1.remove(peli1));
		
		
		//3. Elementu bakarreko zerrenda, ezabatu nahi dena ez egotea
		UnorderedDoubleLinkedList<Pelikula> zerre2 = new UnorderedDoubleLinkedList<Pelikula>();
		Pelikula	peli2	= new Pelikula("Zombie Party 2");
		zerre2.addToRear(peli1);
		assertNull(zerreHutsa.remove(peli2));
		
		//4. Elementu anitzeko zerrenda, bilatutakoa hasieran egotea
			//zerre3 peli3 bere lehenengo posizioan daukala jakinda
		UnorderedDoubleLinkedList<Pelikula> zerre3 = new UnorderedDoubleLinkedList<Pelikula>();
		Pelikula	peli3	= new Pelikula("Zombie Party 2");
		Pelikula	peli4	= new Pelikula("Unlasting");
		zerre3.addToFront(peli1);
		zerre3.addToFront(peli2);
		zerre3.addToFront(peli3);
		assertEquals(peli3, zerre3.remove(peli3));
		
		//5. Elementu anitzeko zerrenda, bilatutakoa erdian egotea
			//zerre3 peli2 bere erdialdeko posizioan (1) daukala jakinda (posizioak 0, 1 eta 2 direla)
		zerre3.addToFront(peli3);
		assertEquals(peli2, zerre3.find(peli2));
		
	
		
		//6. Elementu anitzeko zerrenda, bilatutakoa amaieran egotea
			//zerre3 peli1 bere azkenengo posizioan daukala jakinda
		zerre3.addToRear(peli1);
		assertEquals(peli1, zerre3.remove(peli1));
	

		
		//7. Elementu anitzeko zerrenda, bilatutakoa ez egotea
		assertNull(zerre3.remove(peli4));

	}

	@Test
	public void testFind() { //DONE
		
		//1. Zerrenda hutsa denean
		UnorderedDoubleLinkedList<Pelikula> zerreHutsa = new UnorderedDoubleLinkedList<Pelikula>();
		assertNull(zerreHutsa.find(peli1));
		
		//2. Elementu bakarreko zerrenda, bilatutakoa ez egotea
		UnorderedDoubleLinkedList<Pelikula> zerre2 = new UnorderedDoubleLinkedList<Pelikula>();
		Pelikula	peli2	= new Pelikula("Zombie Party 2");
		zerre2.addToRear(peli1);
		assertNull(zerreHutsa.find(peli2));
		
		//3. Elementu bakarreko zerrenda, bilatutakoa zerrendakoa izatea
			//zerre1 peli1 bere baitan daukala jakinda
		assertEquals(peli1, zerre1.find(peli1));
		
		//4. Elementu anitzeko zerrenda, bilatutakoa ez egotea
		UnorderedDoubleLinkedList<Pelikula> zerre3 = new UnorderedDoubleLinkedList<Pelikula>();
		Pelikula	peli3	= new Pelikula("Zombie Party 2");
		Pelikula	peli4	= new Pelikula("Unlasting");
		zerre3.addToFront(peli1);
		zerre3.addToFront(peli2);
		zerre3.addToFront(peli3);
		assertNull(zerre3.find(peli4));
		
		//5. Elementu anitzeko zerrenda, bilatutakoa hasieran egotea
			//zerre3 peli3 bere lehenengo posizioan daukala jakinda
		assertEquals(peli3, zerre3.find(peli3));
		assertEquals(peli3, zerre3.first());
		
		//6. Elementu anitzeko zerrenda, bilatutakoa amaieran egotea
			//zerre3 peli1 bere azkenengo posizioan daukala jakinda
		assertEquals(peli1, zerre3.find(peli1));
		assertEquals(peli1, zerre3.last());
		
		//7. Elementu anitzeko zerrenda, bilatutakoa erdian egotea
			//zerre3 peli2 bere erdialdeko posizioan (1) daukala jakinda (posizioak 0, 1 eta 2 direla)
		assertEquals(peli2, zerre3.find(peli2));
		assertEquals(1, zerre3.posizioaZerrendan(peli2));
	}

	@Test
	public void testAddToFront() { //DONE
		
		//Zerrenda hutsa denean
		UnorderedDoubleLinkedList<Pelikula> zerreHutsa = new UnorderedDoubleLinkedList<Pelikula>();
		zerreHutsa.addToFront(peli1);
		assertEquals(zerre1.size(), 1);	
		
		
		//Elementu bakarrerko zerrenda denean	
		Pelikula	peli2	= new Pelikula("Zombie Party 2");
		zerre1.addToFront(peli2);
		assertEquals(zerre1.size(), 2);		
				
		//Elementu bat edo gehiagoko zerrenda denean
		UnorderedDoubleLinkedList<Pelikula> zerre2 = new UnorderedDoubleLinkedList<Pelikula>();
		Pelikula	peli3	= new Pelikula("Zombie Party 2");
		zerre2.addToFront(peli1);
		zerre2.addToFront(peli2);
		zerre2.addToFront(peli3);		
		assertEquals(zerre2.size(), 3);
		
	}

	@Test
	public void testAddToRear() { //DONE
		
		//Zerrenda hutsa denean
		UnorderedDoubleLinkedList<Pelikula> zerreHutsa = new UnorderedDoubleLinkedList<Pelikula>();
		zerreHutsa.addToRear(peli1);
		assertEquals(zerre1.size(), 1);	
		
		
		//Elementu bakarrerko zerrenda denean	
		Pelikula	peli2	= new Pelikula("Zombie Party 2");
		zerre1.addToRear(peli2);
		assertEquals(zerre1.size(), 2);		
				
		//Elementu bat edo gehiako zerrenda denean
		UnorderedDoubleLinkedList<Pelikula> zerre2 = new UnorderedDoubleLinkedList<Pelikula>();
		Pelikula peli3		= new Pelikula("Zombie Party 3");
		Pelikula peliLau	=	new Pelikula("Fast and Furious 18");
		Pelikula peliBost	=	new Pelikula("Avatar 6");
		zerre2.addToRear(peli1);
		zerre2.addToRear(peli2);
		zerre2.addToRear(peli3);
		zerre2.addToRear(peliLau);
		zerre2.addToRear(peliBost);
		
		assertEquals(peli1, zerre2.find(peli1));
		assertEquals(peli2, zerre2.find(peli2));
		assertEquals(peli3, zerre2.find(peli3));
		assertEquals(peliLau, zerre2.find(peliLau));
		assertEquals(peliBost, zerre2.find(peliBost));
		assertEquals(zerre2.size(), 5);
		
		
	}

	@Test
	public void testAddAfter() { //DONE
		
		
		//1. Erreferentziazkoa zerrendan ez badago: azkenengo posizioan gehitu
			//Zerrenda bat
		UnorderedDoubleLinkedList<Pelikula> zerreBat = new UnorderedDoubleLinkedList<Pelikula>();
		Pelikula	peliBat	 = new Pelikula("Acha");
		Pelikula	peliBi	 = new Pelikula("Bazuka");
		Pelikula	peliHiru = new Pelikula("Casiopea");
		zerreBat.addToRear(peliBat);
		zerreBat.addToRear(peliBi);
		zerreBat.addToRear(peliHiru);
		
			//Beste erreferentziazko pelikula eta sartuko den pelikula
		Pelikula	errefe		= new Pelikula("Cangas");
		Pelikula	sartu		= new Pelikula("Sancho");
		
		zerreBat.addAfter(sartu, errefe);
		assertNull(zerreBat.find(sartu));
		
		//2. Erreferentziazkoa zerrendan dago: azkenengo posizioan gehitu
			//peliHiru zerreBat-en azkenengo pelikula dela jakinda
		zerreBat.addAfter(sartu, peliHiru);
		assertEquals(sartu, zerreBat.last());
		assertEquals(4, zerreBat.size());
		
		
		//3. Erreferentziazkoa zerrendan dago.
			//peliBat zerreBat-en azkenengo pelikula dela jakinda
		Pelikula	sartu2		= new Pelikula("Sancho, El Regreso");
		zerreBat.addAfter(sartu2, peliBat);
		assertEquals(sartu2, zerreBat.find(sartu2));
		assertEquals(5, zerreBat.size());
		assertEquals(1, zerreBat.posizioaZerrendan(sartu2)); //Non posizioak 0,1,2,3,4 diren, eta luzera = 5
		
		//4. Zerrenda elementu bakarrekoa izatea eta elementu hori erreferentziazkoa izatea
			//peli1 zerre1-en pelikula bakarra dela jakinda
		zerre1.addAfter(sartu, peli1);
		assertEquals(2, zerre1.size());	
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
	public void testContains() { //DONE
		
	
		//1. Zerrenda hutsa izatea.
		UnorderedDoubleLinkedList<Pelikula> zerreHutsa = new UnorderedDoubleLinkedList<Pelikula>();
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
		
		UnorderedDoubleLinkedList<Pelikula> zerreHutsa = new UnorderedDoubleLinkedList<Pelikula>();
		
		//Zerrenda hutsa denean
		assertTrue(zerreHutsa.isEmpty());
		
		//Zerrenda ez-hutsa denean (peli1 bere baitan dago)
		assertFalse(zerre1.isEmpty());
		
	}

	@Test
	public void testSize(){ //DONE
		
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
	public void testIterator() { //DONE

		//1. Zerrenda hutsa denean, hasNext() false eman beharko du
		UnorderedDoubleLinkedList<Pelikula> zerreHutsa = new UnorderedDoubleLinkedList<Pelikula>();
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
		
		UnorderedDoubleLinkedList<Pelikula> zerreAnitz = new UnorderedDoubleLinkedList<Pelikula>();
		Pelikula peliBat	=	new Pelikula("Zombie Gehiago");
		Pelikula peliBi		=	new Pelikula("Vuelve a casa, vuelve");
		Pelikula peliHiru	=	new Pelikula("Mad Max");
		Pelikula peliLau	=	new Pelikula("Fast and Furious 18");
		Pelikula peliBost	=	new Pelikula("Avatar 6");
		
		zerreAnitz.addToRear(peliBat);
		zerreAnitz.addToRear(peliBi);
		zerreAnitz.addToRear(peliHiru);
		zerreAnitz.addToRear(peliLau);
		zerreAnitz.addToRear(peliBost);
		
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
