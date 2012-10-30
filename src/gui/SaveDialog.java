package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 
 * @author Eren, Fabian
 * @version 0.1
 *
 */

public class SaveDialog extends JFrame {

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
                System.out.println(pfad + " kann gespeichert werden.");
            else
                System.out.println(pfad + " ist der falsche Dateityp.");

            chooser.setVisible(false);
            return true;
        }
        chooser.setVisible(false);
        return false;
    }
} 