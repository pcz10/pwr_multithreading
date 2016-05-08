package pwr_concurrency_proj;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Simulator extends JPanel
{
	public static void main(String [] args)
	{
		SwingUtilities.invokeLater(new Runnable(){
		public void run()
		{
			Meadow meadow = new Meadow();
			JFrame frame = new JFrame("snails simulator");	
			frame.setSize(Meadow.FRAME_WIDTH, Meadow.FRAME_HEIGHT);
			frame.getContentPane().add(meadow);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.setLayout(new BorderLayout());
		}

		});
	}
}
