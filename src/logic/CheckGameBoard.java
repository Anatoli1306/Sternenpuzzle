/**
 * 
 */
package logic;

/**
 * @author Andreas
 *
 */
public class CheckGameBoard extends CheckBoard 
{	
	public CheckGameBoard(Board oBoard)
	{
		setBoard(oBoard);
	}
	
	public boolean check()
	{
		return true;
	}
}
