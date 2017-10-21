package processingGui;

import java.awt.Color;

import processing.core.PApplet;

public class Circle extends Shapes{

	Circle(PApplet p){
		super(p);
	}
	//draws circle 
	
	public void display(){
		parent.fill(255, 255, 255);
		parent.ellipse(x, y, size, size);
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
}
