package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import logic.EditorBoard;

/**
 * 
 * @author Eren, Fabian, Anatoli
 * @version 0.1
 *
 */

public class SaveDialog extends JFrame {
	
	private boolean cancel = false;

    public SaveDialog() {
    	saveAs(null);
    }

    boolean saveAs(String pfad) {
   		JFileChooser chooser;
   		if (pfad == null)
   			pfad = System.getProperty("user.home");
   		File file = new File(pfad.trim());
    		chooser = new JFileChooser(pfad);
   		chooser.setDialogType(JFileChooser.SAVE_DIALOG);
   		FileNameExtensionFilter plainFilter = new FileNameExtensionFilter(
   			"Plaintext: txt, csv", "txt", "csv");
   		FileNameExtensionFilter markUpFilter = new FileNameExtensionFilter(
               "Markup: xml, htm, html", "xml", "html", "htm");
   		chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
   		chooser.setFileFilter(plainFilter);
   		chooser.setFileFilter(markUpFilter);
   		chooser.setDialogTitle("Speichern unter...");
   		chooser.setVisible(true);
    		int result = chooser.showSaveDialog(this);
   		
   		if (result == JFileChooser.APPROVE_OPTION) {
   			pfad = chooser.getSelectedFile().toString();
   			file = new File(pfad);
   			if (plainFilter.accept(file) || markUpFilter.accept(file))
   			{
   				System.out.println(pfad + " kann gespeichert werden.");
   				EditorBoard eB = new EditorBoard(10,10);
   				eB.save(pfad);
   				}
   			}
   		else if (result == JFileChooser.CANCEL_OPTION){
               System.out.println("Doch nicht gespeichert");
               cancel = true;
               
               System.out.println(cancel);
               
               chooser.setVisible(false);
               
           	return true;
       	}
   	chooser.setVisible(false);
   	return false;
    }

	public boolean isCancel() {
		return cancel;
	}
}