/* =============================================================================
 * Aplicació:		Cine
 * Arxiu:			ExcepcioButacaLliure.java
 * Autor:			José Luis García Mañas
 * Data de creació:	21/10/2009
 * Descripció:		Conté la classe-excepció ExcepcioButacaLliure.
 *					L'excepció es produirà quan una cadena no conté un sol
 *					caràcter.
 * ========================================================================== */

// Paquet
package cine;

// Classe ExcepcioButacaLliure
class ExcepcioButacaLliure extends Exception
{
	// Constructors
	public ExcepcioButacaLliure(){}
	public ExcepcioButacaLliure(String s){super(s);}
}
// =============================================================================
