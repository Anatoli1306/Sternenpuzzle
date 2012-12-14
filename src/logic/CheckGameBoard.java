/**
 * 
 */
package logic;

/**
 * Die CheckGameBoard Klasse prüft das Game Board nach der lösbarkeit.
 * 
 * @author Fabian, Mats, Eren, Daniel, Andreas, Anatoli
 * @version 0.1
 * 
 */
public class CheckGameBoard extends CheckBoard 
{	
	/**
	 * Konstruktor für die CheckGameBoard - Klasse
	 * Als parameter wird hier das Game Board übergeben
	 * @param Board - Hier wird das Game Board übergeben
	 */
	public CheckGameBoard(Board oBoard)
	{
		setBoard(oBoard);
	}
	
	/**
	 * Prüft das Game Board nach fehlern
	 * @return boolean - Hier wird ein True zurückgegeben
	 */
	public boolean check()
	{
		return true;
	}
}
