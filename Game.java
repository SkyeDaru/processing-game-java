package edu.nyu.cs.hsd262;

import processing.core.PApplet;
import processing.core.PImage;
import edu.nyu.cs.hsd262.Ball;
import edu.nyu.cs.hsd262.Paddle;


/**
 * 
 * @author hayleydarukhanavala
 * @version 0.1
 *
 */

/**
 * This is the parent class of the paddle ball game. This program allows a user to bounce a ball and control
 * the paddle by using the left and right arrows to move side to side. If the player misses the ball, the game is over
 * and the ball falls forever.
 * Basic controller for Paddle ball
 *
 */


public class Game extends PApplet {

	
	private final int w = 800; //width
	private final int h = 400; //height
	
	//constants for colors 
	public final int BLACK = color(0,0,0); 
	public final int WHITE = color(255,255,255);
	
	//Instantiation of obejects ball and paddle
	Ball myBall = new Ball(this, 30, 30, 30);
	Paddle myPaddle = new Paddle(this, 400, 370, 200, 10);
	

	//variable to hold background image of game
	private PImage img; //will hold image to use 
	
	
	/*
	 * Called once to set up window
	 * @see processing.core.PApplet#settings()
	 */
	public void settings() {
		this.size(this.w, this.h); //set window size
	}
	
	
	/*
	 * Used to load the image and called once
	 * @see processing.core.PApplet#setup()
	 */
	public void setup() {
		this.background(255, 255, 255); //set background color
		img = loadImage("Juni-Skye2.jpg"); //set image file

	}
	
	/*
	 * Called repeatedly to update animation
	 * @see processing.core.PApplet#draw()
	 */
	
	public void draw() {
		this.background(WHITE);
		this.background(img); //displays the background as image file in setup
		
	
		
		myPaddle.show(); //have paddle draw itself to screen
		myBall.display(); //have ball draw itself to screen
		myBall.move(); //have the ball move itself around screen
		myBall.checkForHit(myPaddle); //constantly check it ball comes in contact with paddle
		}
	
	

	
	/*
	 * Called whenever key is pressed by the user
	 * @see processing.core.PApplet#keyPressed()
	 */

	
	//left and right key codes
	public void keyPressed() {
		if (key == CODED) {
			switch (keyCode) {
			case LEFT:
				myPaddle.goLeft(); //paddle move left
				break;
			case RIGHT:
				myPaddle.goRight(); //paddle move right
				break;
			}
		}
	}

	
	/*
	 * Automatically called to start program. Calls PApplet class
	 * @param args COmmand-line arguments (ignored)
	 */
	public static void main(String[] args) {
		PApplet.main("edu.nyu.cs.hsd262.Game");

	}
	
}
