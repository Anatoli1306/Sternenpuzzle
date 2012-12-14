/**
 * 
 */
package logic;

import java.io.Serializable;

import gui.GuiElementField.eStates;

/**
 * Die CommandSetCross Klasse dient dazu, um ein X in ein Feld zu setzen.
 * Durch set und get Methoden können die Daten der CommandSetCross Klasse gesetzt und ausgegeben werden.
 * 
 * @author Fabian, Mats, Eren, Daniel, Andreas, Anatoli
 * @version 0.1
 * 
 */

public class CommandSetCross implements ICommand, Serializable
{
	/**
	 * Dekleration der Variabeln für die Klasse
	 */
	GameField _oField = null;	
	eStates oldState = null;
	
	/**
	 * Das Feld wo ein X gesetzt wereden soll, wird hier angegeben
	 * @param GameField - Hier wird das Feld angegeben, wo ein X gesetzt werden soll
	 */
	public CommandSetCross(GameField field)
	{
		_oField = field;
		oldState = field.getState();
	}

	/**
	 * @see logic.ICommand#execute()
	 */
	
	/**
	 * Setzt das X in das Feld
	 */
	public void execute() 
	{
		_oField.setState(eStates.CROSS, true);
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
