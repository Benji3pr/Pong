import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		
		
		JFrame frame= new JFrame();
		frame.setLocation(300,100);
		frame.setTitle("Pong");
		frame.setSize(1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyPanel newPanel = new MyPanel();
		frame.add(newPanel);
		
		PongGame newGame = new PongGame(500,350,15,15,180,150);
		newPanel.add(newGame);
		
		// Make the frame visible
		frame.setVisible(true);
		
		// Continuously update the frame since some components will change position
		while(true) {
			try{
				Thread.sleep(10); // Wait for 0.1 second = 100 milliseconds
			}
			catch(InterruptedException e){}
			
			frame.repaint();
			
		} // end while

	}//end main
}
