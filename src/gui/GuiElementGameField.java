/**
 * 
 */
package gui;

import logic.GameField;
import gui.GuiElementField.eStates;

/**
 * Klasse definiert ein Feld vom Boar im EditierModus
 * 
 * @author Andreas, Fabian, Mats, Eren, Anatoli, Daniel
 * @version 0.1
 *
 */
public class GuiElementGameField  extends GuiElementField 
{
	protected boolean _isStar = false;
	
	/**
	 * Konstruktor
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
	 * Setzt einen Stern
	 * 
	 * @param star - Enthällt einen Stern
	 */
	public void setIsStarField(boolean star)
	{
		_isStar = star;
		GameField oGameField = (GameField) _oLogicField;
		oGameField.setIsStarField(star);
	}
	
	/**
	 * Funktion überprüft ob ein Stern im Feld gesetzt ist
	 * 
	 * @return _isStar - boolean der einen Wahrheitswert zurück gibt ob im Feld ein Stern ist
	 */
	public boolean isStarField()
	{
		return _isStar;
	}
}
