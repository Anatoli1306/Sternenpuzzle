/**
 * 
 */
package logic;

/**
 * Die CheckGameBoard Klasse pr�ft das Game Board nach der l�sbarkeit.
 * 
 * @author Fabian, Mats, Eren, Daniel, Andreas, Anatoli
 * @version 0.1
 * 
 */
public class CheckGameBoard extends CheckBoard 
{	
	/**
	 * Konstruktor f�r die CheckGameBoard - Klasse
	 * Als parameter wird hier das Game Board �bergeben
	 * @param Board - Hier wird das Game Board �bergeben
	 */
	public CheckGameBoard(Board oBoard)
	{
		setBoard(oBoard);
	}
	
	/**
	 * Pr�ft das Game Board nach fehlern
	 * @return boolean - Hier wird ein True zur�ckgegeben
	 */
	public boolean check()
	{
		return true;
	}
}
