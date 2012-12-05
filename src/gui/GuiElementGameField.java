/**
 * 
 */
package gui;

import logic.GameField;
import gui.GuiElementField.eStates;

/**
 * 
 * @author Andreas
 * @version 0.1
 *
 */

public class GuiElementGameField  extends GuiElementField 
{
	protected boolean _isStar = false;
	
	/**
	 * 
	 */
	public GuiElementGameField(GuiElementBoard oBoard) 
	{
		super(oBoard);
		
		eStates tmpAllowedLeftTypes[] = {eStates.BLANK, eStates.QUESTION, eStates.CROSS};
		_allowedLeftTypes = tmpAllowedLeftTypes;
		
		eStates tmpAllowedRightTypes[] = {eStates.BLANK, eStates.STAR};
		_allowedRightTypes = tmpAllowedRightTypes;
	}
	
	
	/**
	 * 
	 * @param star
	 */
	
	public void setIsStarField(boolean star)
	{
		_isStar = star;
		GameField oGameField = (GameField) _oLogicField;
		oGameField.setIsStarField(star);
	}
	
	
	public boolean isStarField()
	{
		return _isStar;
	}
}
