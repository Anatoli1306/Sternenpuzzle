package gui;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Klasse enthällt die Menüleiste

class PlayMenuBar extends MenuBar{
	
	private PlayFrame playFrame;
	
	public PlayMenuBar(PlayFrame frame)
	{
		Menu m;
		playFrame = frame;
		
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
			}
			
		});
		
		// Schaltflächen hinzufügen
		m.add(neu);
		m.add(laden);
		m.addSeparator();
		m.add(speichern);
		m.add(speichern_unter);
		m.addSeparator();
		m.add(beenden);
		add(m);
		
		//Ansicht
		m = new Menu("Ansicht");
				
		//Ansicht Editiermodus
		MenuItem editiermodus = new MenuItem("Editiermodus");
		neu.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}	
			
		});
		
		// Schaltflächen hinzufügen
		m.add(editiermodus);
		add(m);
	}
}

