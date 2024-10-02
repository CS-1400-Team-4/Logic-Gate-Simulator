import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;

public class DisplayGateInput extends JPanel implements ActionListener
{
    public static int x = 200;
    public static int y = 300;
    int yIncrement;
    public static String strGateOutput;
    public static String[] strVariable;
    public static JLabel[] strLabel;
    public static int xLabel=20, yLabel=20, wLabel=40, hLabel=20;
    public static int xCircle=xLabel+15, yCircle=yLabel+1, wCircle=10, hCircle=10;
    public static int xRect=xLabel, yRect=yLabel+10, wRect=wLabel, hRect=hLabel;
    public static int xGateLabel=xLabel, yGateLabel=yLabel-40, wGateLabel=110, hGateLabel=80;
    public static HashMap<String, Boolean> inputValues;
    public static JLabel gateLabelOr = new JLabel("OR GATE INPUT");
    public static JLabel gateLabelNot = new JLabel("NOT GATE INPUT");
    public static JLabel gateLabelAnd = new JLabel("AND GATE INPUT");
    public static int numGate=3;
    public static String input;
    public static boolean status=false;  
    public JFrame frame;
    public static JButton button = new JButton("Next");
    public static int xButton=x/2, yButton=y/2, wButton=wLabel+35, hButton=hLabel+10;
    
    public DisplayGateInput(String input, HashMap<String, Boolean> inputValues)
    {
               frame = new JFrame("INPUT");
               this.inputValues = inputValues;
               inputKeyVal(inputValues);
               orVariableLabel();
               this.input=input;
                              
    }
               
    // Override paintComponent to draw circles
    @Override
    protected void paintComponent(Graphics g) 
    {
    	super.paintComponent(g);             
        // Cast Graphics to Graphics2D for more control
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);       
        
        String strVar = "";
        int increment = 0;
        //For loop and setting color, Green=1 and Gray=0
        for(int i = 0; i < strLabel.length; i++) 
        {
        	increment = increment +23;
   
        	strVar = strVariable[i];
            if(inputValues.get(strVar) == true) 
            {
            	g2d.setColor(Color.GREEN);
                g2d.drawOval(xCircle, yCircle+increment, 10, 10);
                g2d.fillOval(xCircle,yLabel+increment,12,12);
            }
            else 
            {
            	g2d.setColor(Color.GRAY);
                g2d.drawOval(xCircle, yCircle+increment, 10, 10);
                g2d.fillOval(xCircle,yLabel+increment,12,12);
            }
            
        }
        //draw square
        g2d.setColor(Color.BLACK);
        g2d.drawRect(xRect, yRect, wRect, hRect+increment);  
    }
    //Displaying the gate
    public void displayGate() 
    {
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(x, y);  // Set the window size
        frame.setResizable(false);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        
        int increment =0;
        int increment2 = 0;
        
        //placing the variable labels in the frame
        for(int i = 0; i < strLabel.length; i++) 
        {
               increment = increment + 20;
               strLabel[i].setBounds(xLabel, yLabel + increment+increment2, wLabel, hLabel);
               frame.add(strLabel[i]);
        }
        
        
        //placing the label gate name in the frame
        int alphaCount=0;
        for(int i = 0; i < input.length(); i++) 
        {
               if(input.charAt(i)=='+')
               {
            	gateLabelOr.setBounds(xGateLabel, yGateLabel, wGateLabel, hGateLabel);
                frame.add(gateLabelOr);
                alphaCount=0;
                strGateOutput = "OR GATE OUTPUT";
               }
               else if(input.charAt(i)=='\'') 
               {

                              gateLabelNot.setBounds(xGateLabel, yGateLabel, wGateLabel, hGateLabel);
                frame.add(gateLabelNot);
                strGateOutput = "NOT GATE OUTPUT";
               }
               else if(alphaCount>=1 && Character.isAlphabetic(input.charAt(i))) 
               {
                              gateLabelAnd.setBounds(xGateLabel, yGateLabel, wGateLabel, hGateLabel);
                frame.add(gateLabelAnd);
                strGateOutput = "AND GATE OUTPUT";
               }
               else if(Character.isAlphabetic(input.charAt(i))) 
               {
                              alphaCount++;
                              
               }
        }
        //Listening for user click on button
        button.setBounds(xButton, yButton, wButton, hButton);
        button.addActionListener(this);
        frame.add(button);
        frame.add(this);
        
        frame.setVisible(true);
        
    }
    //extracting Variable from user input
    public void inputKeyVal(HashMap<String, Boolean>inputValues)
    {
    	this.inputValues = inputValues;
        Set<String> setKey = inputValues.keySet();
        strVariable = setKey.toArray(new String[0]);                      
    }
    
    //placing Variable text into JLabel
    public void orVariableLabel() 
    {
    	int increment = 0;
        String strValue="";
        int lenArray = strVariable.length;
        strLabel = new JLabel[lenArray];
        for(int i = 0; i < lenArray; i++) 
        {
        	increment = increment + 20;
            strValue = String.valueOf(strVariable[i]);
            strLabel[i] = new JLabel(strValue);                                           
        }
    }
    //listen for mouse clock on button and setStatus to true
    public void actionPerformed(ActionEvent e) 
    {
    	frame.dispose();
        setStatus(true);
    }
    //return gate name to be used in DisplayGateOutput class
    public String getGateName()
    {   	
    	return strGateOutput;
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


