/* =============================================================================
 * Aplicació:		Cine
 * Arxiu:			ExcepcioSeientIncorrecte.java
 * Autor:			José Luis García Mañas
 * Data de creació:	21/10/2009
 * Descripció:		Conté la classe-excepció ExcepcioSeientIncorrecte.
 *					L'excepció es produirà quan una cadena no conté un sol
 *					caràcter.
 * ========================================================================== */

// Paquet
package cine;

// Classe
class ExcepcioSeientIncorrecte extends Exception
{
	// Constructors
	public ExcepcioSeientIncorrecte(){}	
	public ExcepcioSeientIncorrecte(String s){super(s);}	
}
// =============================================================================
