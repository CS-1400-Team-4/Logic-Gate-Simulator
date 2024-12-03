import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GateSimulation {

	public static void main(String[] args) throws IOException {
	    AtomicBoolean restart = new AtomicBoolean(true);

	    while (true) { // Infinite loop to allow multiple restarts
	        if (!restart.get()) {
	            break; // Exit the loop if restart is not set
	        }
	        restart.set(false); // Reset restart flag for the next iteration

	        // Create a new instance of Window2 for each loop
	        DisplayFrame display = new DisplayFrame();
	        display.display();

	        AtomicInteger counter = new AtomicInteger(0);
	        List<JTextField> strValueList = new ArrayList<>();
	        List<JLabel> labelList = new ArrayList<>();
	        JLabel message2 = new JLabel("Type 1 or 0");

	        display.nextButton.addMouseListener(new MouseListener() {
	            public void mouseClicked(MouseEvent e) {
	                userInput input = new userInput(display.userInput.getText());
	                int caseCounter = counter.incrementAndGet();

	                switch (caseCounter) {
	                    case 1:
	                        display.getFrame().remove(display.message);
	                        display.getFrame().remove(display.userInput);
	                        int bound = display.nextButton.getY() / (1 + input.getIntInput());

	                        message2.setBounds(display.getFrame().getX() / 2, bound - 40, 100, 20);
	                        display.getFrame().add(message2);
	                        for (int i = 0; i < input.getIntInput(); i++) {
	                            JTextField textField = new JTextField();
	                            textField.setBounds(display.getFrame().getX() / 2, bound + (bound * i), 50, 20);
	                            display.getFrame().add(textField);
	                            strValueList.add(textField);

	                            JLabel label = input.getStrLabel()[i];
	                            label.setBounds(display.getFrame().getX() / 2 - 50, bound + (bound * i), 50, 20);
	                            display.getFrame().add(label);
	                            labelList.add(label);
	                        }
	                        display.getFrame().revalidate();
	                        display.getFrame().repaint();
	                        break;

	                    case 2:
	                        try {
	                            LoadImage img = new LoadImage(input.getFileName(), display.getX(), display.getY(), input.getScaleImg());
	                            drawLines drawLine = new drawLines(display.userInput.getText(), input.getStrLabel(), input.getIntInput(), display, img);

	                            char[] charVal = new char[input.getIntInput()];
	                            for (int i = 0; i < charVal.length; i++) {
	                                charVal[i] = strValueList.get(i).getText().charAt(0);
	                            }
	                            drawLine.setLineColor(Color.green);
	                            drawLine.setUserInput(charVal);
	                            drawLine.setGate(input.getGateName());

	                            display.getFrame().remove(message2);
	                            strValueList.forEach(display.getFrame()::remove);
	                            labelList.forEach(display.getFrame()::remove);
	                            labelList.clear();

	                            drawLine.setBounds(0, 0, 800, 600);
	                            display.getFrame().add(drawLine);
	                            display.getFrame().add(img.getJLabel());

	                            display.getFrame().revalidate();
	                            display.getFrame().repaint();
	                        } catch (IOException e1) {
	                            e1.printStackTrace();
	                        }
	                        break;

	                    case 3:
	                        display.getFrame().remove(display.nextButton);

	                        JButton exitButton = new JButton("Exit");
	                        JButton restartButton = new JButton("Restart");
	                        exitButton.setBounds(display.getX() / 2, display.getY() / 2 + 150, 85, 40);
	                        restartButton.setBounds(display.getX() / 2, display.getY() / 2 + 100, 85, 40);

	                        display.getFrame().add(exitButton);
	                        display.getFrame().add(restartButton);
	                        display.getFrame().revalidate();
	                        display.getFrame().repaint();

	                        restartButton.addActionListener(event -> {
	                            restart.set(true); // Set restart to true
	                            display.getFrame().dispose(); // Dispose of current frame
	                        });

	                        exitButton.addActionListener(event -> System.exit(0));
	                        counter.set(0);
	                        break;
	                }
	            }

	            @Override public void mousePressed(MouseEvent e) {}
	            @Override public void mouseReleased(MouseEvent e) {}
	            @Override public void mouseEntered(MouseEvent e) {}
	            @Override public void mouseExited(MouseEvent e) {}
	        });

	        // Wait until restart is triggered
	        while (!restart.get()) {
	            try {
	                Thread.sleep(100); // Small delay to avoid busy-waiting
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

}
