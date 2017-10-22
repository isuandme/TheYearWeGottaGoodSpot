package processingGui;

import java.util.ArrayList;

import processing.core.PApplet;

public class Conductor {
	PApplet parent;
	ArrayList<Shapes> shapes = new ArrayList<Shapes>();

	
	
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
	}
	
	//delegates each char to a method of each shape
	public void key(char key){
		switch (key){
		case 'a': shapes.get(0).bounce(); break;
		case 's': shapes.get(1).bounce(); break;
		case 'd': shapes.get(2).bounce(); break;
		case 'f':shapes.get(3).bounce(); break;
		case 'z': shapes.get(4).bounce(); break;
		case 'x': shapes.get(5).bounce(); break;
		case 'c': shapes.get(6).bounce(); break;
		case 'v':shapes.get(7).bounce(); break;
		}
		
	}
	
	//making shapes physical 
	
	
	
	
	//updates all the shapes on the screen
	public void update() {
		for(int i=0; i<shapes.size(); i++){
			shapes.get(i).setShapes(shapes);
			shapes.get(i).collide();
			shapes.get(i).move();
			shapes.get(i).display();
			
		}
		
	}
}
