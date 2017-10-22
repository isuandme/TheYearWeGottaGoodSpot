package processingGui;

import processing.core.PApplet;

public class XShape extends Shapes{
	XShape(PApplet p){
		super(p);
		this.color= parent.color(59, 95, 153);
	}

	@Override
	public void display() {
		parent.stroke(this.color +colorOffset);
		parent.strokeWeight(20);
		parent.line(this.x, this.y, this.x + this.size, this.y+this.size);
		parent.line(this.x+size, this.y, this.x, this.y + size);
		
	}

	

}
