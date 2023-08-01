package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

public class sObstacles {

	int x, y, width, xRange, yRange;
	private Dimension size1 = (Toolkit.getDefaultToolkit().getScreenSize());

	public sObstacles() {
//        setBackground(Color.WHITE);
////        setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setSize(size1);
//        setVisible(true);
//        setFocusable(true);
//        setLayout(null);
//		addKeyListener(this);
		xRange = (int) size1.getWidth();
		yRange = (int) size1.getHeight();

		Random random = new Random();
		x = random.nextInt(xRange - 150) + 1;
		y = random.nextInt(yRange - 150) + 1;
		width = random.nextInt(80) + 20;

	}

	public void paintObstacle(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillPolygon(
				new int[] { x + width / 2, x, x - width / 4, x - width / 8, x + 5 * width / 8, x + 3 * width / 4 },
				new int[] { y, y, y + 2 * width / 5, y + width, y + width, y + 2 * width / 5 }, 6);
		g.setColor(Color.DARK_GRAY);
		g.drawLine(x + width / 2, y + 7 * width / 8, x + 5 * width / 8, y + 2 * width / 5);
		g.drawLine(x + width / 2, y + 7 * width / 8, x - width / 16, y + 14 * width / 15);
	}

//    @Override
//    public void keyTyped(KeyEvent e) {}
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        if(e.getKeyCode() == KeyEvent.VK_B) {
//            repaint();
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {}

//	public static void main(String[] args) {
//		new sObstacles();
//	}
}
