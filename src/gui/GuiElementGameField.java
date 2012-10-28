/**
 * 
 */
package gui;

import gui.GuiElementField.eStates;

/**
 * 
 * @author Andreas
 * @version 0.1
 *
 */

public class GuiElementGameField  extends GuiElementField 
{

	/**
	 * 
	 */
	public GuiElementGameField() 
	{
		super();
		
		eStates tmpAllowedLeftTypes[] = {eStates.BLANK, eStates.QUESTION, eStates.CROSS};
		_allowedLeftTypes = tmpAllowedLeftTypes;
		
		eStates tmpAllowedRightTypes[] = {eStates.BLANK, eStates.STAR};
		_allowedRightTypes = tmpAllowedRightTypes;
	}

}
