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
		size(1000, 800);
	}
	public void setup(){
		frameRate(fps);
		background(20);
		conduct = new Conductor(this);
		smooth();

	}
	double xoff0 = 0;
	double xoff1 = 0;
	double xoff2 = 0;
	
	public void draw(){
		background(noise((float) xoff0)*255, noise((float) xoff1)*255, noise((float) xoff2)*255 );
		conduct.update();
		xoff0 += .01;
		xoff0+=.01;
		xoff0 +=.01;
		
	}

	public void keyPressed(){
			conduct.key(key);
	}


}



