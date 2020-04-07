package code;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle{
	static double size; //this will be decided from the gui
	boolean life=false;
	int neighbors; //number of alive neighbors\
	
	static boolean draw = false;
	//default constructor that only sets size
	Cell(){
		life=randLife();
		//life=false;
		updateC();
		setStroke(Color.BLACK);
		setWidth(size);
		setHeight(size);
		
		//needs work
//		this.setOnMouseEntered(event ->{
//			if(draw==true) {
//				flip();
//			}
//		});
//		
//		this.setOnMouseClicked(event ->{
//			draw=!draw;
//		});
		
		
		
	}
	
	//constructor that can be used to set initial size and start state, s as in size and a as in alive
	Cell(int s,boolean a){
		
	}
 
	public void calcLife() { //takes in number of neighbors and tells us if the cell will live.
		if(life==true) {
			if(neighbors<2||neighbors>3) {
				life=false;
			}
		}
		else if(life==false) {
			if(neighbors==3) {
				life=true;
			}
		}
	}
	
	void updateC() {//updates the cells status
		if(life) {
			setFill(Color.LIME);
		}else {
			setFill(Color.BLACK);
		}
	}
	
	//changes the life status from dead to alive or from alive to dead
//	void flip(){
//		if(life==false) {
//			life=true;
//		}
//		else if(life==true) {
//			life=false;
//		}
//		
//		updateC();
//	}
	
	
	//sets the life status to false
	public void kill() {
		life=false;
	}
	
	// sets the life status to true
	public void birth() {
		life=true;
	}
	
	//sets life status to the given argument
	public void setLife(boolean x) {
		life=x;
	}
	
	public boolean getLife() {
		return life;
	}
	
	static void setSize(double s) {
		size=s;
	}
	
	void setNeighbors(int n) {
		neighbors=n;
	}
	
	static boolean randLife() { // returns random life value
		int tf=0; //stores the true or false value as an integer, 1 for true and 0 for false
		
		tf=(int) (Math.random()*2);
		if(tf==1) {
			return true;
		}else {
			return false;
		}
	}
}


