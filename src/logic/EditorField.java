/**
 * 
 */
package logic;

/**
 * Die EditorField Klasse dient dazu, um ein Editor Feld zu erstellen.
 * 
 * @author Fabian, Mats, Eren, Daniel, Andreas, Anatoli
 * @version 0.1
 * 
 */

public class EditorField extends Field 
{

	/**
	 * Konstruktor für die EditorField - Klasse
	 * Als parameter wird hier das Board, die Position auf der X Achse und die Position auf der Y Achse angegeben
	 * @param board - Hier wird das Editor Board angegeben
	 * @param xPos - Hier wird die Position auf der X Achse angegeben
	 * @param yPos - Hier wird die Position auf der Y Achse angegeben
	 */
	public EditorField(Board oBoard, int xPos, int yPos) 
	{
		super(oBoard, xPos, yPos);
	}

}
