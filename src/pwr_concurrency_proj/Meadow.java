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
	public Meadow()
	{
		fillArrayOfFields();
		this.meadow = this;
	}
	
	public void fillArrayOfFields()
	{
		for(int i =0; i<640; i+= 64)
			for(int j=0;j<640; j+=64)
			{
				Grass grass = new Grass(i,j);
				this.grassFieldsArray.add(grass);
			}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(int i = 0; i < grassFieldsArray.size() ; ++i)
		{
			g2.setColor(this.grassFieldsArray.get(i).getColor());
			g2.fillRect(this.grassFieldsArray.get(i).getX(), this.grassFieldsArray.get(i).getY(), 64, 64);
		}
		this.add(addSnailButton);
		addSnailButton.setLocation(MEADOW_WIDTH + 60, 100);
		addSnailButton.setSize(100, 50);
		addSnailButton.setVisible(true);
		System.out.println("Snails array size : " + snailsArray.size());
		addSnailButton.addActionListener(new Snail(this));

		for(int i = 1; i < snailsArray.size() ; ++i)
		{
			g2.setColor(this.snailsArray.get(i).getColor());
			g2.fillOval(this.snailsArray.get(i).getX(), this.snailsArray.get(i).getY(), 64, 64);
		}
	}


	public ArrayList<Grass> getFieldsArray()
	{
		return grassFieldsArray;
	}
	public ArrayList<Snail> getSnailsArray()
	{
		return snailsArray;
	}
	


	public Meadow meadow;
	private JButton addSnailButton = new JButton("Add snail");
	private ArrayList<Snail> snailsArray = new ArrayList<>();
	private ArrayList<Grass> grassFieldsArray = new ArrayList<>();
	public static final int MEADOW_WIDTH = 640;
	public static final int FRAME_WIDTH = 880;
	public static final int FRAME_HEIGHT = 640;

}
