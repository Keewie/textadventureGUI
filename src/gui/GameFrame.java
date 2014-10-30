package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import model.XmlLevelInitializer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import org.xml.sax.SAXException;

import model.Level;
import model.LevelInitializer;
import model.SAXLevelParser;


public class GameFrame extends JFrame
{//GameFrame Class	
	
	private static final long serialVersionUID = 2790114042635611090L;
	
		JButton bDom; 
		JButton bSax; 
		JButton bJaxb; 
	
		Font fontGameText = new Font("Arial", Font.ITALIC, 23); //Die Schrift für den Spieltext
		Font fontUserArea = new Font("Arial", Font.PLAIN, 18);	//Die Schrift für den Userbereich
		
		JLabel picLabel; //Label für den Hintergrund
		JLabel gamePicLabel; //Label für das Bild des Spiels
		JLabel gameTextLabel; //Der Text des Spiels
		JLabel userAreaTxt; //Der Text auf der UserArea 
		
		ImageIcon bgPic; //Pic für den Hintergrund
		ImageIcon startGamePic; 
		
		JTextArea answersArea; //Die Antwortoptionen für den User
		JTextArea userArea; //Die Textarea des Users
		JTextArea gameTextArea; //Textarea für den Gametext
		JTextArea questionsArea; //Textarea für die Fragen unter dem Gametext
		
		JButton bNext; //Button zum "weiter" schalten, falls keine Frage gestellt wird, sondern nur Lesetext
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); //Zum rausfinden der Screengröße um das Frame anzupassen 
		
		int levelCounter = 0; //Counter zum hochzählen der Lvls
		int introTextCounter = 0; //Counter zum hochzählen der SpielTexte, also den IntroTexten
		
		private List<Level> levels; //LevelInitializer (früher GameContent, passt aber nicht mehr ganz) 
		Level currentLevel;
		
		
		
		
//_____________________________________________________________________________________________________________________________	
			
		
	public GameFrame() 
	{//GameFrame Constructor
		
		//Das Spielfenster____________________________		
		setLayout(null); 
		setTitle("Der Alltag eines Blinden");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1920,1030);  // <-- AÄNDERN!! size.width,size.height-50
		
	   
		//Bild-Label vom Hintergrundbild______________
		bgPic = new ImageIcon("Bilder Alltag/17369_abstract_green.jpg");
		picLabel = new JLabel(bgPic);
		picLabel.setLayout(null);
		picLabel.setBounds(0, 0,1920,1030);
		this.add(picLabel); 
				
		
		//Spielbild___________________________________
		startGamePic = new ImageIcon("Bilder Alltag/1.gif"); 
		gamePicLabel = new JLabel(startGamePic);
		gamePicLabel.setLayout(null);
		gamePicLabel.setBounds(70, 20, 1100, 650);
		picLabel.add(gamePicLabel); 
			   	       
				
	    //Der Spieltext -> der IntroTxt!
	    gameTextArea = new JTextArea();
	    gameTextArea.setLayout(null);
	    gameTextArea.setLineWrap(true); 
	    gameTextArea.setWrapStyleWord(true);
	    gameTextArea.setEditable(false);
	    gameTextArea.setBounds(70, 710, 1100, 190);
	    gameTextArea.setFont(fontGameText); 
	    gameTextArea.setOpaque(false);
	    gameTextArea.setForeground(Color.WHITE);
//	    gameTextArea.setText(currentLevel.getIntroTexts().get(0));  
	    picLabel.add(gameTextArea); 
			   
	    
	    
	    //Das Fragefenster unter dem Gametext -> also die Fragen!
	    questionsArea = new JTextArea();
	    questionsArea.setLayout(null);
	    questionsArea.setLineWrap(true); 
	    questionsArea.setWrapStyleWord(true);
	    questionsArea.setEditable(false);
	    questionsArea.setBounds(70, 900, 1200, 50);
	    questionsArea.setFont(fontGameText); 
	    questionsArea.setOpaque(false);
	    questionsArea.setForeground(Color.WHITE);
	    picLabel.add(questionsArea); 
	    
	    
		
		//Der Antwortoptionbereich -> also die Antworten!
		answersArea = new JTextArea();
		answersArea.setBounds(1300, 20, 530, 650);	
		answersArea.setLineWrap(true); 
		answersArea.setWrapStyleWord(true);
		answersArea.setFont(fontUserArea);
		answersArea.setEditable(false);
		picLabel.add(answersArea);
		

		
		//Der Antwortbereich___________________________
		userArea = new JTextArea(); 
		userArea.setLineWrap(true); 
		userArea.setWrapStyleWord(true);
		userArea.setBounds(1300, 780, 530, 140);
		userArea.setFont(fontUserArea);
		picLabel.add(userArea); 

		
		//Button neben userArea________________________
		bNext = new JButton(); 
		bNext.setIcon(new ImageIcon("Bilder Alltag/weiter.jpg"));
		bNext.setContentAreaFilled(false);
		bNext.setBounds(1300, 710, 530, 70);
		picLabel.add(bNext); 
		bNext.addActionListener(new NextButtonClickedListener());

		//Buttons für die Auswahl -> Dom, SAX, JAXB
		bDom = new JButton("DOM"); 
		bDom.setBounds(10, 10, 80, 50);
		bDom.addActionListener(new XMLInputButtonListener());
		picLabel.add(bDom); 
		
		bSax = new JButton("SAX"); 
		bSax.setBounds(210, 10, 80, 50);
		bSax.addActionListener(new XMLInputButtonListener());
		picLabel.add(bSax); 
		
		bJaxb = new JButton("JAXB"); 
		bJaxb.setBounds(310, 10, 80, 50);
		bJaxb.addActionListener(new XMLInputButtonListener());
		picLabel.add(bJaxb); 
		
		
//................................................................................................	
		userArea.addKeyListener(new KeyListener() 
		{// KeyListener()
			
		
			@Override //____________________________
			public void keyTyped(KeyEvent e) 
			{
				if(e.getKeyCode() == 10)
				{
					e.consume();
				}
			}
			
			
			@Override //____________________________
			public void keyReleased(KeyEvent e) 
			{
				//System.out.println(e.getKeyCode());
				if(e.getKeyCode() == 10)
				{
					doKey();
				}
			}
			
			
			@Override //____________________________
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == 10)
				{
					e.consume();
				}
			}
			
		});//KeyListener()
//................................................................................................		
		
		
		this.setVisible(true);	
	
	}//GameFrame Constructor

//_________________________________________________________________________________________________
	
	private void doKey() 
	{
		
		List<Integer> nextLevelIds = currentLevel.getNextLevelIds(); 

		int userAnswerIndex = Integer.parseInt(this.userArea.getText().trim());
		
		if(nextLevelIds.get(userAnswerIndex-1) != -1) 
		{
			int nextLevelId = nextLevelIds.get(userAnswerIndex-1);
			
			for(int i = 0; i < levels.size(); i++) {
				Level nextLevel = levels.get(i);
				if(nextLevel.getId() == nextLevelId) {
					currentLevel = nextLevel;
					break;
				}
			}
			
			gameTextArea.setText(currentLevel.getIntroTexts().get(0));
		    questionsArea.setText("");
		    answersArea.setText("");
		    introTextCounter = 0;
		    
		  		  
		    
		}else
		{
			new WrongFrame(); 
		}
	}
	
	private class XMLInputButtonListener implements ActionListener
	{//NextButton Class
		public void actionPerformed(ActionEvent event) 
		{
			
			String buttonText = ((JButton) event.getSource()).getText();
			try 
			{
				if(buttonText.equals("DOM"))
				{
					levels = XmlLevelInitializer.init();  //<--- hier geändert!! (XML)
				}
				
				else if(buttonText.equals("SAX"))
				{
					levels = new SAXLevelParser().parse(new File("levels.xml"));
				}
				
				else if(buttonText.equals("JAXB"))
				{
					// TODO: Kommt noch...
				}
			}  catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			currentLevel = levels.get(0);
		    gameTextArea.setText(currentLevel.getIntroTexts().get(0));  
		}
	}
		
		
		
		
	
//_________________________________________________________________________________________________
	
	private class NextButtonClickedListener implements ActionListener
	{//NextButton Class
		
		
		public void actionPerformed(ActionEvent event) 
		{
			
			
//__________IntroCounter!_________________________________________________________________________________	
			
			List<String> introTexts = currentLevel.getIntroTexts();
			
			if(introTextCounter < introTexts.size() -1) 
			{
				introTextCounter++;
			//  gameTextArea.getText(introTexts.get(introTextCounter)); <<<-------!!!!!	
				gameTextArea.setText(introTexts.get(introTextCounter));
			//	gamePicLabel.setIcon(new ImageIcon(currentLevel.getImagePath()));
				
			}
			

			
//__________Antworten nach Intro_________________________________________________________________________________
			
			if(introTextCounter == introTexts.size() -1) 
			{
				questionsArea.setText(currentLevel.getQuestion());
				
				List<String> answers = currentLevel.getAnswers();
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < answers.size(); i++) 
				{
					sb.append("["); 
					sb.append(i+1); 
					sb.append("]: "); 
					sb.append(answers.get(i)); 
					sb.append("\n\n\n");  
				}
				answersArea.setText(sb.toString());
		//		gamePicLabel.setIcon(new ImageIcon(currentLevel.getImagePath())); // <-----  die xmls haben noch keine imgs... 
			}
		} 
	
	}//NextButton Class


//__________________________________________________________________________________________________
	

	
}//GameFrame Class	
	

