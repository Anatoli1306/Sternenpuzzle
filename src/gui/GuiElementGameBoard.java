/**
 * 
 */
package gui;

import gui.GuiElementField.eStates;

import java.awt.event.MouseListener;

import logic.GameBoard;

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
		
		MouseListener oOnClick = new onClick();
		
		for (int iY = 0; iY < rows; iY++)
		{
			for (int iX = 0; iX < cols; iX++)
			{
				GuiElementField oGuiElementField = new GuiElementGameField(this);
				oGuiElementField.setSize(40, 40);
				oGuiElementField.addMouseListener(oOnClick);
				oGuiElementField.setLogicField(_oLogicBoard.getField(iY, iX));
				oGuiElementField.setState(eStates.BLANK);
				this._fields[iY][iX] = oGuiElementField;
			}
		}
	}
	
	/**
	 * 
	 * @param int posY
	 * @param int posX
	 * @return GuiElementField
	 * 
	 */
	public GuiElementGameField getField(int posY, int posX)
	{
		return (GuiElementGameField)super.getField(posY, posX);
	}

}
