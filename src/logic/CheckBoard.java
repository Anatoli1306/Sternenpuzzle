/**
 * 
 */
package logic;

import gui.GuiElementField.eStates;

/**
 * Die Klasse CheckBoard prüft ob das Board den Regeln entspricht
 * Durch set und get Methoden können die Daten der CheckBoard Klasse gesetzt und ausgegeben werden.
 * @author Fabian, Mats, Eren, Daniel, Andreas, Anatoli
 * @version 0.1
 * 
 */
abstract public class CheckBoard 
{
	/**
	 * Gibt an ob das Board ein Spiel Board oder ein Editor Board ist
	 * @param Board - Hier wird das Board übergeben
	 * @return CheckGameBoard - Es wird ein Spiel Board zurückgegeben
	 * @return CheckEditorBoard - Es wird ein Editor Board zurückgegeben
	 */
	public static CheckBoard getInstance(Board oBoard)
	{
		if (oBoard instanceof GameBoard)
		{
			return new CheckGameBoard(oBoard);
		}
		else if (oBoard instanceof EditorBoard)
		{
			return new CheckEditorBoard(oBoard);
		}

		return null;
	}
	
	/**
	 * Derkleration der Klassen Variabel Board
	 */
	protected Board _oBoard = null;
	
	/**
	 * Setzt das Board für die Klasse
	 * @param Board - Das Board wird hier angegeben
	 */
	public void setBoard(Board oBoard)
	{
		_oBoard = oBoard;
	}
	
	/**
	 * Die Funktion check() wird hier an die Unterklasse vererbt
	 * Prüft das Board nach Fehlern
	 */
	abstract public boolean check();
}
