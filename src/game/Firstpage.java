package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Firstpage extends JFrame implements ActionListener, KeyListener {

	private int currentlevel = 1;
	private int currentlevel2 = 1;
	private int lifecount = 3;
	private int lifecount2 = 3;
	private Integer currentscore = 100;
	Integer currentscore2 = 100;

	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton menubutton;
	private ImageIcon icon = new ImageIcon(getClass().getResource("/game/HomeImage.jpg"));
	private ImageIcon icon2 = new ImageIcon(getClass().getResource("/game/image1.jpg"));

	public static final Dimension size = (Toolkit.getDefaultToolkit().getScreenSize());
	private RocketPanel1p mp;
	private RocketPanel2p mp2;
	private Scoreboard scoreboard;
	private JLabel background;
	private JLabel background2;
	private boolean mprunning = false;
	private boolean mp2running = false;
	private ArrayList<Integer> leaderboard;

	Firstpage() {

		super("Rocket Game");
		mp = new RocketPanel1p(size, currentlevel, lifecount, currentscore);
		mp2 = new RocketPanel2p(size, currentlevel, lifecount, lifecount, currentscore2);
		setSize(1920, 1080);
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		addKeyListener(this);
		background = new JLabel("", icon, JLabel.CENTER);
		background.setBounds(0, 0, 1920, 1080);

		background2 = new JLabel("", icon2, JLabel.CENTER);
		background.setBounds(0, 0, 1920, 1080);

		// Starting Menu Buttons
		button1 = new JButton("Singer Player");
		button2 = new JButton("Two Player");
		button3 = new JButton("Score Board");
		button4 = new JButton("Credits");
		button5 = new JButton("Exit");

		menubutton = new JButton("RETURN TO MENU");
		button1.setFont(new Font("Times NEW Roman", Font.BOLD, 20));
		button2.setFont(new Font("Times NEW Roman", Font.BOLD, 20));
		button3.setFont(new Font("Times NEW Roman", Font.BOLD, 20));
		button4.setFont(new Font("Times NEW Roman", Font.BOLD, 20));
		button5.setFont(new Font("Times NEW Roman", Font.BOLD, 20));
		menubutton.setFont(new Font("Times NEW Roman", Font.BOLD, 20));
		button1.setBounds(((int) size.getWidth() / 2) - 100, 380, 150, 50);
		button2.setBounds(((int) size.getWidth() / 2) - 100, 455, 150, 50);
		button3.setBounds(((int) size.getWidth() / 2) - 100, 530, 150, 50);
		button4.setBounds(((int) size.getWidth() / 2) - 100, 605, 150, 50);
		button5.setBounds(((int) size.getWidth() / 2) - 100, 680, 150, 50);
		menubutton.setBounds((int) size.getWidth() / 2 - 150, 10, 300, 50);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);

		menubutton.addActionListener(this);

		JLabel label = new JLabel("Rocket Game"); // Label must be added before the background label
		label.setBounds(((int) size.getWidth() / 2) - 160, 30, 500, 500);
		label.setFont(new Font("Times NEW Roman", Font.BOLD, 50));
		label.setForeground(Color.pink);

		add(label);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		// Background label must be added after buttons. Confusing right?
		add(background);

		setLayout(null);

		leaderboard = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			leaderboard.add(0);
		}

		scoreboard = new Scoreboard(size, leaderboard);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button1) {
			System.out.println("Single Player Mode Began");
			addKeyListener(mp);
			add(mp);
			mp.add(menubutton);
			mprunning = true;
			requestFocusInWindow();

		} else if (e.getSource() == button2) {
			System.out.println("Double Player Mode Began");
			addKeyListener(mp2);
			add(mp2);
			mp2.add(menubutton);
			mp2running = true;
			requestFocusInWindow();

		} else if (e.getSource() == button3) {
			System.out.println("Enter Scoreboard Page");
			add(scoreboard);
			scoreboard.add(menubutton);
			// scoreboard.add(background);
			requestFocusInWindow();

		} else if (e.getSource() == button4) {
			new Credits();
		}

		else if (e.getSource() == menubutton) {
			if (mprunning == true || mp2running == true) {
				leaderboard.add(currentscore);
			}
			remove(mp);
			remove(mp2);
			remove(scoreboard);
			currentlevel = 1;
			currentlevel2 = 1;
			lifecount = 3;
			lifecount2 = 3;
			currentscore = 100;
			currentscore2 = 100;

			scoreboard = new Scoreboard(size, leaderboard);

			// Reinitiate the panel so we don't call the one that we just quit
			// But we want to maintain scoreboard so we don't do the same for scoreboard
			mp = new RocketPanel1p(size, currentlevel, 3, currentscore);
			mp2 = new RocketPanel2p(size, currentlevel, 3, 3, currentscore2);
			repaint();
			mprunning = false;
			mp2running = false;
		}

		else {
			System.exit(0);

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_SPACE && currentlevel < 3 && mprunning == true) {
			System.out.println("Next Level Began");
			currentlevel++;
			currentscore += 100;

			if (mp.starretrived == true)
				currentscore += 35;

			mp.starretrived = false;

			remove(mp);
			mp = new RocketPanel1p(size, currentlevel, lifecount, currentscore);
			add(mp);
			addKeyListener(mp);
			repaint();
			mp.add(menubutton);

		}

		else if (e.getKeyCode() == KeyEvent.VK_SPACE && currentlevel < 3 && mp2running == true) {
			System.out.println("Next Level Began");
			currentlevel2++;
			currentscore += 100;

			if (mp2.player1alive == false)
				lifecount--;
			else if (mp2.player2alive == false)
				lifecount2--;

			remove(mp2);

			try {
				mp2 = new RocketPanel2p(size, currentlevel2, lifecount, lifecount2, currentscore);
			} catch (Exception NullPointerException) {
				System.out.println("");
			}

			add(mp2);
			addKeyListener(mp2);
			repaint();
			mp2.add(menubutton);
		}

		if (e.getKeyCode() == KeyEvent.VK_C && lifecount > 1 && mprunning == true) {
			lifecount--;
			currentscore -= 25;

			/*
			 * if (mp.starretrived ==true) currentscore += 25; mp.starretrived =false;
			 */

			remove(mp);
			mp = new RocketPanel1p(size, currentlevel, lifecount, currentscore);
			add(mp);
			addKeyListener(mp);
			repaint();
			mp.add(menubutton);
		}

		if (e.getKeyCode() == KeyEvent.VK_C && lifecount > 1 && mp2running == true) {
			lifecount--;
			lifecount2--;
			currentscore -= 25;

			remove(mp2);
			mp2 = new RocketPanel2p(size, currentlevel, lifecount, lifecount2, currentscore2);
			add(mp2);
			addKeyListener(mp2);
			repaint();
			mp2.add(menubutton);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public static void main(String[] args) {
		Music playmusic = new Music();
		playmusic.start();
		new Firstpage();

	}
}
