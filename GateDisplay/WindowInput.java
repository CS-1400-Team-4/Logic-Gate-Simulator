import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WindowInput implements ActionListener
{
	private static String input;
    private static String inputBuilder;
    private static JLabel[] stringInput;
    private static JLabel displayMessage;
    public static JTextField[] inputBox;
    private static JButton button;
    private static JFrame frame;
    private static JPanel panel;
    private static HashMap<String, Boolean> inputValues;
    private static int x = 300;
    private static int y = 300;
    private static boolean status=false;
      
    public static int xLabel=20, yLabel=10, wLabel=40, hLabel=20;
    public static int xBox=xLabel+15, yBox=yLabel, wBox=wLabel, hBox=hLabel;
    public WindowInput(String input) 
    {
    	WindowInput.input = input;
	}
	                 
    public void displayWindow() 
    {
 
    	frame = new JFrame();
    	panel = new JPanel();
	    button = new JButton("Submit");
	    button.setBounds(xBox+50, yBox+150, 80,30);
	    button.addActionListener(this);
	    panel.add(button);
	
	    panel.setLayout(null);
	    frame.setSize(x,y);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	     
	     //initiate labels, text fields, and getInputValues
	    labelMaker();
	    textField();
	    getInputValues();	     
	     //adding labels to frame
	    int lenArray = stringInput.length;                          
	    for(int i =0; i < lenArray; i++ ) 
	    {
	    	frame.add(stringInput[i]);
	    	panel.add(inputBox[i]);
	    }
	    displayMessage = new JLabel("Enter Value between 1 and 0");
        displayMessage.setBounds(1, 1, 200, 50);
        frame.add(displayMessage);
        frame.add(panel);
                             
    }
              
    public static void userInput() 
    {
    	inputBuilder="";
        for(int i = 0; i < input.length(); i++) 
        {
        	char charInput = input.charAt(i);
        	if(Character.isAlphabetic(charInput) & !inputBuilder.contains(String.valueOf(charInput)))
        	{                                      
        		inputBuilder = inputBuilder.concat(String.valueOf(charInput));
        	}
                       
        }
                         
    }
    //making JLabels from user input
    public JLabel[] labelMaker() 
    {
    	userInput();
        int increment = 0;
        String strInput = inputBuilder;
        String strValue="";
        int lenArray = inputBuilder.length();
        stringInput = new JLabel[lenArray];
        for(int i = 0; i < stringInput.length; i++) 
        {
        	increment = increment + 30;
            strValue = String.valueOf(strInput.charAt(i));
            stringInput[i] = new JLabel(strValue.toUpperCase());
            stringInput[i].setBounds(xLabel, yLabel +increment, wLabel, hLabel);
                       
        }
        button.addActionListener(this);
        panel.add(button);
        return stringInput;
    }
    //Making text field box and assigning their coordinate        
    public JTextField[] textField() 
  {

    	int lenArray = stringInput.length;
        int increment = 0;
        inputBox = new JTextField[lenArray];
                 
        for(int i = 0; i < lenArray; i++) 
        {
        	inputBox[i] = new JTextField(10);
        	increment = increment+30;
        	inputBox[i].setBounds(xBox, yBox+increment, wBox, hBox);
  
        }
                 
        return inputBox;
  }
      //Listen for mouse click
      @Override
      public void actionPerformed(ActionEvent e) 
      {
    	  String strVariable="";
          String strValues="";
          inputValues = new HashMap<>();                        
          for(int i = 0; i < inputBox.length; i++) 
          {
        	  strVariable = stringInput[i].getText();
              strValues = inputBox[i].getText();
                                                              
              if(strValues.equals("1")) 
              {
            	  inputValues.put(strVariable, true);
              }
              else
              {
            	  inputValues.put(strVariable, false);
              }
          }
          setStatus(true);
          frame.dispose();
         
     }                              
      //return HashMap with user Variable and Values ex. A:1 or B:0  
      public HashMap<String, Boolean> getInputValues() 
      {
    	  return inputValues;
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
