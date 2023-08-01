package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class Credits extends JDialog{
	
	
	
	Credits(){ 
		setBounds(50,50,800,250);
		setVisible(true);
		
		JLabel label1 = new JLabel("Contributors and Contacts");
		JLabel label2 = new JLabel("Weile Zheng - wzheng13@u.rochester.edu");
		JLabel label3 = new JLabel("Peter Nie - jnie7@u.rocester.edu");
		JLabel label4 = new JLabel("Jinglin Zheng - jzheng20@u.rochester.edu");
		JLabel label5 = new JLabel("Shiyou Li - sli121@u.rochester.edu");
			
		label1.setBounds(50,85 ,500,25);
		label2.setBounds(520, 60,400,100);
		label3.setBounds(520, 80,400,100);
		label4.setBounds(520, 100,400,100);
		label5.setBounds(520, 120,400,100);
		
		label1.setFont(new Font("Times NEW Roman",Font.BOLD,30));
		label2.setFont(new Font("Times NEW Roman",1,15));
		label3.setFont(new Font("Times NEW Roman",1,15));
		label4.setFont(new Font("Times NEW Roman",1,15));
		label5.setFont(new Font("Times NEW Roman",1,15));
		
		add(label1);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		
		setLayout(null);
		
	}
}