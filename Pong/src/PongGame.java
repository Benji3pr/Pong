import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class PongGame {



	private int xLeft = 0;
	private int yTop = 0;
	private int speed = 10;          // Speed in pixels per second
	private double trajectory = 0.0; // An trajectory angle in degrees 90 is vertical up, 0 is horizontal right
	private int width = 0;
	private int height =0;
	

	// No constructors since will never create an object of this class

	// Getters
	public int getXLeft() {
		return this.xLeft;
	}

	public int getYTop() {
		return this.yTop;
	}

	public double getTrajectory() {
		return trajectory;
	}

	public int getSpeed() {
		return speed;
	}

	// Setters
	public void setXLeft(int xleft){
		this.xLeft=xleft;
	}

	public void setYTop(int ytop){
		this.yTop=ytop;
	}

	public void setTrajectory(double trajectory) {
		this.trajectory = trajectory;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	//TODO
	public String playerLeftPoints(String pointsL){
		int p = Integer.parseInt(pointsL);
		if(addPoint('l')){
			p+=1;
		}
		pointsL = Integer.toString(p);
		return pointsL;
	}
	//TODO
	public String playerRightPoints(String pointsR){		
		int p = Integer.parseInt(pointsR);
		if(addPoint('r')){
			p+=1;
		}
		pointsR = Integer.toString(p);
		return pointsR;
	}
	//TODO
	public boolean addPoint(char p){

		if(p =='l'){
			return rightBorderCollision(700);
		}
		else if(p=='r'){
			return leftBorderCollision();
		}
			return false;
	}

	// Instances methods

	protected void move() {
		// Protected method to be called from paintComponent() in subclass
		moveAtAngle(getTrajectory(),getSpeed());
		// Change trajectory upon collision with border

	}
	
	PongGame(int xLeft, int yTop, int height, int width, double trajectory, int speed) {
		setXLeft(xLeft);
		setYTop(yTop);
		setTrajectory(trajectory);
		setSpeed(speed);
		this.height=height;
		this.width=width;
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		Rectangle rectangle = new Rectangle(getXLeft(),getYTop(), this.height, this.width);
		g2.setColor(Color.WHITE);
		g2.fill(rectangle);
		g2.draw(rectangle);
	}

	public void moveAtAngle(double angle,int pixelsPerSec){

		// Divide speed by 10 because frame is repainted every 0.1 sec
		int magnitude = Math.max(pixelsPerSec / 1000,1);

		// Compute horizontal and vertical components of linear translation
		// 90 degrees trajectory -> move straight up. 
		// 0 degrees trajectory -> move horizontally to the right
		int xVector= (int) (magnitude*Math.cos(Math.toRadians(angle)));
		int yVector= -(int) (magnitude*Math.sin(Math.toRadians(angle))); 


		//current values, for debugging purposes
		System.out.println("Current (x,y) position and vectors values to be added or substracted");
		System.out.println("xVector=" +xVector);
		System.out.println("yVector=" +yVector);
		System.out.println("xPosition=" + this.xLeft);
		System.out.println("yPosition=" + this.yTop);

		//other values for debugging
		System.out.println("angle in degrees: "+ angle);
		System.out.println("angle in radians: " + Math.toRadians(angle));

		//moving to the new coordinates by addition
		this.xLeft=this.xLeft+xVector;
		this.yTop=this.yTop+yVector;

		//new positions on the (x,y) plane for debugging purposes
		System.out.println("New (x,y) position with vectors values updated");
		System.out.println("xPosition=" + this.xLeft);
		System.out.println("yPosition=" + this.yTop);
	}

	

	//Methods to test of object hit each of four possible borders
	public boolean rightBorderCollision(int screenLimit){
		if(getXLeft()+this.width > screenLimit)
			return true;
		return false;
	}
	
	public boolean leftBorderCollision(){
		if(getXLeft() < 0)
			return true;
		return false;
	}

	public boolean upperBorderCollision(){
		if(getYTop() < 0)
			return true;
		return false;
	}

	public boolean lowerBorderCollision(int screenLimit){
		if(getYTop()+this.height >= screenLimit)
			return true;
		return false;
	}	
}
