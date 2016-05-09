package pwr_concurrency_proj;

import java.awt.Color;

import javax.swing.JComponent;

public class Grass extends JComponent
{
	public Grass(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.id = this.idHelper;
		this.idHelper++;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public Color getColor()
	{
		return color;
	}
	public boolean isTaken()
	{
		return taken;
	}
	public void setTaken()
	{
		this.taken = true;
	}
	@Override
	public String toString() {
		return "Grass [x=" + x + ", y=" + y + ", id=" + id + ", color=" + color + "]\n";
	}
	
	public void changeGrassLevel()
	{
		for(Color color : grassColors)
			{
				this.color = color;
				repaint();
			}
	}

	private static int idHelper = 1;
	private int id;
	private int x;
	private int y;
	private boolean taken = false;
	private Color color = new Color(0,51,0);
	private Color[] grassColors = 
	{
		new Color(0,51,0),
		new Color(0,102,0),
		new Color(0,153,0),
		new Color(0,204,0),
		new Color(51,255,51),
		new Color(102,255,102),
		new Color(153,255,153),
		new Color(102,51,0),
	};
}

