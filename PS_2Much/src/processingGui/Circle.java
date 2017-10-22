package processingGui;


import processing.core.PApplet;

public class Circle extends Shapes{

	Circle(PApplet p){
		super(p);
		this.color= parent.color(216, 108, 65);
	}
	//draws circle 
	
	public void display(){
		parent.stroke(this.color+colorOffset);
		parent.strokeWeight(20);
		parent.noFill();
		parent.ellipse(x, y, size, size);
	}

	
}
