/**
 * 
 */
package logic;

import java.io.Serializable;

import gui.GuiElementField.eStates;


/**
 * 
 * @author Andreas Andreas 
 * @version 0.1
 * 
 */

public abstract class Board implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	
	
	/**
	 * 
	 * @param int posY
	 * @param int posX
	 * @return Field
	 * 
	 */
	public Field getField(int posY, int posX)
	{
		return this._fields[posY][posX];
	}
	
	
	/**
	 * 
	 * @param int row
	 * @return int
	 * 
	 */
	
	public int getCountStarsForRow(int row)
	{
		int countStars = 0;
		for (int i = 0; i < _width; i++) 
		{
			Field oField = (Field)_fields[row][i];
			if (eStates.STAR == oField.getState())
			{
				countStars++;
			}
			else if(this instanceof GameBoard)
			{
				GameField oGameField = (GameField)_fields[row][i];
				if (oGameField.isStarField())
				{
					countStars++;
				}
			}
		}
		return countStars;
	}
	
	
	/**
	 * 
	 * @param int column
	 * @return int
	 * 
	 */
	
	public int getCountStarsForColumn(int column)
	{
		int countStars = 0;
		for (int i = 0; i < _height; i++) 
		{
			Field oField = (Field)_fields[i][column];
			if (eStates.STAR == oField.getState())
			{
				countStars++;
			}
			else if(this instanceof GameBoard)
			{
				GameField oGameField = (GameField)_fields[i][column];
				if (oGameField.isStarField())
				{
					countStars++;
				}
			}
		}
		return countStars;
	}
	
	/**
	 * @param String filename
	 */
	abstract public void save(String filename);
}
