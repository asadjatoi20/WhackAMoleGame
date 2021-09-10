import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
public class MainFrame extends JFrame {
	// 9 blocks of the game as 9 buttons
	JButton[] blocks = new JButton[9];
	// Mole icon stored 
	Icon icon = new ImageIcon("mole.PNG"); 
	int currentMole = 0;
	Timer timer; // to keep the paces
	int hit = 0; // number of hits
	int totalMoves = 17; // total number of moves
	int miss = 17;
	boolean gameEnded = false; // flag variable
	boolean started = false; // flag variable if game is started
	// Thread will make the scramble method invoked every second
	Thread waker;
	JButton startBtn;
	MainFrame(){
		// all buttons initialized
		blocks[0] = new JButton();
		blocks[1] = new JButton();
		blocks[2] = new JButton();
		blocks[3] = new JButton();
		blocks[4] = new JButton();
		blocks[5] = new JButton();
		blocks[6] = new JButton();
		blocks[7] = new JButton();
		blocks[8] = new JButton();
		
		this.setTitle("Mole Game");
		this.setSize(600,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		// contentPanel will hold both other panels
		JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

        // upperPanel will hold the upper start button
		JPanel upperPanel = new JPanel(new BorderLayout());
		upperPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		startBtn = new JButton("Start");
		startBtn.setEnabled(true);
		// Start the game when start button presseed
		
		startBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startBtn.setEnabled(false); 
				started = true;
				start();
				//continuosScrameble
			}
			
		});
		
		
		upperPanel.add(startBtn,BorderLayout.LINE_START);
		JLabel guide = new JLabel(" <- Click to Start"); // Label as a placeholder
		guide.setFont(new Font("Gabriel", Font.BOLD, 14));
		upperPanel.add(guide);
		
		
		// gamePanel will hold the game in it
		JPanel gamePanel = new JPanel(new GridLayout(3,3));
		gamePanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		// Random Color for the buttons
		Random rn = new Random();
		int R = rn.nextInt(200); // R in RGB Combination 
		int G = rn.nextInt(200); // G in RGB Combination
		int B = rn.nextInt(200); // B in RGB Combination
		// More randomizing so that the color shall never be black
		if(R==0) {
			R = R+34; // Randomzing 
		}
		if(G==0) {
			G = G+34; // Randomzing 
		}
		if(B==0) {
			B = B+34; // Randomzing 
		}
	
		Color c = new Color(R,G,B); // Color selected
		// setting that color to all buttons
		blocks[0].setBackground(c);
		blocks[1].setBackground(c);
		blocks[2].setBackground(c);
		blocks[3].setBackground(c);
		blocks[4].setBackground(c);
		blocks[5].setBackground(c);
		blocks[6].setBackground(c);
		blocks[7].setBackground(c);
		blocks[8].setBackground(c);
		// adding all the buttons in gamePanel
		gamePanel.add(blocks[0]);
		gamePanel.add(blocks[1]);
		gamePanel.add(blocks[2]);
		gamePanel.add(blocks[3]);
		gamePanel.add(blocks[4]);
		gamePanel.add(blocks[5]);
		gamePanel.add(blocks[6]);
		gamePanel.add(blocks[7]);
		gamePanel.add(blocks[8]);
		
		// When buttons are clicked then 
		blocks[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(started) { // if game is started then perform the action otherwise don't
					if(currentMole==0) { // the block whacked is the mole than increment hit
						hit++;

						playMusic("Whack.WAV"); // play whack sound
					
					}
					else { // if not the moled button then play laugh sound
						playMusic("Laugh.WAV");
					}
				}
			}
			
		});
		blocks[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(started) { // if game is started then perform the action otherwise don't
					if(currentMole==1) { // the block whacked is the mole than increment hit
						hit++;

						playMusic("Whack.WAV"); // play whack sound
					
					}
					else { // if not the moled button then play laugh sound
						playMusic("Laugh.WAV");
					}
				}
				
			}
			
		});
		blocks[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(started) {// if game is started then perform the action otherwise don't
					if(currentMole==2) { // the block whacked is the mole than increment hit
						hit++;

						playMusic("Whack.WAV"); // play whack sound
					
					}
					else { // if not the moled button then play laugh sound
						playMusic("Laugh.WAV");
					}
				}
			}
			
		});
		blocks[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(started) {// if game is started then perform the action otherwise don't
					if(currentMole==3) { // the block whacked is the mole than increment hit
						hit++;

						playMusic("Whack.WAV"); // play whack sound
					
					}
					else { // if not the moled button then play laugh sound
						playMusic("Laugh.WAV");
					}
				}
			}
			
		});
		blocks[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(started) {// if game is started then perform the action otherwise don't
					if(currentMole==4) { // the block whacked is the mole than increment hit
						hit++;

						playMusic("Whack.WAV"); // play whack sound
					
					}
					else { // if not the moled button then play laugh sound
						playMusic("Laugh.WAV");
					}
				}
			}
			
		});
		blocks[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(started) {// if game is started then perform the action otherwise don't
					if(currentMole==5) { // the block whacked is the mole than increment hit
						hit++;

						playMusic("Whack.WAV"); // play whack sound
					
					}
					else { // if not the moled button then play laugh sound
						playMusic("Laugh.WAV");
					}
				}
			}
			
		});
		blocks[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(started) {// if game is started then perform the action otherwise don't
					if(currentMole==6) { // the block whacked is the mole than increment hit
						hit++;

						playMusic("Whack.WAV"); // play whack sound
					
					}
					else { // if not the moled button then play laugh sound
						playMusic("Laugh.WAV");
					}
				}
			}
			
		});
		blocks[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(started) {// if game is started then perform the action otherwise don't
					if(currentMole==7) { // the block whacked is the mole than increment hit
						hit++;

						playMusic("Whack.WAV"); // play whack sound
					
					}
					else { // if not the moled button then play laugh sound
						playMusic("Laugh.WAV");
					}
				}
			}
			
		});
		blocks[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(started) {// if game is started then perform the action otherwise don't
					if(currentMole==8) { // the block whacked is the mole than increment hit
						hit++;

						playMusic("Whack.WAV"); // play whack sound
					
					}
					else { // if not the moled button then play laugh sound
						playMusic("Laugh.WAV");
					}
				}
			}
			
		});
		
		
		contentPane.add(upperPanel, BorderLayout.NORTH);
		contentPane.add(gamePanel, BorderLayout.CENTER);
		
		// Action Listeners for every button
		this.add(contentPane);

		
		
	}
	// Start method will start the thread 
	void start(){
		    // this method will continuously call the scramble method in-order to make the game run automatically without any interference 
			waker=new Thread(new Runnable(){
	        	public void run(){ // implementing the Run method of Runnable class
	        		Runnable r=new Runnable(){                
	        			public void run() {
	        				scrambleMole();  // call scrambleMole every 0.8  second
	        			}
	        			};
	                    while (totalMoves>0){ // run till moves are not over
	                    	javax.swing.SwingUtilities.invokeLater(r);
	                    	try{Thread.sleep(800); // speed of the scramble
	                    	} catch (InterruptedException ex) {  
	                    		return;
	                    	}
	                    }   
	        	}
	        });
	    waker.start();   // thread start
	}
	// method to play the sound
	public void playMusic(String soundAdd) // soundAdd be the link of that sound 
	 {
	   try {
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundAdd).getAbsoluteFile( ));
	    Clip clip = AudioSystem.getClip( );
	    clip.open(audioInputStream);
	    clip.start( );
	   }
	   catch(Exception ex)
	   {
	     JOptionPane.showMessageDialog(null,"Error with playing sound.");
	     ex.printStackTrace( );
	   }
	 }
	// Method will change the position of the mole
	public int scrambleMole() { 
		if(totalMoves==1) { // if it's the last move then
			startBtn.setEnabled(true); // resetting the start button to  normal 
			gameEnded = true;
			waker.stop(); // stopping the thread since the moives are all done
			JOptionPane.showMessageDialog(null, "Hits: "+hit+", Miss: "+(miss-hit)); // displaying the score
			
		}
		if(gameEnded) { // when the game is ended the main Screen shall reappear
			this.setVisible(false); // making older screen invisible
			MainFrame f = new MainFrame(); // newer screen
			f.setVisible(true); //  new screen visible
			
		}
		// otherwise simply scramble the imageIcon
		this.totalMoves--; // decrement total moves on each scramble
		int n=0; // the index on which the icon is placed
		blocks[currentMole].setIcon(null); // older button shouldn't have icon later
		Random rn = new Random();
		do {	 // if previous mole place and current are same then change those completely
			n = rn.nextInt(9); // 9 is exclusive this will take an integer from 0 t0 8 
		}while(n==currentMole);
		blocks[n].setIcon(icon); // setting mole icon on button
		currentMole = n;
		return n; // mole is on this index returning the index
	}
	public static void main(String[] args) {
		MainFrame f = new MainFrame();
		f.setVisible(true);
	}
}
