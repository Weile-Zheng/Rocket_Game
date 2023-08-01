package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Scoreboard extends JPanel {
	public static final Dimension size = (Toolkit.getDefaultToolkit().getScreenSize());

	public Scoreboard(Dimension size, ArrayList leaderboard) {

		Collections.sort(leaderboard);
		int last = leaderboard.size();

		setSize(size);
		JLabel label1 = new JLabel("ScoreBoard");
		JLabel label2 = new JLabel("1: " + Integer.toString((int) leaderboard.get(last-1)));
		JLabel label3 = new JLabel("2: " + Integer.toString((int) leaderboard.get(last-2)));
		JLabel label4 = new JLabel("3: " + Integer.toString((int) leaderboard.get(last-3)));
		JLabel label5 = new JLabel("4: " + Integer.toString((int) leaderboard.get(last-4)));
		JLabel label6 = new JLabel("5: " + Integer.toString((int) leaderboard.get(last-5)));

		label1.setBounds(550, 50, 300, 100);
		label2.setBounds(550, 125, 400, 100);
		label3.setBounds(550, 200, 400, 100);
		label4.setBounds(550, 275, 400, 100);
		label5.setBounds(550, 350, 400, 100);
		label6.setBounds(550, 425, 400, 100);

		label1.setFont(new Font("Times NEW Roman", Font.BOLD, 50));
		label2.setFont(new Font("Times NEW Roman", 1, 20));
		label3.setFont(new Font("Times NEW Roman", 1, 20));
		label4.setFont(new Font("Times NEW Roman", 1, 20));
		label5.setFont(new Font("Times NEW Roman", 1, 20));
		label6.setFont(new Font("Times NEW Roman", 1, 20));

		label2.setForeground(new Color(255, 215, 0));
		label3.setForeground(new Color(192, 192, 192));
		label4.setForeground(new Color(184, 115, 51));

		add(label1);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		add(label6);
		setLayout(null);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		repaint();

	}

}
