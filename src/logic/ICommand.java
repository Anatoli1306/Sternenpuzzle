/**
 * 
 */
package logic;

/**
 * 
 * @author Andreas
 * @version 0.1
 *
 */

public interface ICommand 
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
