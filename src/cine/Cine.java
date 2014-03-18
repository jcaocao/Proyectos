/* =============================================================================
 * Aplicació:		Cine
 * Arxiu:			Principal.java
 * Autor:			José Luis García Mañas
 * Data de creació:	22/11/2009
 * Descripció:		Conté la classe Cine, amb el menú principal i les opcions de
 *					menú, o sigui, totes les funcionalitats amb les que
 *					interactuarà l'usuari (menús, missatges d'error, dades
 *					demanades a l'usuaris, etc).
 * ========================================================================== */

// Paquet
package cine;

// Imports
import java.io.IOException;
import java.util.ArrayList;

// Classe Cine
class Cine
{
	// Atributs
	private GestioButaques butaques;
	private int			   numFiles;
	private int			   numSeients;
	
	/* -------------------------------------------------------------------------
	 * Constructor
	 * Aquest constructor llença una excepció de la classe Exception en cas que
	 * dades inicials siguin incorrectes. Si es produeix aquest error, 
	 * l'aplicació no hauria de continuar.
	 * ---------------------------------------------------------------------- */
	public Cine() throws Exception
	{
		// Creem el vector de Butaques
		butaques = new GestioButaques();

		try
		{
			// Demanem a l'usuari les dades inicials
			demanarDadesInicials();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			throw e;
		}
	}
	
	/* -------------------------------------------------------------------------
	 * Mètode:			iniciar
	 * Paràmetres:		cap
	 * Valor de retorn: cap
	 * Descripció:		Inicia l’aplicació. Cridarà al mètode menu i en funció 
	 *					del número retornat per aquest, cridarà al mètode 
	 *					corresponent.
	 * ---------------------------------------------------------------------- */
	public void iniciar()
	{
		// Declaració de variables
		int opcio = -1;
		
		do
		{
			// Demanem l'opció a l'usuari
			opcio = menu();
			switch(opcio)
			{
				// Anem a l'opció escollida
				case 1:
					opcioMostrarButaques();
					break;
				case 2:
					opcioMostrarButaquesPersona();
					break;
				case 3:
					opcioReservarButaca();
					break;
				case 4:
					opcioAnularReserva();
					break;
				case 5:
					opcioAnularReservaPerPersona();
					break;
				case 0:
					break;
				default:
					System.out.println("Opció incorrecta!");
					break;
			}			
		// Si l'usuari prem 0, sortim
		}while(opcio != 0);
	}

	/* -------------------------------------------------------------------------
	 * Mètode:			menu
	 * Paràmetres:		cap
	 * Valor de retorn: int
	 * Descripció:		Mostra les opcions del menú principal a l'usuari i li 
	 *					demana el número de l’ opció escollida, que és el que 
	 *					retorna.
	 * ---------------------------------------------------------------------- */
	private int menu()
	{
		int opcio = -1;
		
		try
		{
			// Mostrem les opcions de menú
			System.out.println("\n\nMENÚ PRINCIPAL\n");
			System.out.println("1. Mostrar totes les butaques reservades");
			System.out.println("2. Mostrar les butaques reservades per una persona");
			System.out.println("3. Reservar una butaca");
			System.out.println("4. Anular la reserva d'una butaca");
			System.out.println("5. Anular totes les reserves d'una persona");
			System.out.println("0. Sortir\n");

			// Demanem a l'usuari que introdueixi la seva opció
			System.out.print("Opció: ");
			opcio = Teclat.llegirTeclatInt();
			
			System.out.println("\n");
		}
		catch(Exception e){}
		
		return opcio;
	}
	
	/* -------------------------------------------------------------------------
	 * Mètode:			opcioMostrarButaques
	 * Paràmetres:		cap
	 * Valor de retorn: cap
	 * Descripció:		Mostra totes les butaques reservades (fila, seient, 
	 *					persona que ha fet la reserva).
	 * ---------------------------------------------------------------------- */
	private void opcioMostrarButaques()
	{
		System.out.println("BUTAQUES RESERVADES");
		
		// Recuperem el vector de butaques
		ArrayList<Butaca> vButaques = butaques.getVButaques();

		// Mostrem totes les butaques reservades
		for(int i = 0; i < vButaques.size(); i++)
		{
			Butaca butaca = vButaques.get(i);
			System.out.println(butaca.toString());
		}
		System.out.println("=====================================");
	}
	
	/* -------------------------------------------------------------------------
	 * Mètode:			opcioMostrarButaquesPersona
	 * Paràmetres:		cap
	 * Valor de retorn: cap
	 * Descripció:		Demana a l’ usuari el nom de la persona que ha fet la 
	 *					reserva (cridant al mètode introduirPersona) i mostra 
	 *					totes les butaques reservades per aquesta persona.
	 * ---------------------------------------------------------------------- */
	private void opcioMostrarButaquesPersona()
	{
		System.out.println("BUTAQUES RESERVADES PER UNA PERSONA");

		try
		{
			// Demanem a l'usuari el nom de la persona que ha fet la reserva
			String nomPersona = introduirPersona();

			// Recuperem el vector de butaques
			ArrayList<Butaca> vButaques = butaques.getVButaques();
		
			// Mostrem totes les butaques reservades per aquesta persona
			for(int i = 0; i < vButaques.size(); i++)
			{
				Butaca butaca = vButaques.get(i);
				if(butaca.getPersona().equals(nomPersona))
				{
					System.out.println(butaca.toString());
				}
			}				
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		System.out.println("=====================================");
	}
	
	/* -------------------------------------------------------------------------
	 * Mètode:			opcioReservarButaca
	 * Paràmetres:		cap
	 * Valor de retorn: cap
	 * Descripció:		Demana a l’us uari un número de fila (cridant al mètode 
	 *					introduirFila), un número de seient (cridant al mètode 
	 *					introduirSeient) i el nom de la persona que ha fet la 
	 *					reserva (cridant al mètode introduirPersona) i reserva 
	 *					la butaca (afegint la butaca al vector de butaques).
	 * ---------------------------------------------------------------------- */
	private void opcioReservarButaca()
	{
		System.out.println("RESERVA D'UNA BUTACA");

		try
		{
			// Demanem a l'usuari les dades de la butaca
			int	   fila		  = introduirFila();
			int	   seient	  = introduirSeient();
			String nomPersona = introduirPersona();
			
			// Creem l'objecte i l'afegim al vector
			Butaca butaca = new Butaca(fila, seient, nomPersona);
			butaques.afegirButaca(butaca);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		System.out.println("=====================================");
	}
	
	/* -------------------------------------------------------------------------
	 * Mètode:			opcioAnularReserva
	 * Paràmetres:		cap
	 * Valor de retorn: cap
	 * Descripció:		Demana a l’usuari un número de fila (cridant al mètode 
	 *					introduirFila) i un número de seient (cridant al mètode 
	 *					introduirSeient) i elimina la reserva de la butaca 
	 *					determinada per la fila i el seient introduïts.
	 * ---------------------------------------------------------------------- */
	private void opcioAnularReserva()
	{
		System.out.println("ANULACIÓ D'UNA RESERVA");
		
		try
		{
			// Demanem la fila i seient corresponent a la butaca
			int fila   = introduirFila();
			int seient = introduirSeient();
			
			// L'eliminem del vector
			butaques.eliminarButaca(fila, seient);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());			
		}
		System.out.println("=====================================");
	}
	
	/* -------------------------------------------------------------------------
	 * Mètode:			opcioAnularReservaPerPersona
	 * Paràmetres:		cap
	 * Valor de retorn: cap
	 * Descripció:		Demana a l’usuari el nom de la persona (cridant al 
	 *					mètode introduirPersona) i elimina les butaques 
	 *					reservades per la persona introduïda.
	 * ---------------------------------------------------------------------- */
	private void opcioAnularReservaPerPersona()
	{
		System.out.println("ANULACIÓ DE RESERVES D'UNA PERSONA");

		try
		{
			// Recuperem el vector amb totes les butaques resrvades
			ArrayList<Butaca> vButaques = butaques.getVButaques();
			
			// Demanem el nom de la persona
			String nomPersona = introduirPersona();

			// Revisem el vector i eliminem totes les butaques que pertanyen
			// a la persona
			int i = 0;
			do
			{
				Butaca butaca = vButaques.get(i);
				
				// Si la butaca pertany a la persona, l'eliminem del vector
				if(butaca.getPersona().equals(nomPersona))
				{
					butaques.eliminarButaca(butaca.getFila(), butaca.getSeient());
				}
				else
				{
					i++;
				}
			}while(i < vButaques.size());			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());			
		}
		System.out.println("=====================================");
	}
	
	/* -------------------------------------------------------------------------
	 * Mètode:			demanarDadesInicials
	 * Paràmetres:		cap
	 * Valor de retorn: cap
	 * Descripció:		Demana a l’ usuari el número de files i de seients 
	 *					totals i els guarda en els atributs corresponents. Si 
	 *					els números introduïts no són correctes (no son enters 
	 *					més grans que 0). 
	 *					Si el número de files o seients introduït no és numèric 
	 *					o és menor que 1, es llençarà l’excepció corresponent.
	 * ---------------------------------------------------------------------- */
	private void demanarDadesInicials() throws ExcepcioFilaIncorrecta, 
											  ExcepcioSeientIncorrecte
	{
		try
		{
			// Demanem el número de files i comprovem si és correcte
			System.out.print("Número de files totals: ");
			int files = Teclat.llegirTeclatInt();
			if(files > 0)
			{
				numFiles = files;
			}
			else
			{
				throw new Exception();
			}
		}
		catch(Exception e)
		{
			throw new ExcepcioFilaIncorrecta("El número de files és incorrecte");
		}
		
		try
		{
			// Demanem el número de seients i comprovem si és correcte
			System.out.print("Número de seients totals: ");
			int seients = Teclat.llegirTeclatInt();
			if(seients > 0)
			{
				numSeients = seients;
			}
			else
			{
				throw new Exception();
			}
		}
		catch(Exception e)
		{
			throw new ExcepcioSeientIncorrecte("El número de seient és incorrecte");
		}
	}
	
	/* -------------------------------------------------------------------------
	 * Mètode:			introduirPersona
	 * Paràmetres:		cap
	 * Valor de retorn: String	El nom de la persona introduïda.
	 * Descripció:		Crida al mètode llegirTeclatString de la classe Teclat 
	 *					i, si el nom introduït és un nom correcte (no conté 
	 *					números) el retorna.
	 *					Si conté números, llença una excepció del tipus 
	 *					ExcepcioNomPersonaIncorrecte.
	 * ---------------------------------------------------------------------- */
	private String introduirPersona() throws ExcepcioNomPersonaIncorrecte, 
											 IOException
	{
		String nomPersona = "";
		
		try
		{
			// Demanem el nom de la persona i comprovem si és un nom correcte
			System.out.print("Nom de la persona: ");
			nomPersona = Teclat.llegirTeclatString();
			if(cadenaConteNumeros(nomPersona))
			{
				throw new ExcepcioNomPersonaIncorrecte("Nom de persona "
						+ "incorrecte");
			}
		}
		catch(IOException e){}
		
		return nomPersona;
	}
	
	/* -------------------------------------------------------------------------
	 * Mètode:			introduirFila
	 * Paràmetres:		cap
	 * Valor de retorn: int		El número de fila introduït per l'usuari
	 * Descripció:		Crida al mètode llegirTeclatInt de la classe Teclat i, 
	 *					si el número està entre 1 i el número de files totals, 
	 *					el retorna. 
	 *					Si no, retorna una excepció del tipus 
	 *					ExcepcioFilaIncorrecta.
	 * ---------------------------------------------------------------------- */
	private int introduirFila() throws ExcepcioFilaIncorrecta
	{
		int fila = -1;
		
		try
		{
			// Demanem el número de fila i comprovem si és correcte
			System.out.print("Número de fila: ");
			fila = Teclat.llegirTeclatInt();
			if(fila < 1 || fila > numFiles)
			{
				throw new ExcepcioFilaIncorrecta("Fila incorrecta");
			}
		}
		catch(IOException e){}
		catch(NumberFormatException e)
		{
			throw new NumberFormatException("La dada introduïda no és un número");
		}
		
		return fila;
	}

	/* -------------------------------------------------------------------------
	 * Mètode:			introduirSeient
	 * Paràmetres:		cap
	 * Valor de retorn: int		El número de seient introduït per l'usuari
	 * Descripció:		Crida al mètode llegirTeclatInt de la classe Teclat i, 
	 *					si el número està entre 1 i el número de seients totals, 
	 *					el retorna. 
	 *					Si no, retorna una excepció del tipus 
	 *					ExcepcioSeientIncorrecte.
	 * ---------------------------------------------------------------------- */
	private int introduirSeient() throws ExcepcioSeientIncorrecte
	{
		int seient = -1;
		
		try
		{
			// Demanem el número de seient i comprovem si és correcte
			System.out.print("Número de seient: ");
			seient = Teclat.llegirTeclatInt();
			if(seient < 1 || seient > numSeients)
			{
				throw new ExcepcioSeientIncorrecte("Seient incorrecte");
			}
		}
		catch(IOException e){}
		catch(NumberFormatException e)
		{
			throw new NumberFormatException("La dada introduïda no és un número");
		}
		
		return seient;
	}

	/* -------------------------------------------------------------------------
	 * Mètode:			cadenaConteNumeros
	 * Paràmetres:		String persona	El nom d'una persona
	 * Valor de retorn: boolean	 True si el nom és correcte; false si no.
	 * Descripció:		Comprova si el nom d'una persona és correcte 
	 *					(es considerarà correcte si no conté números).
	 * ---------------------------------------------------------------------- */
	private boolean cadenaConteNumeros(String persona)
	{
		boolean retorn = false;
		
		int i = 0;
		do
		{
			char caracter = persona.charAt(i);
			if(caracter >= '0' && caracter <= '9')
			{
				retorn = true;
			}
			else
			{
				i++;
			}
		}while(retorn == false && i < persona.length());
		
		return retorn;
	}

}
// =============================================================================