package code;

import javafx.scene.paint.Color;

public class Game {
	
	public double gameWidth;
	public double gameHeight;
	public Cell[][] cells;
	int cellNum = 150; //the number of cells but rooted, so the amount of cells in a row
	
	//constructor
	Game(int s){
		gameWidth=s;
		gameHeight=gameWidth;
		cellSizeCalc(s);
		int tempX=0;
		int tempY=0;
		
		cells = new Cell[cellNum][cellNum];
		for(int i=0;i<cellNum;i++) {
			tempX=0;
			for(int j=0;j<cellNum;j++) {
				cells[j][i]=new Cell();
				cells[j][i].setX(tempX);
				cells[j][i].setY(tempY);
				tempX+=Cell.size;
			}
			tempY+=Cell.size;
		}
		
		
		
	}
	//this method simulates a turn in the game
	public void turn() {
		calcNeighbors();
		
		for(int i=0;i<cellNum;i++) {  //goes through cells
			for(int j=0;j<cellNum;j++) {
				cells[j][i].calcLife();
				cells[j][i].updateC();
				}
			}
		
		
	}
	
	//calculates the number of neigbors each cell has and updates that number
	public int calcNeighbors() {//could be void
		int count = 0;
		
		for(int i=0;i<cellNum-1;i++) {  //goes through cells
			for(int j=0;j<cellNum-1;j++) {
				if(j>0) {
					if (cells[j-1][i].getLife()) { // i hope to find a more elegant solution to do this...
						count++;
					}
					if (i>0&&cells[j-1][i-1].getLife()) {
						count++;
					}
					if (cells[j-1][i+1].getLife()) {
						count++;
					}
				}
				
				if (i>0&&cells[j+1][i-1].getLife()) {
					count++;
				}
				if (cells[j+1][i+1].getLife()) {
					count++;
				}
				if (cells[j+1][i].getLife()) {
					count++;
				}
				if (cells[j][i+1].getLife()) {
					count++;
				}
				if (i>0&&cells[j][i-1].getLife()) {
					count++;
				}
				cells[j][i].setNeighbors(count);
//				System.out.println(j+","+i+": "+count);
				count = 0;
				
				
			}
		}
		
		return count;
	}
	
	void cellSizeCalc(int wSize) {
		Cell.setSize(wSize/cellNum);
	}
	
	
	
}
