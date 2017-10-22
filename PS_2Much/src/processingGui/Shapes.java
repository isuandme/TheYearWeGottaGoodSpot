package processingGui;

import java.util.ArrayList;

import processing.core.PApplet;

public abstract class Shapes {
	PApplet parent;
	protected int x;
	protected int y;
	protected int size;
	protected int color;
	double vx = 0;
	double vy = 0;
	ArrayList<Shapes> shapes;
	
	Shapes(PApplet p){
		parent = p;
		this.size = (int) parent.random(20, 100);
		color = parent.color(parent.random(150,255), parent.random(150,255), parent.random(150,255));
		this.x = (int) parent.random(parent.width-this.size);
		this.y = (int) parent.random(parent.height-this.size);
	}
	
	public abstract void display();
	public abstract void move();
	
	//make the shape glow then go back to normal
	void pulse(){
		
	}
	public void setShapes(ArrayList<Shapes> shapes){
		this.shapes = shapes;
	}
	

	//make the shape bounce up
	public void bounce() {
		// TODO Auto-generated method stub
		
	}
	
}
