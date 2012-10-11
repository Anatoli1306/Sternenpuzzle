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

public class EditorBoard extends Board 
{

	/**
	 * @param int height
	 * @param int width
	 */
	public EditorBoard(int height, int width) 
	{
		super(height, width);
		this._fields = new Field[height][width];
		
		for (int iY = 0; iY < height; iY++)
		{
			for (int iX = 0; iX < width; iX++)
			{
				this._fields[iY][iX] = new EditorField(this);
			}
		}
	}
	
	/**
	 * @param int yPos
	 * @param int xPos
	 * return Field
	 */
	public Field getField(int yPos, int xPos)
	{
		return this._fields[yPos][xPos];
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
	public void load(String filename)
	{
		
	}

}
