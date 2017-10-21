package processingGui;

import processing.core.PApplet;

public abstract class Shapes {
	PApplet parent;
	protected int x;
	protected int y;
	protected int size;
	protected int color;
	
	Shapes(PApplet p){
		parent = p;
		this.x = (int) parent.random(parent.width);
		this.y = (int) parent.random(parent.height);
		this.size = (int) parent.random(20, 100);
		color = parent.color(parent.random(150,255), parent.random(150,255), parent.random(150,255));
	}
	
	public abstract void display();
	public abstract void move();
	
	//make the shape glow then go back to normal
	void pulse(){
		
	}

	//make the shape bounce up
	public void bounce() {
		// TODO Auto-generated method stub
		
	}
	
}
