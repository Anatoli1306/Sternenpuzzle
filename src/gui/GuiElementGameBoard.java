/**
 * 
 */
package gui;

import gui.GuiElementField.eStates;

import java.awt.event.MouseListener;

import logic.GameBoard;

/**
 * Klasse definiert das Board im Spielmodus
 * 
 * @author Andreas, Fabian, Eren, Mats, Anatoli, Daniel
 * @version 0.1
 *
 */

public class GuiElementGameBoard extends GuiElementBoard 
{

	/**
	 * Konstruktor
	 * 
	 * @param int rows - Zeile
	 * @param int cols - Spalte
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
				oGuiElementField.setState(eStates.BLANK, 1);
				this._fields[iY][iX] = oGuiElementField;
			}
		}
	}
	
	/**
	 * Funktion ermittelt ein Feld aus dem Spielmodus-Board
	 * 
	 * @param int posY - Koordniate Y
	 * @param int posX - Koordinate X
	 * @return GuiElementField - Gibt ein Feld im Board zurück
	 * 
	 */
	public GuiElementGameField getField(int posY, int posX)
	{
		return (GuiElementGameField)super.getField(posY, posX);
	}

}
