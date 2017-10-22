package processingGui;

import processing.core.PApplet;

public class Triangle  extends Shapes {
	
	
	Triangle(PApplet p){
		super(p);
		this.color= parent.color(106, 201, 132);
	}

	@Override
	public void display() {
		parent.stroke(this.color+colorOffset);
		parent.noFill();
		parent.triangle(this.x, this.y+size, this.x+size/2, this.y, this.x + size, this.y+size);
		
		
	}


}
