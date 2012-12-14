package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import logic.Board;
import logic.EditorBoard;

/**
 * Klasse für "Speichern unter"
 * @author Andreas, Mats, Daniel, Eren, Fabian, Anatoli
 * @version 0.1
 *
 */
public class SaveAsDialog extends JFrame {

	private boolean cancel = false;
	/**
	 *Konstruktor 
	 */
	public SaveAsDialog() {
		saveAs(null);
	}
	/**
	 * Methode Speichern unter
	 * @param pfad
	 * @return boolean
	 */
	boolean saveAs(String pfad) {
		JFileChooser chooser;
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream( "SaveAsInfo.xml" );
			ObjectInputStream o = new ObjectInputStream( fis );			
			pfad = (String) o.readObject();
			
		} catch ( IOException e ) { System.err.println( e ); } 
		  catch(ClassNotFoundException e){System.err.println(e);}
		finally { try { fis.close(); } catch ( Exception e ) { } }
	
		
		if (pfad == null){
			pfad = System.getProperty("user.home");
			pfad = pfad + "\\Sternenhimmel-Puzzle";
			File saveDirectory = new File(pfad);
			if(saveDirectory.isDirectory()){}
			else{
				saveDirectory.mkdir();
			}
		}
		File file = new File(pfad.trim());
		chooser = new JFileChooser(pfad);
		chooser.setDialogType(JFileChooser.SAVE_DIALOG);

		FileNameExtensionFilter markUpFilter = new FileNameExtensionFilter(
				"xml", "xml");
		chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());

		chooser.setFileFilter(markUpFilter);
		chooser.setDialogTitle("Speichern unter...");
		chooser.setVisible(true);
		int result = chooser.showSaveDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) 
		{
			pfad = chooser.getSelectedFile().toString();
			if(pfad.matches(".*(.xml).*")){}
			else{
				pfad = pfad + ".xml";
			}
			file = new File(pfad);
			if (markUpFilter.accept(file))
			{
				Board oBoard = PlayFrame._oPlayFrame._oBoard.getLogicBoard();
				if (oBoard instanceof EditorBoard)
				{
					oBoard.save(pfad);
				}
				else
				{
					oBoard.save(pfad);
				}

				FileOutputStream fos  = null;
				
				try {
					fos = new FileOutputStream("SaveInfo.xml");
					ObjectOutputStream oos;
					oos = new ObjectOutputStream(fos);
					oos.writeObject(pfad);
					oos.close();
				}
				catch ( IOException e ) { System.err.println( e ); } 
				finally { try { fos.close(); } catch ( Exception e ) { } }
				
				try {
					fos = new FileOutputStream("SaveAsInfo.xml");
					ObjectOutputStream oos;
					oos = new ObjectOutputStream(fos);
					pfad = chooser.getCurrentDirectory().toString();
					oos.writeObject(pfad);
					oos.close();
				}
				catch ( IOException e ) { System.err.println( e ); } 
				finally { try { fos.close(); } catch ( Exception e ) { } }
				
				
			}
			PlayFrame._oPlayFrame._oBoard.setHasChanged(false);
		}
		else if (result == JFileChooser.CANCEL_OPTION)
		{
			cancel = true;
			chooser.setVisible(false);
		}
		else
		{
			chooser.setVisible(false);
			return true;
		}
		chooser.setVisible(false);
		return false;
	}

	public boolean isCancel() 
	{
		return cancel;
	}

}