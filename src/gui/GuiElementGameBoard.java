/**
 * 
 */
package gui;

import java.awt.event.ActionListener;

import logic.GameBoard;
import logic.GameField;

/**
 * 
 * @author Andreas
 * @version 0.1
 *
 */

public class GuiElementGameBoard extends GuiElementBoard 
{

	/**
	 * 
	 * @param int rows
	 * @param int cols
	 * 
	 */
	
	public GuiElementGameBoard(int rows, int cols) 
	{
		super(rows, cols);
		_oLogicBoard = new GameBoard(rows, cols);
		_fields = new GuiElementField[rows][cols];
		
		ActionListener oOnClick = new onClick();
		
		for (int iY = 0; iY < rows; iY++)
		{
			for (int iX = 0; iX < cols; iX++)
			{
				GuiElementField oGuiElementField = new GuiElementGameField();
				oGuiElementField.setSize(40, 40);
				oGuiElementField.addActionListener(oOnClick);
				this._fields[iY][iX] = oGuiElementField;
			}
		}
	}

}
