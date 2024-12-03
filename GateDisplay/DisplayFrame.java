import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JTextField;

public class DisplayFrame
{
	JFrame frame;
	JTextField userInput;
	JLabel message, lines;
	JButton nextButton;
	int x, y;
	LoadImage gate;
	public DisplayFrame() 
	{
		frame = new JFrame("Display Window");
		x = 800;
		y = 600;
		
		
	}
	public void display() throws IOException 
	{
		String andFile = "notGate2.png";
		nextButton = new JButton("Next");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(x,y);
		
		
		message = new JLabel("Type a boolean expression");
		message.setBounds((x/2)-50,(y/2)-50,250,25);
		message.setFont(new Font("Ariel", Font.PLAIN, 20));
		message.setOpaque(true);
		
		//add text field
		userInput = new JTextField(10);
		userInput.setBounds(x/2, y/2,100,25);
		userInput.setOpaque(true);
		
		//gate = new LoadImage(andFile, x,y,0.5);
		
		nextButton.setBounds((x/2), (y/2)+100, 85, 40);
		
		frame.add(userInput);
		frame.add(message);
		//frame.add(and.getJLabel());
		frame.add(nextButton);
		
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public JFrame getFrame() 
	{
		return frame;
	}
	public int getY() 
	{
		return y;
	}
	public int getX() 
	{
		return x;
	}
		
}