package pwr_concurrency_proj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;

public class Meadow extends JComponent
{	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < MEADOW_WIDTH; i+=64 )
			for (int j = 0; j < FRAME_HEIGHT; j+=64 )
			{
				Grass grass = new Grass(i,j);
				this.grassFieldsArray.add(grass);
				System.out.print(grassFieldsArray);
				g2.setColor(grass.getColor());
				g2.fillRect(grass.getX(),grass.getY(),64,64);
			}
		this.add(addSnailButton);
		changeSnailButtonProperties(g2);
	}
	private void changeSnailButtonProperties(Graphics2D g2) 
	{
		addSnailButton.setLocation(700, 50);
		addSnailButton.setSize(100,50);
		addSnailButton.setVisible(true);
		Snail snail = new Snail(this);
		this.snailsArray.add(snail);
		System.out.println(snail.toString());
		addSnailButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				g2.setColor(snail.getColor());
				g2.drawOval(snail.getX(), snail.getY(), snail.getWidth(), snail.getHeight());
				g2.fillOval(snail.getX(), snail.getY(), snail.getWidth(), snail.getHeight());
				repaint();
				System.out.println("actionPerformed");
			}
		});
		
	}
	
	public ArrayList<Grass> getFieldsArray()
	{
		return grassFieldsArray;
	}
	private JButton addSnailButton = new JButton ("Add snail");
	private ArrayList<Snail> snailsArray = new ArrayList<>();
	private ArrayList<Grass> grassFieldsArray = new ArrayList<>();
	public static final int MEADOW_WIDTH = 640;
	public static final int FRAME_WIDTH = 880;
	public static final int FRAME_HEIGHT = 640;

}
