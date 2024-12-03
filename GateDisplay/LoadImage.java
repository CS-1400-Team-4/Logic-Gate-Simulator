import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LoadImage 
{
	String fileName;
	BufferedImage img, scaledImg;
	Graphics2D g2d;
	JLabel imgLabel;
	int x, y, width, height, newWidth, newHeight;
	double scaleFactor;
	public LoadImage(String fileName, int x,int y, double scaleFactor) throws IOException 
	{
		this.fileName=fileName;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.scaleFactor=scaleFactor;
		setImage();
		setJLabel();
	}

	public void setImage() throws IOException 
	{
		 img = ImageIO.read(new File(fileName));

		 // Scale the image to 80% of its original size
		 //scaleFactor = 0.5;
		 newWidth = (int) (img.getWidth() * scaleFactor);
		 newHeight = (int) (img.getHeight() * scaleFactor);
		 
		 // Create a new BufferedImage to hold the scaled image
		 scaledImg = new BufferedImage(newWidth, newHeight, img.getType());
		 
		 // Get Graphics2D object for drawing
		 g2d = scaledImg.createGraphics();
		 
		 // Draw the original image scaled to the new size
		 g2d.drawImage(img, 0, 0, newWidth, newHeight, null);
		 g2d.dispose();
		
		
	}
	public BufferedImage getImage() 
	{
		return scaledImg;
	}

	public void setJLabel() 
	{
		imgLabel = new JLabel(new ImageIcon(getImage()));
		imgLabel.setOpaque(true);
		imgLabel.setBounds(x/2,y/2-100,newWidth,newHeight);
		
	}
	
	public JLabel getJLabel() 
	{
		return imgLabel;
	}
	public int getW() 
	
	{
		return newWidth;
	}
	public int getH() 
	{
		return newHeight;
	}
	public int getLabelX() 
	{
		return imgLabel.getX();
	}
	public int getLabelY() 
	{
		return imgLabel.getY();
	}
}
