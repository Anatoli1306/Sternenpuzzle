/**
 * 
 */
package logic;

import java.io.Serializable;

import gui.GuiElementField.eStates;

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
	private eStates _state = eStates.BLANK; 
	
	/**
	 * 
	 */
	private Board _oBoard = null;
	
	/**
	 * @param oBoard
	 */
	public Field(Board oBoard)
	{
		this._oBoard = oBoard;
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
	 * 
	 * @return Board
	 * 
	 */
	
	public Board getBoard()
	{
		return _oBoard;
	}
}
