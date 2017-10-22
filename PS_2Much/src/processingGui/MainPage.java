package processingGui;

import processing.core.*;


public class MainPage extends PApplet{
	float radius = 20;
	Conductor conduct;
	int fps = 60;
	
	public static void main(String[] args){
		PApplet.main("processingGui.MainPage");
	}

	public void settings(){
		size(800, 700);
	}
	public void setup(){
		frameRate(fps);
		background(20);
		conduct = new Conductor(this);
		smooth();

	}
	double xoff = 0;
	
	public void draw(){
		background(noise((float) xoff)*255);
		conduct.update();
		xoff = xoff + .01;
	}

	public void keyPressed(){
			conduct.key(key);
	}


}



