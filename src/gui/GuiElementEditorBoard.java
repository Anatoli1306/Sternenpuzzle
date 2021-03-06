/**
 * 
 */
package gui;

import gui.GuiElementField.eStates;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import logic.EditorBoard;

/**
 * Klasse definiert das Boar im Editor Modus
 * 
 * @author Andreas, Fabian, Eren, Mats, Daniel, Anatoli
 * @version 0.1
 *
 */
public class GuiElementEditorBoard extends GuiElementBoard 
{

	/**
	 * Konstruktor
	 * 
	 * @param int rows - Zeile
	 * @param int cols - Spalte
	 */
	public GuiElementEditorBoard(int rows, int cols) 
	{
		super(rows, cols);
		_oLogicBoard = new EditorBoard(rows, cols);
		_fields = new GuiElementField[rows][cols];
		
		MouseListener oOnClick = new onClick();
		KeyListener oOnKeyPressed = new onKeyPressed();
		
		for (int iY = 0; iY < rows; iY++)
		{
			for (int iX = 0; iX < cols; iX++)
			{
				GuiElementField oGuiElementField = new GuiElementEditorField(this);
				oGuiElementField.setSize(40, 40);
				oGuiElementField.addMouseListener(oOnClick);
				oGuiElementField.addKeyListener(oOnKeyPressed);
				oGuiElementField.setLogicField(_oLogicBoard.getField(iY, iX));
				oGuiElementField.setState(eStates.BLANK);
				this._fields[iY][iX] = oGuiElementField;
			}
		}
	}

	
	/**
	 * Klasse definiert das Verhalten, wenn auf eine Taste geklickt wurde
	 * 
	 * @author Andreas, Fabian, Mats, Eren, Daniel, Anatoli
	 *
	 */
	protected class onKeyPressed implements KeyListener
	{

		/**
		 * Funktion definiert alle Möglichkeiten die in ein Feld gesetzt werden können
		 */
		public void keyPressed(KeyEvent arg0) 
		{
			GuiElementField oGuiElementField = (GuiElementField)arg0.getSource();
			switch (arg0.getKeyCode())
			{
				case 97:
					oGuiElementField.setState(eStates.ARROW_SW);
					break;
					
				case 98:
					oGuiElementField.setState(eStates.ARROW_S);
					break;
					
				case 99:
					oGuiElementField.setState(eStates.ARROW_SE);
					break;
					
				case 100:
					oGuiElementField.setState(eStates.ARROW_W);
					break;
					
				case 101:
					oGuiElementField.setState(eStates.STAR);
					break;
					
				case 102:
					oGuiElementField.setState(eStates.ARROW_E);
					break;
					
				case 103:
					oGuiElementField.setState(eStates.ARROW_NW);
					break;
					
				case 104:
					oGuiElementField.setState(eStates.ARROW_N);
					break;
					
				case 105:
					oGuiElementField.setState(eStates.ARROW_NE);
					break;
			}
		}

		/**
		 * Funktion definiert das Verhalten nach loslassen einer Taste
		 */
		public void keyReleased(KeyEvent arg0) 
		{
		}

		/**
		 * Funktion definiert das Verhalten nach Tastaturkommandos
		 */
		public void keyTyped(KeyEvent arg0) 
		{
		}
		
	}
}
