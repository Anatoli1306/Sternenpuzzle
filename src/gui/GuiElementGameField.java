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
		
		eStates tmpAllowedTypes[] = {eStates.BLANK, eStates.STAR, eStates.QUESTION, eStates.CROSS};
		_allowedTypes = tmpAllowedTypes;
	}

}
