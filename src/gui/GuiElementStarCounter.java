/**
 * 
 */
package gui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


/**
 * @author Andreas
 *
 */
public class GuiElementStarCounter extends JLabel
{

	private int _countStars = 0;
	
	public GuiElementStarCounter(int countStars)
	{
		setText(Integer.toString(countStars));
		setForeground(Color.WHITE);
//		Border border = LineBorder.createGrayLineBorder();
//		setBorder(border);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		setStars(countStars);
	}
	
	public void setStars(int countStars)
	{
		if (_countStars != countStars)
		{
			setText(Integer.toString(countStars));
		}
		
		_countStars = countStars;
	}
	
}

