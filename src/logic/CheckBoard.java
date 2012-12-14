/**
 * 
 */
package logic;

import gui.GuiElementField.eStates;

/**
 * Die Klasse CheckBoard pr�ft ob das Board den Regeln entspricht
 * Durch set und get Methoden k�nnen die Daten der CheckBoard Klasse gesetzt und ausgegeben werden.
 * @author Fabian, Mats, Eren, Daniel, Andreas, Anatoli
 * @version 0.1
 * 
 */
abstract public class CheckBoard 
{
	/**
	 * Gibt an ob das Board ein Spiel Board oder ein Editor Board ist
	 * @param Board - Hier wird das Board �bergeben
	 * @return CheckGameBoard - Es wird ein Spiel Board zur�ckgegeben
	 * @return CheckEditorBoard - Es wird ein Editor Board zur�ckgegeben
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
	 * Setzt das Board f�r die Klasse
	 * @param Board - Das Board wird hier angegeben
	 */
	public void setBoard(Board oBoard)
	{
		_oBoard = oBoard;
	}
	
	/**
	 * Die Funktion check() wird hier an die Unterklasse vererbt
	 * Pr�ft das Board nach Fehlern
	 */
	abstract public boolean check();
}
