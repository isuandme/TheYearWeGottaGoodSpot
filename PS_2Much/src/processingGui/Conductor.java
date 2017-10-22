package processingGui;

import java.util.ArrayList;

import processing.core.PApplet;

public class Conductor {
	PApplet parent;
	ArrayList<Shapes> shapes = new ArrayList<Shapes>();
	SpotLight spot1;
	SpotLight spot2;
	

	
	
	Conductor(PApplet p){
		parent = p;
		//shapes.add(new BackDrop(parent));
		shapes.add(new Circle(parent));
		shapes.add(new Triangle(parent));
		shapes.add(new XShape(parent));
		shapes.add(new Square(parent));
		shapes.add(new Arrows(parent, 0));
		shapes.add(new Arrows(parent, 1));
		shapes.add(new Arrows(parent, 2));
		shapes.add(new Arrows(parent, 3));
		spot1 = new SpotLight(parent, 0);
		spot2 = new SpotLight(parent, 1);
	}
	
	//delegates each char to a method of each shape
	public void key(char key){
		switch (key){
		case 'a': shapes.get(0).bounce(); break;
		case 's': shapes.get(1).bounce(); break;
		case 'd': shapes.get(2).bounce(); break;
		case 'f':shapes.get(3).bounce(); break;
		case 'j': shapes.get(4).bounce(); break;
		case 'k': shapes.get(5).bounce(); break;
		case 'l': shapes.get(6).bounce(); break;
		case ';':shapes.get(7).bounce(); break;
		case 'u': spot1.shine();
		case 'i': spot2.shine();
		}
		
	}
	
	
	
	
	private boolean getCrazy = false;
	//updates all the shapes on the screen
	public void update() {
		spot1.display();
		spot2.display();
		for(int i=0; i<shapes.size(); i++){
			shapes.get(i).setShapes(shapes);
			shapes.get(i).collide();
			shapes.get(i).move();
			shapes.get(i).display();
			getCrazy = shapes.get(i).getCrazy();
		}
		
	}
	public boolean getCrazy(){
		return getCrazy;
	}
}
