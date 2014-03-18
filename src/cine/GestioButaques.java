/* =============================================================================
 * Aplicació:		Cine
 * Arxiu:			GestioButaques.java
 * Autor:			José Luis García Mañas
 * Data de creació:	22/11/2009
 * Descripció:		Conté la classe GestioButaques, que conté el vector (en
 *					realitat ArrayList) amb les butaques reservades.
 * ========================================================================== */

// Paquet
package cine;

// Import
import java.util.ArrayList;

// Classe GestioButaques
public class GestioButaques
{
	// Atribut: ArrayList amb les butaques reservades
	private ArrayList<Butaca> vButaques;
	
	// Constructor
	public GestioButaques()
	{
		vButaques = new ArrayList<Butaca>();
	}
	
	// Getter
	public ArrayList<Butaca> getVButaques()
	{
		return vButaques;
	}
	
	/* -------------------------------------------------------------------------
	 * Mètode:			afegirButaca
	 * Paràmetres:		Butaca butaca	Butaca que es vol afegir
	 * Valor de retorn: void
	 * Descripció:		Permet afegir una butaca al vector de butaques. Rep com 
	 *					a paràmetre un ojbecte de la classe Butaca i l’afegeix 
	 *					al vector. 
	 *					Si la fila i el seient de la butaca rebuda com a 
	 *					paràmetre coincideixen amb el d’una butaca que ja es 
	 *					trobi al vector (s’utilitzarà per buscar-lo el mètode
	 *					buscarButaca), el mètode no la incorporarà al vector, i 
	 *					llençarà una excepció del tipus ExcepcioButacaOcupada.
	 * ---------------------------------------------------------------------- */
	public void afegirButaca(Butaca butaca) throws ExcepcioButacaOcupada
	{
		// Comprovem si la butaca ja estava reservada i si no ho està, la
		// afegim al vector
		if(buscarButaca(butaca.getFila(), butaca.getSeient()) == -1)
		{
			vButaques.add(butaca);
		}
		else
		{
			throw new ExcepcioButacaOcupada("Butaca ocupada");
		}
	}
	
	/* -------------------------------------------------------------------------
	 * Mètode:			eliminarButaca
	 * Paràmetres:		int fila	Número de fila d'una butaca.
	 *					int seient	Número de seient d'una butaca.
	 * Valor de retorn: void
	 * Descripció:		Permet eliminar una butaca al vector de butaques. Rep 
	 *					com a paràmetre els números de fila i seient buscats i 
	 *					l’elimina del vector.
	 *					Si la fila i el seient de la butaca rebuda com a 
	 *					paràmetre coincideixen amb el d’una butaca que no es 
	 *					trobi al vector (utilitzem el mètode buscarButaca per 
	 *					buscar la butaca al vector), el mètode no la elimina i 
	 *					llença una excepció del tipus ExcepcioButacaLliure.
	 * ---------------------------------------------------------------------- */
	public void eliminarButaca(int fila, int seient) throws ExcepcioButacaLliure
	{
		// Recuperem la butaca i l'eliminem
		int posicio = buscarButaca(fila, seient);
			
		if(posicio != -1)
		{
			vButaques.remove(posicio);
		}
		else
		{
			throw new ExcepcioButacaLliure("Butaca no reservada");
		}
	}
	
	/* -------------------------------------------------------------------------
	 * Mètode:			buscarButaca
	 * Paràmetres:		int fila	Número de fila d'una butaca.
	 *					int seient	Número de seient d'una butaca.
	 * Valor de retorn: void
	 * Descripció:		Permet eliminar una butaca al vector de butaques. Rep 
	 *					com a paràmetre els números de fila i seient buscats i 
	 *					l’elimina del vector.
	 *					Si la fila i el seient de la butaca rebuda com a 
	 *					paràmetre coincideixen amb el d’una butaca que no es 
	 *					trobi al vector (utilitzem el mètode buscarButaca per 
	 *					buscar la butaca al vector), el mètode no la elimina i 
	 *					llença una excepció del tipus ExcepcioButacaLliure.
	 * ---------------------------------------------------------------------- */
	public int buscarButaca(int fila, int seient)
	{
		int posicio = -1, compt = 0;
		
		// Recorrem el vector fins que trobem la butaca o arribem al final
		while(posicio == -1 && compt < vButaques.size())
		{
			Butaca butaca = vButaques.get(compt);
			if(butaca.getFila() == fila && butaca.getSeient() == seient)
			{
				posicio = compt;
			}
			compt++;
		}
			
		return posicio;
	}
}
// =============================================================================
