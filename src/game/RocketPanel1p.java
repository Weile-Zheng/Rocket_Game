package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RocketPanel1p extends JPanel implements KeyListener, ActionListener {
	public static final Dimension size = (Toolkit.getDefaultToolkit().getScreenSize());
	Star star;
	Rocket player;
	Rocket player2;
	sObstacles[] comets;

	boolean readyfornextround;
	protected int lifecount;
	protected int level;
	protected int playercount = 1;
	boolean passed = false;
	private ImageIcon icon = new ImageIcon(getClass().getResource("/game/lifered.png"));
	private ImageIcon landingzone = new ImageIcon(getClass().getResource("/game/LandingZone.png"));
	private JLabel[] lifelabels;
	private JLabel life;
	private JLabel level1;
	private JLabel level2;
	private JLabel level3;
	private JLabel h; // landingzone label
	protected JLabel levelpassed;
	protected JLabel instruction;
	private JButton nextLevel;
	private JLabel score;
	boolean starretrived;


	public RocketPanel1p(Dimension size, int level, int lifecount, Integer currentscore) {

		setSize(size);
		setFocusable(true);
		this.level = level;
		this.lifecount = lifecount;
		player = new Rocket(30, 540, 0, 0, 1);
		player2 = new Rocket(60, 540, (int) size.getWidth() - 100, 0, 2);
		star = new Star();

		h = new JLabel("", landingzone, JLabel.CENTER);
		h.setBounds(1150, 500, 105, 52);
		h.setBorder(getBorder());
		add(h);

		score = new JLabel("Score: " + Integer.toString(currentscore));
		score.setBounds((int) size.getWidth() / 2 - 150, 35, 300, 100);
		score.setFont(new Font("Times NEW Roman", Font.BOLD, 45));
		add(score);

		levelpassed = new JLabel("Level Passed");
		levelpassed.setBounds(450, 100, 500, 500);
		levelpassed.setFont(new Font("Times NEW Roman", Font.BOLD, 70));

		instruction = new JLabel("Press Space Key to Start Next Level");
		instruction.setBounds(450, 200, 500, 500);
		instruction.setFont(new Font("Times NEW Roman", Font.BOLD, 30));

		int location = 200;
		for (int i = 0; i < lifecount; i++) {
			life = new JLabel("", icon, JLabel.CENTER);
			life.setBounds(location, 10, 60, 60);
			location += 60;
			add(life);
		}

		if (level == 1) {
			comets = new sObstacles[5];
			level1 = new JLabel("Level 1");
			level1.setFont(new Font("Times NEW Roman", Font.BOLD, 50));
			level1.setBounds(1150, 600, 200, 200);
			add(level1);
			for (int i = 0; i < comets.length; i++)
				comets[i] = new sObstacles();

		} else if (level == 2) {
			comets = new sObstacles[8];
			level2 = new JLabel("Level 2");
			level2.setFont(new Font("Times NEW Roman", Font.BOLD, 50));
			level2.setBounds(1150, 600, 200, 200);
			add(level2);
			for (int i = 0; i < comets.length; i++)
				comets[i] = new sObstacles();
		}

		else if (level == 3) {
			comets = new sObstacles[12];
			level3 = new JLabel("Level 3");
			level3.setFont(new Font("Times NEW Roman", Font.BOLD, 50));
			level3.setBounds(1150, 600, 200, 200);
			add(level3);
			for (int i = 0; i < comets.length; i++)
				comets[i] = new sObstacles();
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		star.paintStar(g);
		repaint();

		for (int i = 0; i < comets.length; i++) {
			comets[i].paintObstacle(g);
		}

		player.drawRocket(g);
		player.fuel.drawFuel(g);
		player.dropping();
		player.moving();

		if (playercount == 2) {
			player2.drawRocket(g);
			player2.fuel.drawFuel(g);
			player2.dropping();
			player2.moving();
		}
		repaint();

	}

	public boolean CheckLanding(Rocket player) {
		if (player.x > 1080 && player.x < 1150 + 135 && player.y > 470 && player.y < 500 + 82) // Window Increase by 70
																								// on all 4 corners.
			return true;
		else
			return false;
	}

	public boolean Checkoutofbound(Rocket player) {
		if (player.x < 10 || player.y < 10 || player.x > 1270 || player.y > 750) {
			return true;
		} else {
			return false;
		}

	}

	public boolean CheckStar(Rocket player) {
		if(player.x-star.x<50 && player.x-star.x>-50 && player.y-star.y<50 && player.y-star.y>-50)
			return true;
		else
			return false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		
		if (CheckStar(player)) {
			System.out.println("You got Star");
			JLabel getStar = new JLabel("+25");
			getStar.setBounds(star.x+25, star.y-25, 50, 50);
			getStar.setFont(new Font("Times New Roman", Font.BOLD, 20));
			add(getStar);
			repaint();
			starretrived=true;
		}
		
		
		if (450 - 90 - player.fuel.count * 12 == 0) {
			player.movable = false;
		}

		if (Checkoutofbound(player) && lifecount > 1 && passed == false) {
			JLabel outofbound = new JLabel("Out of Bound. Press C to continue");
			outofbound.setBounds(20, 400, 1500, 300);
			outofbound.setFont(new Font("Times NEW Roman", Font.BOLD, 70));
			add(outofbound);
		}
		if (Checkoutofbound(player) && lifecount == 1 && passed == false) {// Last Life
			JLabel losemessage = new JLabel("Game Over, You Lost. Return to Main Menu");
			losemessage.setBounds(20, 400, 1500, 500);
			losemessage.setFont(new Font("Times NEW Roman", Font.BOLD, 50));
			add(losemessage);
		}

		if (CheckLanding(player)) {
			System.out.println("Land success Player 1");
			add(levelpassed);
			passed = true;

			if (level == 3) {
				JLabel winmessage = new JLabel("Game Over, You Won");
				winmessage.setBounds(450, 400, 500, 500);
				winmessage.setFont(new Font("Times NEW Roman", Font.BOLD, 70));
				add(winmessage);
			}

			else {
				add(instruction);
			}
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

	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_W) {
			player.jetting = false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (Math.sqrt(Math.pow(player.x - star.x, 2) + Math.pow(player.y - star.y, 2)) < 20) {
			star.retrieved = true;
			System.out.println("Star gathered");
			// player得分
		} else if (Math.sqrt(Math.pow(player2.x - star.x, 2) + Math.pow(player2.y - star.y, 2)) < 20) {
			star.retrieved = true;
			// player2得分
		}
	}
}
