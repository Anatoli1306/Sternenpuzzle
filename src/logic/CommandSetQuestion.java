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

public class CommandSetQuestion implements ICommand 
{
	GameField _oField = null;
	
	eStates oldState = null;

	public CommandSetQuestion(GameField field)
	{
		_oField = field;
		oldState = field.getState();
	}
	
	/**
	 * @see logic.ICommand#execute()
	 */
	
	public void execute() 
	{
		_oField.setState(eStates.QUESTION, true);
	}

	/**
	 * @see logic.ICommand#execute()
	 */
	
	public void undo() 
	{
		_oField.setState(oldState, true);
	}

}
