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
public class GameBoard extends Board 
{
	/**
	 * 
	 */
	private String _oCommandTracker = null;
	
	/**
	 * 
	 */
	private int _currentMarker = 0;

	/**
	 * @param int height
	 * @param int width
	 */
	public GameBoard(int height, int width) 
	{
		super(height, width);
		this._fields = new Field[height][width];
		
		for (int iY = 0; iY < height; iY++)
		{
			for (int iX = 0; iX < width; iX++)
			{
				this._fields[iY][iX] = new GameField(this);
			}
		}
	}

	/**
	 * @param int xPos
	 * @param int yPos
	 */
	public void onFieldClick(int xPos, int yPos)
	{
		
	}
	
	/**
	 * @param String filename
	 */
	public void save(String filename)
	{
		
	}
	
	/**
	 * @param String filename
	 */
	public Board load(String filename)
	{
		return null;
	}
	
	/* @Todo change type to match with commandtracker class */

	/**
	 * @return the _oCommandTracker
	 */
	public String get_oCommandTracker() 
	{
		return _oCommandTracker;
	}

	/**
	 * @param _oCommandTracker the _oCommandTracker to set
	 */
	public void set_oCommandTracker(String _oCommandTracker) 
	{
		this._oCommandTracker = _oCommandTracker;
	}

	/**
	 * @return the _currentMarker
	 */
	public int getCurrentMarker() 
	{
		return _currentMarker;
	}

	/**
	 * @param int currentMarker
	 */
	public void setCurrentMarker(int currentMarker) 
	{
		this._currentMarker = currentMarker;
	}
}
