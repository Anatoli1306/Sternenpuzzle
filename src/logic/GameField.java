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

public class GameField extends Field 
{

	/**
	 * 
	 */
	private boolean _isStar = false;
	
	/**
	 * @param oBoard
	 */
	public GameField(Board oBoard, int xPos, int yPos) 
	{
		super(oBoard, xPos, yPos);
	}

	
	/**
	 * 
	 */
	public void action()
	{
		
	}
	
	/**
	 * @param eStates _state
	 */
	public void setState(eStates state) 
	{
		ICommand command = null;
		switch (state) 
		{
			case BLANK:
				command = new CommandSetBlank(this);
				break;
			
			case STAR:
				command = new CommandSetStar(this);
				break;

			case QUESTION:
				command = new CommandSetQuestion(this);
				break;
				
			case CROSS:
				command = new CommandSetCross(this);
				break;
				
			default:
			break;
		}
		
		GameBoard oBoard = (GameBoard)_oBoard;
		oBoard.getCommandTracker().add(command);
		
		super.setState(state);
	}
	
	/**
	 * @param eStates _state
	 */
	public void setState(eStates state, int aas)
	{
		super.setState(state);
	}
	
	/**
	 * 
	 * @param star
	 */
	
	public void setIsStarField(boolean star)
	{
		_isStar = star;
	}
	
	
	public boolean isStarField()
	{
		return _isStar;
	}
}
