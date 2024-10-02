import java.util.HashMap;
import java.util.Set;

import javax.swing.JOptionPane;

public class LogicGateMain {

    public static void main(String[] args) 
    {
    	
    	WindowInput userDisplay;
    	DisplayGateInput gateInputDisplay;
    	DisplayGateOutput gateOutputDisplay;
        String input = JOptionPane.showInputDialog("Enter a boolean expression");
        String restart="";
        
        userDisplay = new WindowInput(input);
        userDisplay.displayWindow();
        do {
        	//loops again if the user types Y to restart
        	if(restart.equals("Y")) 
        	{
        		input = JOptionPane.showInputDialog("Enter a boolean expression");
        		userDisplay.displayWindow();
        	}
        	
        	//loops until user submits input
	        while(!userDisplay.getStatus()) 
	        {
	        	System.out.println("");
	        }   
	        
			gateInputDisplay = new DisplayGateInput(input, userDisplay.getInputValues());//passing user input variable like (AB) and values (01)
			gateInputDisplay.displayGate();
			//loops until user clicks Next button
			while(!gateInputDisplay.getStatus()) 
	        {
	        	System.out.println("");
	        }
			gateOutputDisplay = new DisplayGateOutput(gateInputDisplay.getGateName(), true); //passing gate name and boolean value
	        gateOutputDisplay.displayOR();
	        //loops until button is clicked or closes the window
	        while(!gateOutputDisplay.getStatus()) 
	        {
	        	System.out.println("");
	        }
	        //rest the boolean status of getStatus()
	        if(gateOutputDisplay.getStatus()) 
	        {
	        	userDisplay.setStatus(false);
	        	gateInputDisplay.setStatus(false);
	        	gateOutputDisplay.setStatus(false);
	        }
	        restart = JOptionPane.showInputDialog("Type \"Y\" to restart or \"N\" to quit");
	        restart = restart.toUpperCase();
        }while(restart.equals("Y"));
    
    }
        
}

