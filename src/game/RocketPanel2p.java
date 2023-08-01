package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RocketPanel2p extends RocketPanel1p {
	ImageIcon icon = new ImageIcon(getClass().getResource("/game/lifeblue.png"));
	JLabel[] lifelabels;
	JLabel life;
	int lifecount2;
	boolean player1alive = true;
	boolean player2alive = true;
	boolean passed = false;

	public RocketPanel2p(Dimension size, int level, int lifecount1, int lifecount2, int currentscore2) {
		super(size, level, lifecount1, currentscore2);
		this.lifecount2 = lifecount2;
		playercount++;

		int location = (int) size.width - 100 - 200;
		
		for (int i = 0; i < lifecount2; i++) {
			life = new JLabel("", icon, JLabel.CENTER);
			life.setBounds(location, 10, 60, 60);
			location -= 60;
			add(life);

		}

	}

	public void keyPressed(KeyEvent e) {
		
		
		if(450-90-player.fuel.count*12==0) {
			player.movable = false;
		}
		
		if(450-90-player2.fuel.count*12==0) {
			player2.movable = false;
		}
		

		if (Checkoutofbound(player) && lifecount > 1 && passed ==false) {
			player1alive = false;
		}

		if (Checkoutofbound(player2) && lifecount > 1 && passed ==false) {
			player2alive = false;
		}

		if (player1alive == false && player2alive == false) {
			JLabel outofbound = new JLabel("Out of Bound. Press C to continue");
			outofbound.setBounds(20, 400, 1500, 300);
			outofbound.setFont(new Font("Times NEW Roman", Font.BOLD, 70));
			add(outofbound);
		}

		if (Checkoutofbound(player) && Checkoutofbound(player2) && lifecount == 1 && lifecount2 ==1 && passed == false) {// Last Life
			JLabel losemessage = new JLabel("Game Over, You Lost. Return to Main Menu");
			losemessage.setBounds(20, 400, 1500, 500);
			losemessage.setFont(new Font("Times NEW Roman", Font.BOLD, 50));
			add(losemessage);
		}

		if (CheckLanding(player) || CheckLanding(player2)) {
			System.out.println("Land success Player 1");
			add(levelpassed);
			add(instruction);
			passed = true;

		}

		if ((CheckLanding(player) && level == 3) || CheckLanding(player2) && level==3 ) {
			JLabel winmessage = new JLabel("Game Over, You Won!");
			winmessage.setBounds(450, 400, 1000, 500);
			winmessage.setFont(new Font("Times NEW Roman", Font.BOLD, 70));
			add(winmessage);

		}
		

		if (e.getKeyCode() == KeyEvent.VK_W) {
			player.jetting = true;
			player.accelerate();
			if (player.fuel.count * 3 + 90 == 450) {
				player.movable = false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			player.rotateRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			player.rotateLeft();
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player2.jetting = true;
			player2.accelerate();
			if (player2.fuel.count * 3 + 90 == 450) {
				player2.movable = false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player2.rotateRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player2.rotateLeft();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			player.jetting = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player2.jetting = false;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {

	}
	
}