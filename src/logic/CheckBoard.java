/**
 * 
 */
package logic;

import gui.GuiElementField.eStates;

/**
 * @author Andreas
 *
 */
abstract public class CheckBoard 
{
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
	
	protected Board _oBoard = null;
	
	public void setBoard(Board oBoard)
	{
		_oBoard = oBoard;
	}
	
	abstract public boolean check();
}
