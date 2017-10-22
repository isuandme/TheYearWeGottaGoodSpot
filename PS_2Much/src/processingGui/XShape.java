package processingGui;

import processing.core.PApplet;

public class XShape extends Shapes{
	XShape(PApplet p){
		super(p);
	}

	@Override
	public void display() {
		parent.stroke(59, 95, 153);
		parent.strokeWeight(20);
		parent.line(this.x, this.y, this.x + this.size, this.y+this.size);
		parent.line(this.x+size, this.y, this.x, this.y + size);
		
	}

	

}
