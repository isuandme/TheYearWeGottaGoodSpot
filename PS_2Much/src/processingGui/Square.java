package processingGui;

import processing.core.PApplet;

public class Square extends Shapes{

	Square(PApplet p){
		super(p);
	}

	@Override
	public void display() {
		parent.stroke(165, 77, 143);
		parent.noFill();
		parent.rect(this.x, this.y, this.size, this.size);
	}
	
	
}
