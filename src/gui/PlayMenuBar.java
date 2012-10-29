package gui;

import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;

// Klasse enth�llt die Men�leiste

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
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{	
			}
			
		});
		
		//Datei Laden
		MenuItem laden = new MenuItem("Laden");
		laden.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{	
				LoadDialog loadDialog = new LoadDialog();
			}
			
		});
		
		//Datei Speichern
		MenuItem speichern = new MenuItem("Speichern");
		speichern.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
			}
			
		});
		
		//Datei Speichern_Unter
		MenuItem speichern_unter = new MenuItem("Speichern Unter");
		speichern_unter.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{	
			}
			
		});
		
		//Datei Beenden
		MenuItem beenden = new MenuItem("Beenden");
		beenden.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{	
				playFrame.dispose();
			}
			
		});
		
		// Schaltfl�chen hinzuf�gen
		m.add(neu);
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
					
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{	
			}
					
		});
				
		//Bearbeiten Zur�ck zum Marker
		MenuItem zur�ck_zum_marker = new MenuItem("Zur�ck zum Marker");
		zur�ck_zum_marker.addActionListener(new ActionListener(){
					
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{	
			}
					
		});
				
		//Bearbeiten R�ckg�nging - Zum ersten Fehler
		MenuItem r�ckg�ngig_zum_ersten_fehler = new MenuItem("R�ckg�ngig zum ersten Fehler");
		r�ckg�ngig_zum_ersten_fehler.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{	
			}
			
		});
		
		// Schaltfl�chen hinzuf�gen
		m.add(marker_setzen);
		m.add(zur�ck_zum_marker);
		m.addSeparator();
		m.add(r�ckg�ngig_zum_ersten_fehler);
		add(m);
		
		//Ansicht
		m = new Menu("Ansicht");
		
		//Ansicht Spielmodus
		MenuItem spielmodus = new MenuItem("Spielmodus");
		spielmodus.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}	
			
		});
				
		//Ansicht Editiermodus
		MenuItem editiermodus = new MenuItem("Editiermodus");
		editiermodus.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}	
			
		});
		
		// Schaltfl�chen hinzuf�gen
		m.add(spielmodus);
		m.addSeparator();
		m.add(editiermodus);
		add(m);
		
		//Hilfe
		m = new Menu("Hilfe");
		
		//Hilfe Spielbeschreibung
		MenuItem spielbeschreibung = new MenuItem("Spielbeschreibung");
		spielbeschreibung.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}	
			
		});
		
		//Hilfe Info
		MenuItem info = new MenuItem("Info");
		info.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent a) 
			{
				InfoFenster infofenster = new InfoFenster();
			}	
			
		});
		
		// Schaltfl�chen hinzuf�gen
		m.add(spielbeschreibung);
		m.addSeparator();
		m.add(info);
		add(m);
	}
}

