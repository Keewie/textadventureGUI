package gui;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;



public class WrongFrame
{	
	
	Font wFont = new Font("Arial", Font.ITALIC, 32); //Die Schrift für den "Falsch - Text"
	HashMap<Integer, String> wHm= new HashMap<Integer, String>(); 
	JTextArea wrongTxtArea; 
	ImageIcon wFramePic; 
	JLabel wrongLabel; 
	JButton bClose; 
	JFrame wFrame; 
	Random random; 
	int wCounter; 
	
	
	public WrongFrame()
	{

//Das Fenster________________________________________________________		
		wFrame = new JFrame(); 
		wFrame.setTitle("Ups!");
		wFrame.setAlwaysOnTop(true);
		wFrame.setLocation(750, 350);
		wFrame.setSize(525, 290);
		wFrame.setAlwaysOnTop(true);
		
	
//Das Hintergrundbild des Fensters____________________________________
		wFramePic = new ImageIcon(
				"C:\\Users\\K.Knittel\\Desktop\\Workspace eclipse K.Knittel\\Alltag eines Blinden Projekt - Anlauf 2\\Bilder Projekt\\falsch.jpg");
		wrongLabel = new JLabel(wFramePic);
		wrongLabel.setLayout(null); 
		wrongLabel.setBounds(0, 20, 525, 290); 
		wFrame.add(wrongLabel);
	
	
//Die TextArea________________________________________________________ 
		wrongTxtArea = new JTextArea(); 
		wrongTxtArea.setSize(525, 150);
		wrongTxtArea.setLocation(0, 0);
		wrongTxtArea.setFont(wFont);
		wrongTxtArea.setEditable(false);
		wrongTxtArea.setOpaque(false);
		wrongLabel.add(wrongTxtArea); 
	
		
//Der schließen - Button	
		bClose = new JButton("Ok, bitte schließen"); 
		bClose.setSize(180, 50); 
		bClose.setLocation(170, 180); 
		bClose.setIcon(new ImageIcon(
				"C:\\Users\\K.Knittel\\Desktop\\Workspace eclipse K.Knittel\\Alltag eines Blinden Projekt - Anlauf 2\\Bilder Projekt\\falschbutton.jpg"));
		wrongLabel.add(bClose); 
		
	
		wFrame.setVisible(true); 
	
	
//Der wrong - Text_____________________________________________________		
		WrongText wTxt1 = new WrongText("Falsch"); 
		WrongText wTxt2 = new WrongText("Total Falsch");
		WrongText wTxt3 = new WrongText("Sicher nicht");
		WrongText wTxt4 = new WrongText("Nope...");
	
	
//Hashmap______________________________________________________________		
		wHm.put(1, wTxt1.wContent);
		wHm.put(2, wTxt2.wContent);
		wHm.put(3, wTxt3.wContent);
		wHm.put(4, wTxt4.wContent);

	
//Zufällige Textauswahl________________________________________________
		random = new Random(); 
		wCounter = random.nextInt(4)+1; 
	
		wrongTxtArea.setText(wHm.get(wCounter));
	
	
		CloseHandler closeHandler = new CloseHandler();
		bClose.addActionListener(closeHandler);
	}
	
	
	
	class CloseHandler implements ActionListener 
	{//CloseHandler Class

		public void actionPerformed(ActionEvent event) 
		{
			wFrame.dispose();
		}
	}//CloseHandler Class


}//WrongFrame Class


