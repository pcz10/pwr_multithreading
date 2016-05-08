package pwr_concurrency_proj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JComponent;

public class Snail extends JComponent implements Runnable,ActionListener
{
	public Snail(Meadow meadow)
	{
		this.controlVariable = meadow;
		this.snailId = this.idHelper;
		this.idHelper++;
		generateField();
		this.controlVariable.getSnailsArray().add(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new Snail(this.controlVariable);
		System.out.println(controlVariable.getSnailsArray().toString());
	}
	public Grass generateField()
	{
		Grass grass = generateGrassField();
		if (grass.isTaken())
			grass = generateGrassField();
		grass.setTaken();
		this.x = grass.getX();
		this.y = grass.getY();
		return grass;
	}

	private Grass generateGrassField() 
	{
		int index = randomGenerator.nextInt(this.getMeadow().getFieldsArray().size());
		Grass grass = this.controlVariable.getFieldsArray().get(index);
		return grass;
	}
	
	public Meadow getMeadow()
	{
		return controlVariable;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	public Color getColor()
	{
		return color;
	}

	
	@Override
	public void run() 
	{
		
	}
	
	@Override
	public String toString() {
		return "Snail [snailId= " + snailId + " x= " + x + " y= " + y + "]\n";
	}

	private Color color = new Color(12,53,201);
	private Random randomGenerator = new Random();
	private Meadow controlVariable;
	private static int idHelper = 1;
	private int x;
	private int y;
	private final int width = 64;
	private final int height = 64;
	private int snailId;
}
