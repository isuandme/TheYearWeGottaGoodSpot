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
	double spring = .1;
	protected int diameter;
	double gravity = 2;
	double friction = -0.9;
	double maxVel = 40;
	int colorOffset;
	ArrayList<Shapes> others;
	
	
	Shapes(PApplet p){
		parent = p;
		this.size = (int) parent.random(20, 100);
		diameter = this.size;
		this.x = (int) parent.random(parent.width-this.size);
		this.y = (int) parent.random(parent.height-this.size);
		colorOffset=parent.color(0,0,0);
	}
	
	public abstract void display();
	
	//make the shape glow then go back to normal
	void pulse(){
		
	}
	public void setShapes(ArrayList<Shapes> shapes){
		this.others = shapes;
	}

	public void collide(){
		for (int i =0; i < others.size(); i++) {
			if(this != others.get(i)){
				float dx = others.get(i).x - x;
				float dy = others.get(i).y - y;
				float distance = PApplet.sqrt(dx*dx + dy*dy);
				float minDist = others.get(i).diameter/2 + diameter/2;
				if (distance < minDist) { 
					float angle = PApplet.atan2(dy, dx);
					float targetX = x + PApplet.cos(angle) * minDist;
					float targetY = y + PApplet.sin(angle) * minDist;
					float ax = (float) ((targetX - others.get(i).x) * spring);
					float ay = (float) ((targetY - others.get(i).y) * spring);
					vx -= ax;
					vy -= ay;
					others.get(i).vx += ax;
					others.get(i).vy += ay;
				}
			}
		}
	}
	
	public void move(){
		vy += gravity;
	    x += vx;
	    y += vy;
	    if (x + diameter/2 > parent.width) {
	      x = parent.width - diameter/2;
	      vx *= friction; 
	    }
	    else if (x - diameter/2 < 0) {
	      x = diameter/2;
	      vx *= friction;
	    }
	    if (y + diameter/2 > parent.height) {
	      y = parent.height - diameter/2;
	      vy *= friction; 
	    } 
	    else if (y - diameter/2 < 0) {
	      y = diameter/2;
	      vy *= friction;
	    }
	    
	    if(vy>maxVel)
	    	vy=maxVel;
	    if(vx>maxVel)
	    	vx=maxVel;
	    
		
	}


	//make the shape bounce randomly
	public void bounce() {
		if(vx<maxVel){
			this.vx++;
			this.vx = this.vx*parent.random(1,3);
		}
		if(vy<maxVel){
			this.vy++;
			this.vy = this.vy*parent.random(10,20);	
		}
		
	}

	
}
