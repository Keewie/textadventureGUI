package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.OverlayLayout;

public class StartFrame extends JFrame 
{
	public static void main(String[] args) throws IOException 
	{
		
		new GameFrame(); 
	 // new StartFrame(); // Das Startfenster
	 // new WrongFrame();
	 // new TrennungTestFrame();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3123684149704907948L;
	JLabel label; // Das Label f�r das Startbild
	JLabel welcome; // Willkommen -Text
	JLabel nameOfGame; // Alltag eines Blinden -Text
	ImageIcon startPic; // Bild f�r das Startfenster
	JButton bStart; // Der Startbutton
	Font fontWelcome; // schriftstil f�r willkommen
	Font fontNameOfGame; // schriftstil f�r spielname

	public StartFrame() // Der Konstruktor f�r JFrame
	
	{

		// Das Fenster
		this.setLayout(new OverlayLayout(bStart)); // default FlowLayout
		this.setTitle("Der Alltag eines Blinden");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setLocation(520, 20);
		this.setSize(925, 990);

		
	

		
		
		
		// Label vom Hintergrundbild
		startPic = new ImageIcon("Bilder Alltag/mainpic.jpg");
		label = new JLabel(startPic);
		this.add(label);

		
		// Der Button
		bStart = new JButton();
		bStart.setIcon(new ImageIcon("Bilder Alltag//buttonlogo.jpg"));
		bStart.setContentAreaFilled(false); // Button "durchsichtig machen"
		bStart.setLayout(null);
		bStart.setBounds(790, 590, 300, 130);
		label.add(bStart);

		fontWelcome = new Font("Gentium Basic", Font.ITALIC + Font.BOLD, 85); // Font f�r Willkommen
		fontNameOfGame = new Font("Gentium Basic", Font.ITALIC, 60); // Font f�r Gamenamen
																		

		// Label f�r den Willkommen-Schriftzug
		welcome = new JLabel("Willkommen!");
		welcome.setBounds(730, 250, 800, 300);
		welcome.setFont(fontWelcome);
		welcome.setForeground(Color.WHITE);
		label.add(welcome);

		// Label f�r den Gamename-Schriftzug
		nameOfGame = new JLabel("- Der Alltag eines Blinden -");
		nameOfGame.setBounds(660, 40, 900, 300);
		nameOfGame.setFont(fontNameOfGame);
		nameOfGame.setForeground(Color.WHITE);
		label.add(nameOfGame);

		this.setVisible(true);

		StartHandler startHandler = new StartHandler();
		bStart.addActionListener(startHandler);
	}

	
	private class StartHandler implements ActionListener 
	{

		public void actionPerformed(ActionEvent event) 
		{
			new GameFrame();
			StartFrame.this.dispose();
		}

	}

}
