/**
 * 
 */
package gui;

import gui.GuiElementBoard.onClick;

import java.awt.event.ActionListener;

import logic.EditorBoard;

/**
 * 
 * @author Andreas
 * @version 0.1
 *
 */

public class GuiElementEditorBoard extends GuiElementBoard 
{

	/**
	 * 
	 * @param int rows
	 * @param int cols
	 */
	public GuiElementEditorBoard(int rows, int cols) 
	{
		super(rows, cols);
		_oLogicBoard = new EditorBoard(rows, cols);
		_fields = new GuiElementField[rows][cols];
		
		ActionListener oOnClick = new onClick();
		
		for (int iY = 0; iY < rows; iY++)
		{
			for (int iX = 0; iX < cols; iX++)
			{
				GuiElementField oGuiElementField = new GuiElementEditorField();
				oGuiElementField.setSize(40, 40);
				oGuiElementField.addActionListener(oOnClick);
				this._fields[iY][iX] = oGuiElementField;
			}
		}
	}

}
