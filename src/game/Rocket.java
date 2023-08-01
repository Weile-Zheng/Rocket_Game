package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rocket  {
    final static double G = 0.00006;
    double direction;
    double x;
    double y;
    double xSpeed;
    double ySpeed;
    boolean movable = true;
    boolean broken = false;
    boolean jetting = false;
    Fuel fuel;
    int life = 3;
    int rocketnumber;
    
    public Rocket(int x,int y,int cpx,int cpy, int rocketnumber){
        this.x = x;
        this.y = y;
        fuel = new Fuel(cpx,cpy);
        xSpeed = 0;
        ySpeed = 0;
        direction = -1*(Math.PI/2);
        this.rocketnumber = rocketnumber;
    }
    
    public void drawRocket(Graphics g){
        if(!broken){
            int lux = (int)(Math.cos(direction-0.5)*40+x);
            int luy = (int)(Math.sin(direction-0.5)*40+y);
            int rux = (int)(Math.cos(direction+0.5)*40+x);
            int ruy = (int)(Math.sin(direction+0.5)*40+y);
            int ldx = (int)(Math.cos(direction+0.5+Math.PI)*40+x);
            int ldy = (int)(Math.sin(direction+0.5+Math.PI)*40+y);
            int rdx = (int)(Math.cos(direction-0.5+Math.PI)*40+x);
            int rdy = (int)(Math.sin(direction-0.5+Math.PI)*40+y);
            int topx = (int)(Math.cos(direction)*60+x);
            int topy = (int)(Math.sin(direction)*60+y);
            int lfx = (int)(Math.cos(direction+0.3+Math.PI)*36+x);
            int lfy = (int)(Math.sin(direction+0.3+Math.PI)*36+y);
            int rfx = (int)(Math.cos(direction-0.3+Math.PI)*36+x);
            int rfy = (int)(Math.sin(direction-0.3+Math.PI)*36+y);
            int botx1 = (int)(-Math.cos(direction)*60+x);
            int boty1 = (int)(-Math.sin(direction)*60+y);
            int botx2 = (int)(-Math.cos(direction)*50+x);
            int boty2 = (int)(-Math.sin(direction)*50+y);
            int lmx = ldx+(int)(Math.cos(direction)*25);
            int lmy = ldy+(int)(Math.sin(direction)*25);
            int rmx = rdx+(int)(Math.cos(direction)*25);
            int rmy = rdy+(int)(Math.sin(direction)*25);
            int lwx = ldx+(int)(Math.cos(direction-Math.PI/2)*25);
            int lwy = ldy+(int)(Math.sin(direction-Math.PI/2)*25);
            int rwx = rdx+(int)(Math.cos(direction+Math.PI/2)*25);
            int rwy = rdy+(int)(Math.sin(direction+Math.PI/2)*25);
            int[]rectXs1 = {lux,rux,rdx,ldx};
            int[]rectYs1 = {luy,ruy,rdy,ldy};
            int[]trigXs1 = {lux,rux,topx};
            int[]trigYs1 = {luy,ruy,topy};
            int[]trigXs2 = {ldx,rdx,botx1};
            int[]trigYs2 = {ldy,rdy,boty1};
            int[]trigXs3 = {lfx,rfx,botx2};
            int[]trigYs3 = {lfy,rfy,boty2};
            int[]trigXs4 = {ldx,lwx,lmx};
            int[]trigYs4 = {ldy,lwy,lmy};
            int[]trigXs5 = {rdx,rwx,rmx};
            int[]trigYs5 = {rdy,rwy,rmy};
            if(rocketnumber ==1) {
            g.setColor(Color.red);
            }
            else {
            	g.setColor(Color.blue);
            }
            g.fillPolygon(trigXs1,trigYs1,3);
            g.fillPolygon(trigXs4,trigYs4,3);
            g.fillPolygon(trigXs5,trigYs5,3);
            if(jetting&&movable){
                g.setColor(Color.ORANGE);
                g.fillPolygon(trigXs2,trigYs2,3);
                g.setColor(Color.YELLOW);
                g.fillPolygon(trigXs3,trigYs3,3);
                g.setColor(Color.BLACK);
                g.drawPolygon(trigXs2,trigYs2,3);
                g.drawPolygon(trigXs3,trigYs3,3);
            }
            g.setColor(Color.BLACK);
            g.drawPolygon(rectXs1,rectYs1,4);
            g.drawPolygon(trigXs1,trigYs1,3);

            g.drawPolygon(trigXs4,trigYs4,3);
            g.drawPolygon(trigXs5,trigYs5,3);
        }
    }
    public void accelerate(){
        if(movable==true){
            xSpeed+= 0.05*(Math.cos(direction));
            ySpeed+= 0.05*(Math.sin(direction));
            fuel.count+=1;
        }
    }
    public void rotateRight(){
        direction+=0.3;
    }
    public void rotateLeft(){
        direction-=0.3;
    }
    public void moving(){
        x+=xSpeed;
        y+=ySpeed;
    }
    public void dropping(){
        ySpeed+=G;
    }

	
		
		
	
}



