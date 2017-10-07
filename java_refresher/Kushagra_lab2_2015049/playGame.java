package game2048;

import java.util.Scanner;

public class playGame {
	
	public static void moves(myPuzzle puzzle, int[][] playGrid){ 
		Scanner readme = new Scanner(System.in);
		char choice = readme.next().charAt(0);
		while(choice != 'Q'){
			switch(choice){
			case 'R' : puzzle.moveRight(playGrid); puzzle.displayGrid(playGrid); break;
			case 'L' : puzzle.moveLeft(playGrid); puzzle.displayGrid(playGrid);break;
			case 'U' : puzzle.moveUp(playGrid); puzzle.displayGrid(playGrid);break;
			case 'D'  : puzzle.moveDown(playGrid); puzzle.displayGrid(playGrid);break;
			}
			choice = readme.next().charAt(0);
		}
		System.exit(0);
	}
	
	public static void main(String[] args){
		int[][] playGrid = new int[4][4];
		myPuzzle puzzle = new myPuzzle(playGrid);
		moves(puzzle, playGrid);
		
	}
}
