import javax.swing.JLabel;

public class userInput
{
	String input;
	String gateName;
	String fileName;
	JLabel inputLabel;
	JLabel expressionLabel;
	JLabel[] strLabel;
	int intInput, value;
	double scaleImg;
	
	public userInput(String input) 
	{
		this.input=input;
		inputReader();
	}
	
	public void inputReader() 
	{
		String str = "";
		for(int i =0; i < input.length(); i++) 
		{
			if(Character.isAlphabetic(input.charAt(i))) 
			{
				intInput++;
				str = str + Character.toString(input.charAt(i));
			}
		}
		
		if(input.contains("+")) 
		{
			gateName = "OR";
			fileName = "orGate2.png";
			scaleImg = 0.5;
		}
		else if(input.contains("!"))
		{
			gateName = "NOT";
			fileName = "notGate2.png";
			scaleImg = 0.5;
		}
		else 
		{
			gateName = "AND";
			fileName = "andGate2.png";
			scaleImg = 0.2;
		}
		
		//initialize label array
		strLabel = new JLabel[intInput];
		for(int i = 0; i < intInput; i++) 
		{
			String strInputLabel=Character.toString(str.charAt(i)).toUpperCase();
			strLabel[i] = new JLabel(strInputLabel);
		}
			
	}
	
	public String getGateName() 
	{
		return gateName;
	}
	public int getIntInput()
	{
		return intInput;
	}
	
	public JLabel[] getStrLabel() 
	{
		return strLabel;
	}
	public double getScaleImg() 
	{
		return scaleImg;
	}
	public String getFileName() 
	{
		return fileName;
	}

}



