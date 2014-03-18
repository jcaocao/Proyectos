/* =============================================================================
 * Aplicació:		Cine
 * Arxiu:			ExcepcioButacaOcupada.java
 * Autor:			José Luis García Mañas
 * Data de creació:	21/10/2009
 * Descripció:		Conté la classe-excepció ExcepcioButacaOcupada.
 *					L'excepció es produirà quan una cadena no conté un sol
 *					caràcter.
 * ========================================================================== */

// Paquet
package cine;

// Classe
class ExcepcioButacaOcupada extends Exception
{
	// Constructors
	public ExcepcioButacaOcupada(){}
	public ExcepcioButacaOcupada(String s){super(s);}
}
// =============================================================================
