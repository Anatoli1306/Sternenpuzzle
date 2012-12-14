/**
 * 
 */
package logic;

import java.io.Serializable;

/**
 * Die Board Klasse dient dazu, um ein Board zu erstellen.
 * Durch set und get Methoden können die Daten des Board gesetzt und ausgegeben werden.
 * 
 * @author Fabian, Mats, Eren, Daniel, Andreas, Anatoli
 * @version 0.1
 * 
 */

public interface ICommand extends Serializable
{
	/**
	 * Die Funktion execute wird hier an die Unterklasse vererbt
	 */
	public void execute();
	
	/**
	 * Die Funktion undo wird hier an die Unterklasse vererbt
	 */
	public void undo();
}
