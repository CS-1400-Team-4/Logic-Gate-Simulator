import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class drawLines extends JPanel {
    Graphics2D g2d;
    int intInput;
    DisplayFrame frame;
    int tail =50;
    String strInput;
    String gate;
    JLabel expressionLabel;
    JLabel[] expInput;
    Color lineColor = Color.BLACK;
    char[] userInput;
    LoadImage img;
    
    public drawLines(String strInput, JLabel[] inputLabel, int input, DisplayFrame frame, LoadImage img) {
        intInput = input;
        this.strInput=strInput;
        this.frame = frame;
        this.expInput=inputLabel;
        this.setOpaque(false);
        this.img=img;
        
    }
        
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        
        int labelHeight = img.getH();//getting height of img with respect to frame
        int lineSpacing;
        if(gate.equals("not")) 
        {
        	lineSpacing = labelHeight/2;
        }
        else 
        {
        	lineSpacing = labelHeight/(intInput-1); //spacing between labels
        }
        g2d.setStroke(new BasicStroke(5)); //thickness of lines
       
        
        //setting the Label expression 
        expressionLabel.setBounds(img.getLabelX()-100, img.getLabelY()-150, img.getLabelX(),img.getLabelY());
        expressionLabel.setFont(new Font("Ariel", Font.PLAIN, 30));
		expressionLabel.setOpaque(false);
		this.add(expressionLabel); //add this to the drawLines class
        
		//drawing the lines and putting the label variable to each line
		//expInput = new JLabel[intInput];
        for(int i =0; i < intInput; i++) 
        {
        
        	if(userInput[i] == '1') 
        	{
        		g2d.setColor(lineColor);
        		//input line
        		if(gate.equals("not")) 
        		{
        			g2d.drawLine(img.getLabelX(), img.getLabelY() +(lineSpacing*i) + img.getH()/2, img.getLabelX()-100,img.getLabelY() +(lineSpacing*i)+ img.getH()/2);
        		}
        		else 
        		{
        			g2d.drawLine(img.getLabelX(), img.getLabelY() +(lineSpacing*i), img.getLabelX()-100,img.getLabelY() +(lineSpacing*i));
        		}
        	}
        	else if(userInput[i] == '0') 
        	{
        		g2d.setColor(Color.gray);
        		//input line
        		if(gate.equals("not")) 
        		{
        			g2d.drawLine(img.getLabelX(), img.getLabelY() +(lineSpacing*i) + img.getH()/2, img.getLabelX()-100,img.getLabelY() +(lineSpacing*i)+ img.getH()/2);
        		}
        		else 
        		{
        			g2d.drawLine(img.getLabelX(), img.getLabelY() +(lineSpacing*i), img.getLabelX()-100,img.getLabelY() +(lineSpacing*i));
        		}
        	}
        	
        	
        	
        	//adding the variable label
        	expInput[i].setFont(new Font("Ariel", Font.PLAIN, 30));
        	
        	if(gate.equals("not")) 
        	{
        		expInput[i].setBounds(img.getLabelX() -130, img.getLabelY() +(lineSpacing*i) + img.getH()/2 - 10, 50, 25);
            	this.add(expInput[i]);
        	}
        	else 
        	{
        		expInput[i].setBounds(img.getLabelX() -130, img.getLabelY() +(lineSpacing*i) -10, 50, 25);
            	this.add(expInput[i]);
        	}
     
        }
        
        String strOutput = "";
        //output line
       for(int i = 0; i < intInput; i ++) 
       {
    	   if(gate.equals("and")) 
    	   {
    		   if(userInput[i] == '0') 
    		   {
    			   strOutput = "0";
    			   break;
    		   }
    		   else 
    		   {
    			   strOutput = "1";
    		   }
    	   }
    	   else if(gate.equals("or")) 
    	   {
    		   if(userInput[i] == '1') 
    		   {
    			   strOutput = "1";
    			   break;
    		   }
    		   else 
    		   {
    			   strOutput = "0";
    		   }
    	   }
    	   if(gate.equals("not")) 
    	   {
    		   if(userInput[i] == '0') 
    		   {
    			   strOutput = "1";
    			   break;
    		   }
    		   else 
    		   {
    			   strOutput = "0";
    		   }
    	   }
       }
       
       if(strOutput.equals("1")) 
       {
    	   g2d.setColor(Color.green);
    	   g2d.drawLine(img.getLabelX()+img.getW(), img.getLabelY()+img.getH()/2, img.getLabelX()+img.getW()+100,img.getLabelY()+img.getH()/2);
       }
       else 
       {
    	   g2d.setColor(Color.gray);
    	   g2d.drawLine(img.getLabelX()+img.getW(), img.getLabelY()+img.getH()/2, img.getLabelX()+img.getW()+100,img.getLabelY()+img.getH()/2);
       }
        
    }
    //set color when method is called
    public void setLineColor(Color color) 
    {
    	this.lineColor = color;
    }
    public void setUserInput(char[] userInput) 
    {
    	this.userInput = userInput;
    }
    public void setGate(String gate) 
    {
    	this.gate=gate.toLowerCase();
    	expressionLabel = new JLabel("Expression for " + gate + " : " + strInput.toUpperCase());
    }
   
}
