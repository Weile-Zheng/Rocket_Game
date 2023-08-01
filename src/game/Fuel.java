package game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fuel{
	int x;
	int y;
	double fuelAmount;
	static final double height = 50;
	int count = 0;

	public Fuel(int x, int y) {
        this.x = x;
        this.y = y;
        fuelAmount = height;
    }

	public void drawFuel(Graphics g) {
		int sAngle = 90 + count * 12;
		int arcAngle = 450 - sAngle;
//		g.fillRect(x, y, width, (int)height);
		g.fillArc(x, y, 100, 100, sAngle, arcAngle);
	}

	public void usingFuel() {
		count += 1.5;
	}

	
}
