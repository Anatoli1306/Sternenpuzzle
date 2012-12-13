package gui;

import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import logic.CheckEditorBoardDifficulty;
import logic.GameBoard;

// Klasse enth�lt die Men�leiste

/**
 * 
 * @author Eren, Fabian
 * @version 0.1
 *
 */

class PlayMenuBar extends MenuBar
{
	
	/**
	 * 
	 */
	private PlayFrame playFrame;
	
	
	/**
	 * 
	 * @param PlayFrame frame
	 * 
	 */
	
	public PlayMenuBar(PlayFrame frame)
	{
		Menu m;
		playFrame = frame;
		playFrame.getContentPane().setBackground(Color.white);
		
		
		//Datei
		m = new Menu("Datei");
		
		//Datei Neu
		MenuItem neu = new MenuItem("Neu");
		neu.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent arg0)
			{	
				int temp = 0;
				if(PlayFrame._oPlayFrame._oBoard.getCols() == 0 && PlayFrame._oPlayFrame._oBoard.getRows() == 0 || PlayFrame._oPlayFrame._oBoard.isHasChanged() == false){temp = 1;}
				else{
					QuestionToSaveDialog questionToSaveDialog = new QuestionToSaveDialog();

					if(questionToSaveDialog.isYes_no_answer() && questionToSaveDialog.isSave_is_cancel() == false){
						BoardSizeDialog boardSizeDialog = new BoardSizeDialog(playFrame);									
					}
				}
				if(temp == 1){
					BoardSizeDialog boardSizeDialog = new BoardSizeDialog(playFrame);
				}
			}
			
		});
		
		//Datei Laden
		MenuItem laden = new MenuItem("Laden");
		laden.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent arg0) 
			{	
				if(PlayFrame._oPlayFrame._oBoard.getCols() == 0 && PlayFrame._oPlayFrame._oBoard.getRows() == 0 || PlayFrame._oPlayFrame._oBoard.isHasChanged() == false){
					LoadDialog loadDialog = new LoadDialog();
				}
				else{
					QuestionToSaveDialog questionToSaveDialog = new QuestionToSaveDialog();
					if(questionToSaveDialog.isYes_no_answer() && questionToSaveDialog.isSave_is_cancel() == false){
						LoadDialog loadDialog = new LoadDialog();								
					}
				}
			}
			
		});
		
		//Datei Speichern
		MenuItem speichern = new MenuItem("Speichern");
		speichern.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent arg0) 
			{
			}
			
		});
		
		//Datei Speichern_Unter
		MenuItem speichern_unter = new MenuItem("Speichern Unter");
		speichern_unter.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent arg0) 
			{	
				SaveDialog saveDialog = new SaveDialog();
			}
			
		});
		
		//Datei Beenden
		MenuItem beenden = new MenuItem("Beenden");
		beenden.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent arg0) 
			{	
				QuestionToSaveDialog questionToSaveDialog = new QuestionToSaveDialog();
				if(questionToSaveDialog.isYes_no_answer()){
					playFrame.dispose();
				}
			}
			
		});
		
		// Schaltfl�chen hinzuf�gen
		if(frame._oBoard instanceof GuiElementEditorBoard){
			m.add(neu);
		}
		m.add(laden);
		m.addSeparator();
		m.add(speichern);
		m.add(speichern_unter);
		m.addSeparator();
		m.add(beenden);
		add(m);
		
		//Bearbeiten
		m = new Menu("Bearbeiten");
				
		//Bearbeiten Marker setzen
		MenuItem marker_setzen = new MenuItem("Marker setzen");
		marker_setzen.addActionListener(new ActionListener(){
					
			
			public void actionPerformed(ActionEvent arg0) 
			{	
				JOptionPane.showMessageDialog(null,"Marker gesetzt","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
            	GameBoard oLogicBoard = (GameBoard)playFrame._oBoard.getLogicBoard();
            	oLogicBoard.getCommandTracker().setMarkerPosition();
			}
					
		});
				
		//Bearbeiten Zur�ck zum Marker
		MenuItem zur�ck_zum_marker = new MenuItem("Zur�ck zum Marker");
		zur�ck_zum_marker.addActionListener(new ActionListener(){
					
			
			public void actionPerformed(ActionEvent arg0) 
			{	
				JOptionPane.showMessageDialog(null,"Zur�ck zum Marker","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
            	GameBoard oLogicBoard = (GameBoard)playFrame._oBoard.getLogicBoard();
            	oLogicBoard.getCommandTracker().goBackToLastMarker();
			}
					
		});
				
		//Bearbeiten R�ckg�nging - Zum ersten Fehler
		MenuItem r�ckg�ngig_zum_ersten_fehler = new MenuItem("R�ckg�ngig zum ersten Fehler");
		r�ckg�ngig_zum_ersten_fehler.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent arg0) 
			{	
				JOptionPane.showMessageDialog(null,"Zur�ck vor den ersten Fehler","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
				GameBoard oLogicBoard = (GameBoard)playFrame._oBoard.getLogicBoard();
				oLogicBoard.getCommandTracker().goBackToFirstFailure();
			}
			
		});
		
		//Bearbeiten L�sbarkeit �berpr�fen - L�sbarkeit �berpr�fen
		MenuItem check = new MenuItem("L�sbarkeit �berpr�fen");
		check.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) 
			{
				if(PlayFrame._oPlayFrame._oBoard.getCols() == 0 && PlayFrame._oPlayFrame._oBoard.getRows() == 0){
					JOptionPane.showMessageDialog(null,"Sie m�ssen erst ein Spielfeld anlegen","Option so nicht m�glich", JOptionPane.PLAIN_MESSAGE);
				}
				else{
					boolean result = playFrame._oBoard.check();
	        		String resultDiff = playFrame._oBoard.getDifficulty();
	        		String message = "Spiel entspricht nicht den Regeln";
	        		boolean showDiff = false;
	        		if (!result)
	        		{
	        			message = "Spiel entspricht den Regeln";
	        			showDiff = true;
	        		}
	        		JOptionPane.showMessageDialog(null, message, "SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
	        		
	        		if (showDiff)
	        		{
	        			JOptionPane.showMessageDialog(null, "Das Spiel ist "+resultDiff, "SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
	        			if (CheckEditorBoardDifficulty.BOARD_DIFFICULTY_NOT_SOLVABLE == resultDiff)
	        			{
	        				Map<Integer, HashMap<Integer, Integer>> unsolvableStars = playFrame._oBoard.getUnsolvableStars();
	        				for (int i = 0; i < unsolvableStars.size(); i++) 
	        				{
	        					HashMap<Integer, Integer> starPosMap = null;
	        					starPosMap = unsolvableStars.get(i);
	        					for (Entry<Integer, Integer> entry : starPosMap.entrySet()) 
	        					{
	        						playFrame._oBoard.getField(entry.getKey(), entry.getValue()).markAsBadStar();
	        				    }
							}
	        			}
	        		}
				}
			}	 
    });

		
		// Schaltfl�chen hinzuf�gen
		if(frame._oBoard instanceof GuiElementGameBoard){
			m.add(marker_setzen);
			m.add(zur�ck_zum_marker);
			m.addSeparator();
			m.add(r�ckg�ngig_zum_ersten_fehler);
			add(m);
		}
		else {
			m.add(check);
			add(m);
		}
		

		
		//Ansicht
		m = new Menu("Ansicht");
		
		//Ansicht Spielmodus
		MenuItem spielmodus = new MenuItem("Spielmodus");
		spielmodus.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent arg0) 
			{
            	QuestionToSaveDialog questionToSaveDialog = new QuestionToSaveDialog();
            	
            	if(questionToSaveDialog.isYes_no_answer() && questionToSaveDialog.isSave_is_cancel() == false){
            		playFrame.drawGameBoard(0,0);          	
            	}
			}	
			
		});
				
		//Ansicht Editiermodus
		MenuItem editiermodus = new MenuItem("Editiermodus");
		editiermodus.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent arg0) 
			{
            	QuestionToSaveDialog questionToSaveDialog = new QuestionToSaveDialog();

            	if(questionToSaveDialog.isYes_no_answer() && questionToSaveDialog.isSave_is_cancel() == false){
            		playFrame.drawEditorBoard(0,0);          	
            	}
			}	
			
		});
		
		// Schaltfl�chen hinzuf�gen
		if(frame._oBoard instanceof GuiElementEditorBoard)
		{
			m.add(spielmodus);
		}
		else
		{
			m.add(editiermodus);
		}
				
		add(m);
		
		//Hilfe
		m = new Menu("Hilfe");
		
		//Hilfe Spielbeschreibung
		MenuItem spielbeschreibung = new MenuItem("Spielbeschreibung");
		spielbeschreibung.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent arg0) 
			{
				InstructionDialog instructionDialog = new InstructionDialog();
			}	
			
		});
		
		//Hilfe Info
		MenuItem info = new MenuItem("Info");
		info.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent a) 
			{
				InfoDialog infofenster = new InfoDialog();
			}	
			
		});
		
		// Schaltfl�chen hinzuf�gen
		m.add(spielbeschreibung);
		m.addSeparator();
		m.add(info);
		add(m);
	}
}

