package edu.nyu.cs.hsd262;

import processing.core.PApplet;

/*
 * The Paddle class
 * @author Hayley Darukhanavala
 * @version 0.1
 */



public class Paddle {
	
	//hold reference to controlling PApplet class
	PApplet parent;
	
	private int xpos; //x position
	private int ypos; // y position
	private int length; //length of paddle
	private int width; //width of paddle
	
	
	
	//DEFAULT CONSTRUCTOR
	
	public Paddle() {
		//starting positions and dimensions of the paddle
		xpos = 0; 
        ypos = 0;
        length = 100;
        width = 10;
          }
	
	
	//OVERLOADED CONSTRUCTOR WITH PARAMETERS
	public Paddle(PApplet parent, int xpos, int ypos, int length, int width) {
		this.parent = parent;
		this.setXpos(xpos);
		this.setYpos(ypos);
		this.setLength(length/2);
		this.setWidth(width);
	
	}
	

	//GETTERS AND SETTERS
	
	
	/*
	 * Get x position of paddle
	 * @return int x position
	 */
	public int getXpos() {
		return xpos;
	}

/*
 * set x position of paddle
 */
	public void setXpos(int xpos) {
		this.xpos = xpos;
	}
	
	/*
	 * Get y position of paddle
	 * @return int y position of paddle
	 */
	
	public int getYpos() {
		return ypos;
	}

/*
 * set y position of paddle
 * 
 */
	public void setYpos(int ypos) {
		this.ypos = ypos;
	}
	
	/*
	 * Get length of paddle
	 * @return int length of paddle
	 */
	
	public int getLength() {
		return length;
	}

	/*
	 * Set length of paddle
	 */

	public void setLength(int length) {
		this.length = length;
	}
	
/*
 * Get width of paddle
 * @return int width of paddle
 */
	public int getWidth() {
		return width;
	}

/*
 * Set width of paddle
 */
	public void setWidth(int width) {
		this.width = width;
	}


	
	////METHODS BEGIN HERE
	
	/*
	 * Method to display paddle and fill it hot pink
	 */
	public void show() {
		parent.fill(255, 105, 180);
		parent.rect(getXpos(), getYpos(), getLength(), getWidth()); //construct a rectangle
		
	}
	
	/*
	 * Method that allows user to go left by -20 when clicked left arrow
	 */
	public void goLeft() {
		this.xpos = xpos - 20;
		
	}

	/*
	 * Method that allows user to go right by + 20 when clicked right arrow
	 */
	public void goRight() {
		this.xpos = xpos + 20;
	}
	

	
	

}
