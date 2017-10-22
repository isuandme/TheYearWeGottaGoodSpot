package processingGui;

import processing.core.PApplet;

public class SpotLight {
	PApplet parent;
	int alpha = 0;
	int color;
	int id;
	float colOffset0;
	float colOffset1;
	float colOffset2;
	
	SpotLight(PApplet p, int id){
		this.parent = p;
		this.id = id;
		color = parent.color(200,200,200,0);
		colOffset0 = parent.random(255);
		colOffset1 = parent.random(255);
		colOffset2 = parent.random(255);
	}
	
	public void display(){
		parent.fill(parent.noise(colOffset0)*255, parent.noise( colOffset1)*255, parent.noise( colOffset2)*255, alpha);
		parent.noStroke();
		if(id ==0)
		parent.triangle(parent.width+20, parent.height+20, -100, 400, 50, -200);
		else
			parent.triangle(-100, parent.height+20, parent.width+20, 400, parent.width+50, -200);
		if(alpha>0)
			alpha-= 10;
		
		colOffset0 += .01;
		colOffset1 += .01;
		colOffset2 += .01;
	}
	
	public void shine(){
		alpha=(int) parent.random(150,255);
	}
	
	
}
