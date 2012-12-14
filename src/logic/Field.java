/**
 * 
 */
package logic;

import java.io.Serializable;

import gui.GuiElementField.eStates;
import gui.PlayFrame;

/**
 * Die Field Klasse dient dazu, um ein Feld zu erstellen.
 * 
 * @author Fabian, Mats, Eren, Daniel, Andreas, Anatoli
 * @version 0.1
 * 
 */

public class Field implements Serializable
{
	/**
	 * Dekleration der Variabeln f�r die Klasse
	 */
	private static final long serialVersionUID = 1L;
	protected eStates _state = eStates.BLANK; 
	protected Board _oBoard = null;	
	protected int _xPos = 0;	
	protected int _yPos = 0;
	
	/**
	 * Konstruktor f�r die Field - Klasse
	 * Als parameter wird hier das Board, die Position auf der X Achse und die Position auf der Y Achse angegeben
	 * @param board - Hier wird das Editor Board angegeben
	 * @param height - Hier wird die Position auf der X Achse angegeben
	 * @param width - Hier wird die Position auf der Y Achse angegeben
	 */
	public Field(Board oBoard, int xPos, int yPos)
	{
		this._oBoard = oBoard;
		_xPos = xPos;
		_yPos = yPos;
	}
	
	/**
	 * Gibt die Position des Feldes auf der X Achse an
	 * @return _xPos - Gibt die Position des Feldes auf der X Achse an
	 */
	public int getXPos() {
		return _xPos;
	}

	/**
	 * Gibt die Position des Feldes auf der Y Achse an
	 * @return _xPos - Gibt die Position des Feldes auf der Y Achse an
	 */
	public int getYPos() {
		return _yPos;
	}

	/**
	 * Gibt den Status des Feldes an
	 * @return _state - Gibt die Status zur�ck
	 */
	public eStates getState() 
	{
		return _state;
	}

	/**
	 * Setzt den Status des Feldes an
	 * @param eStates - Setzt den �bergabenen Status
	 */
	public void setState(eStates state) 
	{
		this._state = state;
	}
	
	/**
	 * Setzt den Status des Feldes an
	 * @param eStates - Setzt den �bergabenen Status
	 */
	
	public void setState(eStates state, int aas) 
	{
		this._state = state;
	}
	
	/**
	 * Setzt den Status f�r die GuiFelder
	 * @param eStates - Setzt den �bergabenen Status
	 * @aram updateGuiField - Wenn der boolean True ist, wird der Status f�r die GuiFelder gesetzt
	 */
	public void setState(eStates state, boolean updateGuiField) 
	{
		this._state = state;
		
		if (updateGuiField)
		{
			PlayFrame._oPlayFrame._oBoard.getField(_yPos, _xPos).setState(state, 1);
			PlayFrame._oPlayFrame.refreshWindow();
		}
		
	}
	
	/**
	 * Gibt das aktuelle Board zur�ck
	 * @return _oBoard - Gibt das Board zur�ck
	 */	
	public Board getBoard()
	{
		return _oBoard;
	}
}
