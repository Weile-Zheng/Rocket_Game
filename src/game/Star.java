package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Star implements ActionListener{
	int x, y;
	Timer time = new Timer(1000, this);
	static Dimension size = (Toolkit.getDefaultToolkit().getScreenSize());
	int xRange = (int) size.getWidth();
	int yRange = (int) size.getHeight();
	boolean retrieved = false;
	
	public Star() {
        Random rm = new Random();
        x = rm.nextInt(xRange-150) + 150;
        y = rm.nextInt(yRange-150) + 150;
	}
	public Star(int x,int y){
	    this.x = x;
	    this.y = y;
    }
	
    protected void paintStar(Graphics g){
		if(!retrieved){
            Graphics2D g1 = (Graphics2D) g;
            g1.setColor(Color.WHITE);
            g1.fillRect(0, 0, (int)size.getWidth(), (int)size.getHeight());
            g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g1.setColor(Color.ORANGE);
            g1.fill(createDefaultStar(50, x, y));
            time.start();
        }
    }

    private static Shape createDefaultStar(double radius, double centerX, double centerY){
        return createStar(centerX, centerY, radius/4, radius * 0.53, 5, Math.toRadians(-18));
    }

    private static Shape createStar(double centerX, double centerY, double innerRadius, 
    		double outerRadius, int numRays, double startAngleRad){
        Path2D path = new Path2D.Double();
        double deltaAngleRad = Math.PI / numRays;
        for (int i = 0; i < numRays * 2; i++){
            double angleRad = startAngleRad + i * deltaAngleRad;
            double ca = Math.cos(angleRad);
            double sa = Math.sin(angleRad);
            double relX = ca;
            double relY = sa;
            if ((i & 1) == 0){
                relX *= outerRadius;
                relY *= outerRadius;
            }
            else{
                relX *= innerRadius;
                relY *= innerRadius;
            }
            if (i == 0){
                path.moveTo(centerX + relX, centerY + relY);
            }
            else{
                path.lineTo(centerX + relX, centerY + relY);
            }
        }
        path.closePath();
        return path;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(x>0 && x<xRange-300) {
		}
	}
    
}