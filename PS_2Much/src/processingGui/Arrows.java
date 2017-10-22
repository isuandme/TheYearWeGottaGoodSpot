package processingGui;

import processing.core.PApplet;


public class Arrows extends Shapes{

	private int id;
	
	Arrows(PApplet p, int id){
		super(p);
		this.id = id;
		
	}
	
	public void display(){
		parent.noStroke();
		parent.fill(94, 106, 124);
		parent.rect(x,y,size,size);
		if(id == 0)
		parent.triangle(x, y+size, x+size/2, (float) (y+size*1.5), x + size, y+size);
		else if(id == 1)
			parent.triangle(x, y,(float) (x-size*1.5), y+size/2, x, y+size);
		else if(id == 2)
			parent.triangle(x, y, x+size/2, (float) (y-size*1.5), x + size, y);
		else
			parent.triangle(x+size, y,(float) (x+size*1.5), y+size/2, x+size, y+size);
		
	}
	
	
	
}
