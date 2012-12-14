/**
 * 
 */
package logic;

import java.io.Serializable;

import gui.GuiElementField.eStates;


/**
 * Die Board Klasse dient dazu, um ein Board zu erstellen.
 * Durch set und get Methoden k�nnen die Daten des Board gesetzt und ausgegeben werden.
 * 
 * @author Fabian, Mats, Eren, Daniel, Andreas, Anatoli
 * @version 0.1
 * 
 */

public abstract class Board implements Serializable
{

	/**
	 * Dekleration der Variabeln f�r die Klasse
	 */
	private static final long serialVersionUID = 1L;
	private int _height = 10;
	private int _width = 10;	
	protected Field[][] _fields = new Field[0][0];

	/**
	 * Konstruktor f�r die Board - Klasse
	 * Als parameter wird hier die H�he und die Breite angegeben
	 * @param height - H�he des Boards
	 * @param width - Breite des Boards
	 */
	public Board(int height, int width)
	{
		this._height = height;
		this._width = width;
	}

	/**
	 * Gibt die H�he des Boards zur�ck
	 * @return _height - Enth�lt die H�he vom aktuellen Board
	 */
	protected int getHeight() 
	{
		return _height;
	}

	/**
	 * Setzt die H�he des Boards
	 * @param height - Die H�he des Boards setzen
	 */
	protected void setHeight(int height) 
	{
		this._height = height;
	}

	/**
	 * Gibt die Breite des Boards zur�ck
	 * @return _width - Enth�lt die Breite vom aktuellen Board
	 */
	protected int getWidth() 
	{
		return _width;
	}

	/**
	 * Setzt die Breite des Boards
	 * @param width - Die Breite des Boards setzen
	 */
	protected void setWidth(int width) 
	{
		this._width = width;
	}


	/**
	 * Durch die eingabe der Position des Feldes auf der X und Y Achse, wird das Feld mit dem aktuellen Status zur�ckgegeben
	 * @param int posY - Die Position des Feldes auf der Y Achse angeben
	 * @param int posX - Die Position des Feldes auf der X Achse angeben
	 * @return _fields - Das ausgehw�hlte Feld mit dem Status, wird zur�ckgegeben
	 * 
	 */
	public Field getField(int posY, int posX)
	{
		return this._fields[posY][posX];
	}


	/**
	 * Gibt die Anzahl der Sterne f�r die angegebene Zeile zur�ck
	 * @param row - Die Zeile die ausgewertet werden soll, wird hier angegeben
	 * @return countStars - Die Anzahl der Sterne in der angegebenen Zeile wird hier zur�ckgegeben
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
	 * Gibt die Anzahl der Sterne f�r die angegebene Spalte zur�ck
	 * @param column - Die Spalte die ausgewertet werden soll, wird hier angegeben
	 * @return countStars - Die Anzahl der Sterne in der angegebenen Spalte wird hier zur�ckgegeben
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
	 * Die Funktion save wird hier an die Unterklasse vererbt
	 * Speichert das aktuelle Board mit dem Namen der angegeben werden muss
	 * @param filename - Hier wird der Dateiname f�r das Spiel angegeben
	 */
	abstract public void save(String filename);
}
