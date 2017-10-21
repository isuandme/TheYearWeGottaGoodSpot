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
		background(54);
		conduct = new Conductor(this);
		smooth();

	}

	public void draw(){
		background(54);
		conduct.update();
	}

	public void keyPressed(){
			conduct.key(key);
	}


}



