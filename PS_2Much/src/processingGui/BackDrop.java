package processingGui;

import processing.core.PApplet;

public class BackDrop extends Shapes {
	int backgroundColor=20;
	BackDrop(PApplet p){
		super(p);
	}

	@Override
	public void display() {
		parent.fill(backgroundColor);
		parent.noStroke();
		parent.rect(0,0,parent.width, parent.height);
		
	}
	
	@Override
	public void pulse(){
		parent.fill(193, 37, 9);
		parent.rect(0,0,parent.width, parent.height);
		System.out.println("Pulse");
	}
	
	@Override
	public void move(){
		
	}


}
