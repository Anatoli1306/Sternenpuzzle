/**
 * 
 */
package logic;

import gui.GuiElementField.eStates;

/**
 * 
 * @author Andreas
 * @version 0.1
 * 
 */

public class Field 
{
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
