package gui;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

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
          f.getName().toLowerCase().endsWith( ".txt" );
      }
      @Override public String getDescription()
      {
        return "Texte";
      }
    } );
    int state = fc.showOpenDialog( null );
    if ( state == JFileChooser.APPROVE_OPTION )
    {
      File file = fc.getSelectedFile();
      System.out.println( file.getName() );
    }
    else
      System.out.println( "Auswahl abgebrochen" );

  }
}
