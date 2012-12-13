/**
 * 
 */
package logic;

import java.io.Serializable;

/**
 * 
 * @author Andreas
 * @version 0.1
 *
 */

public interface ICommand extends Serializable
{
	/**
	 * 
	 */
	public void execute();
	
	/**
	 * 
	 */
	public void undo();
}
