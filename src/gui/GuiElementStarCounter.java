/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import sun.nio.cs.ext.PCK;


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
		
		setFontSize();
	}
	
	
	/**
	 * find optimal font size
	 */
	
	public void setFontSize()
	{
		Font labelFont = getFont();
		String labelText = getText();

		int stringWidth = getFontMetrics(labelFont).stringWidth(labelText);
		if (0 == stringWidth)
		{
			stringWidth = 10;
		}
	
		int componentWidth = getWidth();

		// Find out how much the font can grow in width.
		double widthRatio = (double)componentWidth / (double)stringWidth;

		int sizeFont = (int)labelFont.getSize();
		if (0 == sizeFont)
		{
			sizeFont = 10;
		}

		int newFontSize = (int)(sizeFont * widthRatio);
		int componentHeight = getHeight();
		
		// Pick a new font size so it will not be larger than the height of label.
		int fontSizeToUse = Math.min(newFontSize, componentHeight);
		
		if (fontSizeToUse > 5)
		{
			fontSizeToUse = fontSizeToUse - 3;
		}

		// Set the label's font size to the newly determined size.
		setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
	}
	
}

