package game2048;
import java.util.Random;
public class myPuzzle {
	
	myPuzzle(int[][] playGrid){
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				playGrid[i][j] = 0;
			}
		}
		generateTile(playGrid);
		displayGrid(playGrid);
	}
	
	public void generateTile(int[][] playGrid){
		Random rand_num = new Random();
		int num = rand_num.nextInt(16);
		int row = num/4;
		int col = num%4;
		while(playGrid[row][col] != 0){
			num = rand_num.nextInt(16);
			row = num/4;
			col = num%4;
		}
		num = rand_num.nextInt(2);
		num = (num+1)*2;
		playGrid[row][col] = num;
	}
	
	public void displayGrid(int[][] playGrid){
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				System.out.print(playGrid[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public boolean isOver(int[][] playGrid){
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				if(playGrid[i][j] == 0)
					return false;
				if(j != 3)
					if(playGrid[i][j] == playGrid[i][j+1])
						return false;
				if(i != 3)
					if(playGrid[i][j] == playGrid[i+1][j])
						return false;
			}
		}
		return true;
	}
	
	public boolean hasWon(int[][] playGrid){
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				if(playGrid[i][j] == 2048)
					return true;
			}
		}
		return false;
	}
	
	public void rotate_clockwise(int[][] playGrid){
		int[][] interGrid = new int[4][4];
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				interGrid[j][4-i-1] = playGrid[i][j];
			}
		}
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				playGrid[i][j] = interGrid[i][j];
			}
		}
	}
	
	public void rotate_anticlockwise(int[][] playGrid){
		int[][] interGrid = new int[4][4];
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				interGrid[4-j-1][i] = playGrid[i][j];
			}
		}
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				playGrid[i][j] = interGrid[i][j];
			}
		}
	}
	
	public void rotate_180(int [][] playGrid){
		rotate_clockwise(playGrid);
		rotate_clockwise(playGrid);
	}
	
	public void moveRight(int[][] playGrid){
		if(isOver(playGrid) == true){
			System.out.println("Sorry, You have lost!");
			System.exit(0);
		}
		int flag = 0;
		for(int i=0; i<4; i++){
			int j=0;
			while(j < 4 && playGrid[i][j] == 0)
				j++;
			while(j < 3){
				if(playGrid[i][j] == playGrid[i][j+1] && flag == 0){
					playGrid[i][j] = 0;
					playGrid[i][j+1] = playGrid[i][j+1]*2;
					j++;
					flag = 1;
				}
				else if(playGrid[i][j] == playGrid[i][j+1] && flag == 1){
					if(j < 2){
						int done = 0;
						if(playGrid[i][j+2] == playGrid[i][j+1] && flag == 0){
							playGrid[i][j+2] = playGrid[i][j+2]*2;
							flag = 1;
						}
						else if (playGrid[i][j+2] == 0){
							playGrid[i][j+2] = playGrid[i][j+1];
						}
						else if (playGrid[i][j+2] != playGrid[i][j+1]){
							if(j < 1){
								if(playGrid[i][j+3] == playGrid[i][j+2]){
									playGrid[i][j+3] = playGrid[i][j+3]*2;
									playGrid[i][j+2] = playGrid[i][j+1];
								}
								else if(playGrid[i][j+3] == 0){
									playGrid[i][j+3] = playGrid[i][j+2];
									playGrid[i][j+2] = playGrid[i][j+1];
								}
							}
							else{
								j = 4;
								done = 1;
							}
						}
						if(done == 0){
							playGrid[i][j+1] = playGrid[i][j];
							playGrid[i][j] = 0;
							j++;
						}
					}
					else{
						j++;
					}
				}
				else if (playGrid[i][j+1] == 0){
					playGrid[i][j+1] = playGrid[i][j];
					playGrid[i][j] = 0;
					j++;
				}
				else if (playGrid[i][j] != playGrid[i][j+1]){
					if(j < 2){
						int done = 0;
						if(playGrid[i][j+2] == playGrid[i][j+1] && flag == 0){
							playGrid[i][j+2] = playGrid[i][j+2]*2;
							flag = 1;
						}
						else if (playGrid[i][j+2] == 0){
							playGrid[i][j+2] = playGrid[i][j+1];
						}
						else if (playGrid[i][j+2] != playGrid[i][j+1]){
							if(j < 1){
								if(playGrid[i][j+3] == playGrid[i][j+2]){
									playGrid[i][j+3] = playGrid[i][j+3]*2;
									playGrid[i][j+2] = playGrid[i][j+1];
								}
								else if(playGrid[i][j+3] == 0){
									playGrid[i][j+3] = playGrid[i][j+2];
									playGrid[i][j+2] = playGrid[i][j+1];
								}
							}
							else{
								j = 4;
								done = 1;
							}
						}
						if(done == 0){
							playGrid[i][j+1] = playGrid[i][j];
							playGrid[i][j] = 0;
							j++;
						}
					}
					else{
						j++;
					}
				}
			}
		}
		if(hasWon(playGrid) == true){
			System.out.println("You win!");
		}
		
		generateTile(playGrid);
	}
	
	public void moveLeft(int[][] playGrid){
		rotate_180(playGrid);
		moveRight(playGrid);
		rotate_anticlockwise(playGrid);
		rotate_anticlockwise(playGrid);
	}
	
	public void moveUp(int[][] playGrid){
		rotate_clockwise(playGrid);
//		System.out.println("clockwise rotation");
//		displayGrid(playGrid);
		moveRight(playGrid);
		rotate_anticlockwise(playGrid);
//		System.out.println("Back to normal" );
	}
	
	public void moveDown(int[][] playGrid){
		rotate_anticlockwise(playGrid);
//		System.out.println("anticlockwise rotation");
//		displayGrid(playGrid);
		moveRight(playGrid);
		rotate_clockwise(playGrid);
//		System.out.println("Back to normal" );
	}
}
