/**
 * 
 */
package logic;

import java.io.Serializable;

import gui.GuiElementField.eStates;
import gui.PlayFrame;

/**
 * 
 * @author Andreas
 * @version 0.1
 * 
 */

public class Field implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	protected eStates _state = eStates.BLANK; 
	
	/**
	 * 
	 */
	protected Board _oBoard = null;
	
	
	protected int _xPos = 0;
	
	protected int _yPos = 0;
	
	/**
	 * @param oBoard
	 */
	public Field(Board oBoard, int xPos, int yPos)
	{
		this._oBoard = oBoard;
		_xPos = xPos;
		_yPos = yPos;
	}
	
	/**
	 * @return the _xPos
	 */
	public int getXPos() {
		return _xPos;
	}

	/**
	 * @return the _yPos
	 */
	public int getYPos() {
		return _yPos;
	}

	/**
	 * @return eStates
	 */
	public eStates getState() 
	{
		return _state;
	}

	/**
	 * @param eStates _state
	 */
	public void setState(eStates state) 
	{
		this._state = state;
	}
	
	/**
	 * @param eStates _state
	 */
	public void setState(eStates state, int aas) 
	{
		this._state = state;
	}
	
	/**
	 * @param eStates _state
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
	 * 
	 * @return Board
	 * 
	 */
	
	public Board getBoard()
	{
		return _oBoard;
	}
}
