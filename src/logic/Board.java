/**
 * 
 */
package logic;


/**
 * 
 * @author Andreas Andreas 
 * @version 0.1
 * 
 */

public class Board 
{
	/**
	 *
	 */
	private int _height = 10;

	/**
	 * 
	 */
	private int _width = 10;
	
	/**
	 * 
	 */
	protected Field[][] _fields = new Field[0][0];
	
	/* @ToDo add class variable fields - array of field */
	
	/**
	 * @param int height
	 * @param int width
	 */
	public Board(int height, int width)
	{
		this._height = height;
		this._width = width;
	}
	
	/**
	 * @return int
	 */
	protected int getHeight() 
	{
		return _height;
	}

	/** 
	 * @param int height
	 */
	protected void setHeight(int height) 
	{
		this._height = height;
	}

	/**
	 * @return int
	 */
	protected int getWidth() 
	{
		return _width;
	}

	/**
	 * @param int width
	 */
	protected void setWidth(int width) 
	{
		this._width = width;
	}
}
