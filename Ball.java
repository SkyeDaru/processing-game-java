package edu.nyu.cs.hsd262;

import processing.core.PApplet;

/*
 * The Ball Class
 * @author Hayley Darukhanavala
 * @version 0.1
 */

public class Ball {
	
	
	//hold reference to controlling PApplet class
	PApplet parent;
	
	private int rad; //radius of the ball
	private int xpos; //x position
	private int ypos; //y position
	
	private int xspeed = 2; //speed in horizontal direction
	private int yspeed = 2; //speed in vertical direction
	
	
	public Ball() {
		//DEFAULT CONSTRUCTOR
	}
	
	
	public Ball(PApplet parent, int xpos, int ypos, int rad) {
		// TODO Auto-generated constructor stub
		this.parent = parent; //keep reference to the PApplet class
		this.xpos = xpos; //x position
		this.ypos = ypos; //y position
		this.rad = rad; //radius
	}

/*
 * Get radius of ball
 * @return int radius of image
 */

	public int getRad() {
		return rad;
	}
	
	/*
	 * Set radius of ball
	 */

	public void setRad(int rad) {
		this.rad = rad;
	}
	
	/*
	 * Get x position of ball
	 * @return int x position of ball
	 */
	
	public int getXpos() {
		return xpos;
	}
	
	/*
	 * Set x position of ball
	 */
	public void setXpos(int xpos) {
		this.xpos = xpos;
	}
	
	/*
	 * Get y position of ball
	 * @return int y position of ball
	 */
	public int getYpos() {
		return ypos;
	}
	
	/*
	 * Set y position of ball
	 */
	public void setYpos(int ypos) {
		this.ypos = ypos;
	}


/*
 * Allows ball to move around the screen
 * Keep object within boundaries of width and height
 */
	public void move() {
	
		  this.xpos += this.xspeed; //calculate x speed
		  this.ypos += this.yspeed; //calculate y speed
		  
		  
		  /*
		   * Keeps ball within borders of screen
		   * 
		   */
		  if (this.xpos + this.rad >= 820) { //if it goes too far right, reverse speed and go left
			  this.xspeed *= -1;
		  }
		  
		  if(this.xpos + this.rad <= 40) { //if it goes too far left, reverse speed and go right
			  this.xspeed *= -1;
		  }
		  
		  if (this.ypos - this.rad >= 390) { //if it goes too far up, reverse speed and go down
			  this.yspeed *= 0;
		  }
		  
		  if (this.ypos - this.rad <= -15) { //if it goes too far down or misses paddle, do NOT bounce back
			  this.yspeed *= -1;
		  }
		  
			  
	}
	
	/*
	 * Simple method that reverses the speed of y
	 * 
	 */
	public void reverse(int yspeed) {
		this.yspeed = -yspeed;
		
	}


	/*
	 * Display the ball and fill it with color hot pink
	 * Draw ellipse 
	 */
	public void display() {
		parent.fill(255, 105, 180);
		parent.ellipse(xpos,  ypos,  rad,  rad);
	}
	
	
	/*
	 * Method to check if the paddle comes in contact with the ball
	 */
	public void checkForHit(Paddle myPaddle) { //checks if ball makes contact with the paddle
		if (this.xpos >= myPaddle.getXpos() && this.xpos <= myPaddle.getXpos() + myPaddle.getLength()) { //if the ball's x position is greater than the paddle's length and x position
			if (this.ypos >= myPaddle.getYpos()) { //if the y position is greater than the paddle's y position
				if (this.ypos >= myPaddle.getYpos() - myPaddle.getWidth()) { 
					reverse(this.yspeed); //reverse the speed of y
				}
			}
		}
	}




}
