import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class DisplayGateOutput extends JPanel implements ActionListener
{
    public static int x = 200;
    public static int y = 300;
    public static String strGateName;
    public JFrame frame;
    public static String strVariable;
    public static JLabel strLabel;
    public static int xLabel=x/4, yLabel=y/4, wLabel=100, hLabel=20;
    public static int xCircle=xLabel+15, yCircle=yLabel+20, wCircle=10, hCircle=10;
    public static HashMap<String, Boolean> inputValues;    
    public static boolean output;
    public static String strOutput;
    public static JLabel outputLabel;
    public static JButton button = new JButton("Next");
    public static int xButton=x/2, yButton=y/2, wButton=wLabel+35, hButton=hLabel+10;
    public static boolean status=false;
    public DisplayGateOutput(String strGateName, boolean output)
    {
    	this.strOutput = "OUTPUT";
        this.strGateName = strGateName;
        this.output = output;
        this.inputValues = inputValues;
        orValueLabel();
        setLayout(null);                              
    }
               
    // Override paintComponent to draw circles
    @Override
    protected void paintComponent(Graphics g) 
    {
    	super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //set up color if True=Green if False=Gray
        if(output == true) 
        {
        	g2d.setColor(Color.GREEN);
            g2d.drawOval(xCircle, yCircle+6, 10, 10);
            g2d.fillOval(xCircle,yLabel+25,12,12);
        }
        else
        {
        	g2d.setColor(Color.GRAY);
            g2d.drawOval(xCircle, yCircle+6, 10, 10);
            g2d.fillOval(xCircle,yLabel+25,12,12);
        }
        
    }
    //displaying the Gate Output
    public void displayOR() 
    {
    	frame = new JFrame("OR GATE OUTPUT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(x, y);  // Set the window size
        frame.setResizable(false);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        
        frame.add(outputLabel);
        
        button.setBounds(xButton-50, yButton, wButton-10, hButton);
        button.addActionListener(this);
        frame.add(button);
        frame.add(this);
        frame.setVisible(true);
        
    }
    //placing gate label
    public void orValueLabel() 
    {
        outputLabel = new JLabel(strGateName);
        outputLabel.setBounds(xLabel-25, yLabel, wLabel+20, hLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
    	setStatus(true);
    	getStatus();
    	frame.dispose();
                            
    }
    public void setStatus(boolean status) 
    {
    	this.status=status;
    }
    public boolean getStatus() 
    {
    	return status;
    }
    
}
