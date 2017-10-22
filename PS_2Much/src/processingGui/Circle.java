package processingGui;


import processing.core.PApplet;

public class Circle extends Shapes{

	Circle(PApplet p){
		super(p);
	}
	//draws circle 
	
	public void display(){
		parent.stroke(216, 108, 65);
		parent.strokeWeight(20);
		parent.noFill();
		parent.ellipse(x, y, size, size);
	}

	
}
