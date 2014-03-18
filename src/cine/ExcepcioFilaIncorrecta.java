/* =============================================================================
 * Aplicació:		Cine
 * Arxiu:			ExcepcioFilaIncorrecta.java
 * Autor:			José Luis García Mañas
 * Data de creació:	21/10/2009
 * Descripció:		Conté la classe-excepció ExcepcioFilaIncorrecta.
 *					L'excepció es produirà quan una cadena no conté un sol
 *					caràcter.
 * ========================================================================== */

// Paquet
package cine;

// Classe
class ExcepcioFilaIncorrecta extends Exception 
{
	// Constructors
	public ExcepcioFilaIncorrecta(){}
	public ExcepcioFilaIncorrecta(String s){super(s);}
}
// =============================================================================
