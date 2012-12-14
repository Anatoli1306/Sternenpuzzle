/**
 * 
 */
package logic;

import java.io.Serializable;

import gui.GuiElementField.eStates;

/**
 * Die CommandSetStar Klasse dient dazu, um ein Stern in das Feld zu setzen.
 * Durch set und get Methoden können die Daten der CommandSetStar Klasse gesetzt und ausgegeben werden.
 * 
 * @author Fabian, Mats, Eren, Daniel, Andreas, Anatoli
 * @version 0.1
 * 
 */

public class CommandSetStar implements ICommand, Serializable
{
	/**
	 * Dekleration der Variabeln für die Klasse
	 */
	GameField _oField = null;	
	eStates oldState = null;

	/**
	 * Das Feld wo ein Stern gesetzt wereden soll, wird hier angegeben
	 * @param GameField - Hier wird das Feld angegeben, wo ein Stern gesetzt werden soll
	 */
	public CommandSetStar(GameField field)
	{
		_oField = field;
		oldState = field.getState();
	}

	/**
	 * @see logic.ICommand#execute()
	 */

	/**
	 * Setzt ein Stern in das Feld
	 */
	public void execute() 
	{
		_oField.setState(eStates.STAR, true);
	}

	/**
	 * @see logic.ICommand#execute()
	 */

	/**
	 * Setzt den Status des Feldes wieder zurück
	 */
	public void undo() 
	{
		_oField.setState(oldState, true);
	}

}
