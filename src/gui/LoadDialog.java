package gui;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import logic.Board;
import logic.EditorBoard;
import logic.GameBoard;

/**
 * 
 * @author Eren, Fabian
 * @version 0.1
 *
 */

public class LoadDialog
{
  public LoadDialog()
  {
    JFileChooser fc = new JFileChooser();
    fc.setFileFilter( new FileFilter()
    {
      @Override public boolean accept( File f )
      {
        return f.isDirectory() ||
          f.getName().toLowerCase().endsWith( ".xml" );
      }
      @Override public String getDescription()
      {
        return "";
      }
    } );
    int state = fc.showOpenDialog( null );
    if ( state == JFileChooser.APPROVE_OPTION )
    {

      File file = fc.getSelectedFile();
      System.out.println(fc.getSelectedFile());

     Board oBoard = PlayFrame._oPlayFrame._oBoard.getLogicBoard();
     System.out.println("assd");
    if (oBoard instanceof EditorBoard)
	{
    	    	
		GuiElementBoard oGuiBoard = EditorBoard.loadEdit(fc.getSelectedFile().getAbsolutePath());
		System.out.println( "BlaBla" );
		PlayFrame._oPlayFrame.drawLoadedBoard(oGuiBoard);
		PlayFrame.refreshWindow();
	}
	else
		
	if (oBoard instanceof GameBoard)
	{
		
		GuiElementBoard oGameBoard = GameBoard.load(fc.getSelectedFile().getAbsolutePath());
		//System.out.print(oGameBoard);
		PlayFrame._oPlayFrame.drawLoadedGameBoard(oGameBoard);
		PlayFrame.refreshWindow();
		
			
		
	}else {System.out.println("Weder Game noch Editorboard vorhanden");}
    
    }
    else
      System.out.println( "Auswahl abgebrochen" );

  }
}
