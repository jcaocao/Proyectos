/* =============================================================================
 * Aplicació:		Cine
 * Arxiu:			Principal.java
 * Autor:			José Luis García Mañas
 * Data de creació:	22/11/2009
 * Descripció:		Conté la classe Principal, amb el mètode Main.
 * ========================================================================== */

// Paquet
package cine;

// Classe Principal
public class Principal
{
	// Mètode main
	public static void main(String[] args)
	{
		try
		{
			Cine c = new Cine();
			c.iniciar();
		}
		catch(Exception e){}
	}
}
// =============================================================================