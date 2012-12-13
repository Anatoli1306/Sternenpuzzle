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

public class CommandSetCross implements ICommand, Serializable
{
	GameField _oField = null;
	
	eStates oldState = null;
	
	public CommandSetCross(GameField field)
	{
		_oField = field;
		oldState = field.getState();
	}

	/**
	 * @see logic.ICommand#execute()
	 */
	
	public void execute() 
	{
		_oField.setState(eStates.CROSS, true);
	}

	/**
	 * @see logic.ICommand#execute()
	 */
	
	public void undo() 
	{
		_oField.setState(oldState, true);
	}

}
