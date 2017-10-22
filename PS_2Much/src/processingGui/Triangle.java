package processingGui;

import processing.core.PApplet;

public class Triangle  extends Shapes {
	
	
	Triangle(PApplet p){
		super(p);
	}

	@Override
	public void display() {
		parent.stroke(106, 201, 132);
		parent.noFill();
		parent.triangle(this.x, this.y+size, this.x+size/2, this.y, this.x + size, this.y+size);
		
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
}
