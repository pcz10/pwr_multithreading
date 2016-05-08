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
	
	private static int idHelper = 1;
	private int id;
	private int x;
	private int y;
	private boolean taken = false;
	private Color color = new Color(0,51,0);
}
