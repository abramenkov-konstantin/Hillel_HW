package gui;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class XData 
{
	Color col = Color.black;
	int width = 1;
	String figure = "Paint";
	BufferedImage bi = new BufferedImage (500, 500, BufferedImage.TYPE_INT_BGR);
	
	public XData()
	{
		Graphics2D g = (Graphics2D) bi.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, 500, 500);
	}
}
