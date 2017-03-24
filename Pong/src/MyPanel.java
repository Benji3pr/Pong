import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class MyPanel extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pointsL = "0";
	private String pointsR = "0";
	public PongGame pG = new PongGame((this.getWidth())/2, (this.getHeight())/2, 5, 5, 0, 50);

	
	public void add(PongGame pg){
		this.pG = pg;
	}
	
	public void paintComponent(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g2.setColor(Color.WHITE);
		for(int i=0; i<this.getHeight(); i=i+50){
			int width = 6;
			int height = 30;
			int y=i;
			int x=(this.getWidth()/2)-(width/2);
			g2.fillRect(x, y, width, height);
		}
		
		
		
		g.setFont(new Font("Serif", Font.PLAIN, 50)); 
		
		g2.drawString(pointsL, 250, 100);
		g2.drawString(pointsR, 750, 100);
		
		if(pG.leftBorderCollision()){
			int p = Integer.parseInt(pointsR);
			p+=1;
			pointsR = Integer.toString(p);
			pG.setXLeft(500);
			pG.setYTop(350);
			pG.setTrajectory(0);
			
		}
		
		if(pG.rightBorderCollision(990)){
			int p = Integer.parseInt(pointsL);
			p+=1;
			pointsL = Integer.toString(p);
			pG.setXLeft(500);
			pG.setYTop(350);
			pG.setTrajectory(180);
			
		}
		
		pG.draw(g); pG.move();
		

	}
	
	
		

}
