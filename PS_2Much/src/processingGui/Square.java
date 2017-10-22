package processingGui;

import processing.core.PApplet;

public class Square extends Shapes{

	Square(PApplet p){
		super(p);
		this.color= parent.color(165, 77, 143);
	}

	@Override
	public void display() {
		parent.stroke(this.color+colorOffset);
		parent.noFill();
		parent.rect(this.x, this.y, this.size, this.size);
	}
	
	
}
