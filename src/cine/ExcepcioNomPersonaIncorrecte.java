/* =============================================================================
 * Aplicació:		Cine
 * Arxiu:			ExcepcioNomPersonaIncorrecte.java
 * Autor:			José Luis García Mañas
 * Data de creació:	21/10/2009
 * Descripció:		Conté la classe-excepció ExcepcioNomPersonaIncorrecte.
 *					L'excepció es produirà quan una cadena no conté un sol
 *					caràcter.
 * ========================================================================== */

// Paquet
package cine;

// Classe
class ExcepcioNomPersonaIncorrecte extends Exception
{
	// Constructors
	public ExcepcioNomPersonaIncorrecte(){}
	public ExcepcioNomPersonaIncorrecte(String s){super(s);}	
}
// =============================================================================
