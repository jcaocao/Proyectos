/* =============================================================================
 * Aplicació:		Butaca
 * Arxiu:			Principal.java
 * Autor:			José Luis García Mañas
 * Data de creació:	22/11/2009
 * Descripció:		Conté la classe Butaca, amb les dades d'una butaca reservada
 *					(fila, seient i persona que ha fet la reserva).
 * ========================================================================== */

// paquet
package cine;

// Classe Butaca
public class Butaca
{
	// Atributs
	private int	   fila;
	private int	   seient;
	private String persona;
	
	public Butaca(int fila, int seient, String persona)
	{
		this.fila	 = fila;
		this.seient	 = seient;
		this.persona = persona;
	}
	
	// Getters
	public int	  getFila()	   {return fila;}
	public int	  getSeient()  {return seient;}
	public String getPersona() {return persona;} 
	
	// equals
	public boolean equals(Butaca altraButaca)
	{
		return (fila == altraButaca.fila && seient == altraButaca.seient);
	}
	
	// toString
	@Override
	public String toString()
	{
		return "Fila: " + fila + ", Seient: " + seient + ", Persona: " + persona;
	}
}
// =============================================================================