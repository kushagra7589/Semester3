package lab1;

import java.util.Random;
import java.util.Scanner;

public class Game {
	
	int turn;
	
	public Game()
	{
		this.turn = 1;
	}
	
	public void generateRandom(board Board1)
	{
		char value;
		if(this.turn == 1)
		{
			value = 'X';
		}
		else
		{
			value = 'O';
		}
		this.turn = -this.turn;
		char[][] playGrid = Board1.get();
		Random randomno = new Random();
		int x = randomno.nextInt(3);
		int y = randomno.nextInt(3);
		int flag = 0;
		while(flag == 0)
		{
			if(playGrid[x][y] == '-')
			{
				flag = 1;
				Board1.put(x, y, value);
			}
			else
			{
				x = randomno.nextInt(3);
				y = randomno.nextInt(3);
			}
		}
	}
	
	
	public void getBestMove(board Board1)
	{
		char[][] playGrid = Board1.get();
		if(this.turn == 1)
		{
			for(int i=0; i<3; i++)
			{
				if(playGrid[i][0] == playGrid[i][1] && playGrid[i][2] == '-' && playGrid[i][0] == 'X')
				{
					Board1.put(i, 2, 'X');
					this.turn = -this.turn;
					return;
				}
				if(playGrid[i][1] == playGrid[i][2] && playGrid[i][0] == '-' && playGrid[i][1] == 'X')
				{
					Board1.put(i, 0, 'X');
					this.turn = -this.turn;
					return;
				}
				if(playGrid[i][0] == playGrid[i][2] && playGrid[i][1] == '-' && playGrid[i][0] == 'X')
				{
					Board1.put(i, 1, 'X');
					this.turn = -this.turn;
					return;
				}
			}
			for(int i = 0; i<3; i++)
			{
				if(playGrid[0][i] == playGrid[1][i] && playGrid[2][i] == '-' && playGrid[0][i] == 'X')
				{
					Board1.put(2, i, 'X');
					this.turn = -this.turn;
					return;
				}
				if(playGrid[1][i] == playGrid[2][i] && playGrid[0][i] == '-' && playGrid[1][i] == 'X')
				{
					Board1.put(0, i, 'X');
					this.turn = -this.turn;
					return;
				}
				if(playGrid[0][i] == playGrid[2][i] && playGrid[1][i] == '-' && playGrid[0][i] == 'X')
				{
					Board1.put(1, i, 'X');
					this.turn = -this.turn;
					return;
				}
			}
			if(playGrid[0][0] == playGrid[1][1] && playGrid[2][2] == '-' && playGrid[0][0] == 'X')
			{
				Board1.put(2, 2, 'X');
				this.turn = -this.turn;
				return;
			}
			if(playGrid[0][0] == playGrid[2][2] && playGrid[1][1] == '-' && playGrid[0][0] == 'X')
			{
				Board1.put(1, 1, 'X');
				this.turn = -this.turn;
				return;
			}
			if(playGrid[2][2] == playGrid[1][1] && playGrid[0][0] == '-' && playGrid[1][1] == 'X')
			{
				Board1.put(0, 0, 'X');
				this.turn = -this.turn;
				return;
			}
			
			if(playGrid[0][2] == playGrid[1][1] && playGrid[2][0] == '-' && playGrid[0][2] == 'X')
			{
				Board1.put(2, 0, 'X');
				this.turn = -this.turn;
				return;
			}
			if(playGrid[0][2] == playGrid[2][0] && playGrid[1][1] == '-' && playGrid[0][2] == 'X')
			{
				Board1.put(1, 1, 'X');
				this.turn = -this.turn;
				return;
			}
			if(playGrid[2][0] == playGrid[1][1] && playGrid[0][2] == '-' && playGrid[1][1] == 'X')
			{
				Board1.put(0, 2, 'X');
				this.turn = -this.turn;
				return;
			}
			
			
			for(int i=0; i<3; i++)
			{
				if(playGrid[i][0] == playGrid[i][1] && playGrid[i][2] == '-' && playGrid[i][0] == 'O')
				{
					Board1.put(i, 2, 'X');
					this.turn = -this.turn;
					return;
				}
				if(playGrid[i][1] == playGrid[i][2] && playGrid[i][0] == '-' && playGrid[i][1] == 'O')
				{
					Board1.put(i, 0, 'X');
					this.turn = -this.turn;
					return;
				}
				if(playGrid[i][0] == playGrid[i][2] && playGrid[i][1] == '-' && playGrid[i][0] == 'O')
				{
					Board1.put(i, 1, 'X');
					this.turn = -this.turn;
					return;
				}
			}
			for(int i = 0; i<3; i++)
			{
				if(playGrid[0][i] == playGrid[1][i] && playGrid[2][i] == '-' && playGrid[0][i] == 'O')
				{
					Board1.put(2, i, 'X');
					this.turn = -this.turn;
					return;
				}
				if(playGrid[1][i] == playGrid[2][i] && playGrid[0][i] == '-' && playGrid[1][i] == 'O')
				{
					Board1.put(0, i, 'X');
					this.turn = -this.turn;
					return;
				}
				if(playGrid[0][i] == playGrid[2][i] && playGrid[1][i] == '-' && playGrid[0][i] == 'O')
				{
					Board1.put(1, i, 'X');
					this.turn = -this.turn;
					return;
				}
			}
			if(playGrid[0][0] == playGrid[1][1] && playGrid[2][2] == '-' && playGrid[0][0] == 'O')
			{
				Board1.put(2, 2, 'X');
				this.turn = -this.turn;
				return;
			}
			if(playGrid[0][0] == playGrid[2][2] && playGrid[1][1] == '-' && playGrid[0][0] == 'O')
			{
				Board1.put(1, 1, 'X');
				this.turn = -this.turn;
				return;
			}
			if(playGrid[2][2] == playGrid[1][1] && playGrid[0][0] == '-' && playGrid[1][1] == 'O')
			{
				Board1.put(0, 0, 'X');
				this.turn = -this.turn;
				return;
			}
			
			if(playGrid[0][2] == playGrid[1][1] && playGrid[2][0] == '-' && playGrid[0][2] == 'O')
			{
				Board1.put(2, 0, 'X');
				this.turn = -this.turn;
				return;
			}
			if(playGrid[0][2] == playGrid[2][0] && playGrid[1][1] == '-' && playGrid[0][2] == 'O')
			{
				Board1.put(1, 1, 'X');
				this.turn = -this.turn;
				return;
			}
			if(playGrid[2][0] == playGrid[1][1] && playGrid[0][2] == '-' && playGrid[1][1] == 'O')
			{
				Board1.put(0, 2, 'X');
				this.turn = -this.turn;
				return;
			}
			
			this.generateRandom(Board1);
			
		}
		else
		{
			for(int i=0; i<3; i++)
			{
				if(playGrid[i][0] == playGrid[i][1] && playGrid[i][2] == '-' && playGrid[i][0] == 'O')
				{
					Board1.put(i, 2, 'O');
					this.turn = -this.turn;
					return;
				}
				if(playGrid[i][1] == playGrid[i][2] && playGrid[i][0] == '-' && playGrid[i][1] == 'O')
				{
					Board1.put(i, 0, 'O');
					this.turn = -this.turn;
					return;
				}
				if(playGrid[i][0] == playGrid[i][2] && playGrid[i][1] == '-' && playGrid[i][0] == 'O')
				{
					Board1.put(i, 1, 'O');
					this.turn = -this.turn;
					return;
				}
			}
			for(int i = 0; i<3; i++)
			{
				if(playGrid[0][i] == playGrid[1][i] && playGrid[2][i] == '-' && playGrid[0][i] == 'O')
				{
					Board1.put(2, i, 'O');
					this.turn = -this.turn;
					return;
				}
				if(playGrid[1][i] == playGrid[2][i] && playGrid[0][i] == '-' && playGrid[1][i] == 'O')
				{
					Board1.put(0, i, 'O');
					this.turn = -this.turn;
					return;
				}
				if(playGrid[0][i] == playGrid[2][i] && playGrid[1][i] == '-' && playGrid[0][i] == 'O')
				{
					Board1.put(1, i, 'O');
					this.turn = -this.turn;
					return;
				}
			}
			if(playGrid[0][0] == playGrid[1][1] && playGrid[2][2] == '-' && playGrid[0][0] == 'O')
			{
				Board1.put(2, 2, 'O');
				this.turn = -this.turn;
				return;
			}
			if(playGrid[0][0] == playGrid[2][2] && playGrid[1][1] == '-' && playGrid[0][0] == 'O')
			{
				Board1.put(1, 1, 'O');
				this.turn = -this.turn;
				return;
			}
			if(playGrid[2][2] == playGrid[1][1] && playGrid[0][0] == '-' && playGrid[1][1] == 'O')
			{
				Board1.put(0, 0, 'O');
				this.turn = -this.turn;
				return;
			}
			
			if(playGrid[0][2] == playGrid[1][1] && playGrid[2][0] == '-' && playGrid[0][2] == 'O')
			{
				Board1.put(2, 0, 'O');
				this.turn = -this.turn;
				return;
			}
			if(playGrid[0][2] == playGrid[2][0] && playGrid[1][1] == '-' && playGrid[0][2] == 'O')
			{
				Board1.put(1, 1, 'O');
				this.turn = -this.turn;
				return;
			}
			if(playGrid[2][0] == playGrid[1][1] && playGrid[0][2] == '-' && playGrid[1][1] == 'O')
			{
				Board1.put(0, 2, 'O');
				this.turn = -this.turn;
				return;
			}
			
			
			for(int i=0; i<3; i++)
			{
				if(playGrid[i][0] == playGrid[i][1] && playGrid[i][2] == '-' && playGrid[i][0] == 'X')
				{
					Board1.put(i, 2, 'O');
					this.turn = -this.turn;
					return;
				}
				if(playGrid[i][1] == playGrid[i][2] && playGrid[i][0] == '-' && playGrid[i][1] == 'X')
				{
					Board1.put(i, 0, 'O');
					this.turn = -this.turn;
					return;
				}
				if(playGrid[i][0] == playGrid[i][2] && playGrid[i][1] == '-' && playGrid[i][0] == 'X')
				{
					Board1.put(i, 1, 'O');
					this.turn = -this.turn;
					return;
				}
			}
			for(int i = 0; i<3; i++)
			{
				if(playGrid[0][i] == playGrid[1][i] && playGrid[2][i] == '-' && playGrid[0][i] == 'X')
				{
					Board1.put(2, i, 'O');
					this.turn = -this.turn;
					return;
				}
				if(playGrid[1][i] == playGrid[2][i] && playGrid[0][i] == '-' && playGrid[1][i] == 'X')
				{
					Board1.put(0, i, 'O');
					this.turn = -this.turn;
					return;
				}
				if(playGrid[0][i] == playGrid[2][i] && playGrid[1][i] == '-' && playGrid[0][i] == 'X')
				{
					Board1.put(1, i, 'O');
					this.turn = -this.turn;
					return;
				}
			}
			if(playGrid[0][0] == playGrid[1][1] && playGrid[2][2] == '-' && playGrid[0][0] == 'X')
			{
				Board1.put(2, 2, 'O');
				this.turn = -this.turn;
				return;
			}
			if(playGrid[0][0] == playGrid[2][2] && playGrid[1][1] == '-' && playGrid[0][0] == 'X')
			{
				Board1.put(1, 1, 'O');
				this.turn = -this.turn;
				return;
			}
			if(playGrid[2][2] == playGrid[1][1] && playGrid[0][0] == '-' && playGrid[1][1] == 'X')
			{
				Board1.put(0, 0, 'O');
				this.turn = -this.turn;
				return;
			}
			
			if(playGrid[0][2] == playGrid[1][1] && playGrid[2][0] == '-' && playGrid[0][2] == 'X')
			{
				Board1.put(2, 0, 'O');
				this.turn = -this.turn;
				return;
			}
			if(playGrid[0][2] == playGrid[2][0] && playGrid[1][1] == '-' && playGrid[0][2] == 'X')
			{
				Board1.put(1, 1, 'O');
				this.turn = -this.turn;
				return;
			}
			if(playGrid[2][0] == playGrid[1][1] && playGrid[0][2] == '-' && playGrid[1][1] == 'X')
			{
				Board1.put(0, 2, 'O');
				this.turn = -this.turn;
				return;
			}
			
			this.generateRandom(Board1);
		}
	}
	
	public void userMove(board Board1)
	{
		boolean accepted = false;
		while(accepted == false){
			Scanner readValue = new Scanner(System.in);
			int x = readValue.nextInt();
			int y = readValue.nextInt();
			char value;
			if(this.turn == 1)
			{
				value = 'X';
			}
			else
			{
				value = 'O';
			}
			this.turn = -this.turn;
			accepted = Board1.put(x, y, value);
			if(accepted == false)
				this.turn = -this.turn;
		}
	}
	
	public void UserVsComputer(board Board1)
	{
		while(Board1.checkState() == -1)
		{
			Board1.print();
			System.out.println("User's Chance");
			this.userMove(Board1);
			Board1.print();
			if(Board1.checkState() == -1)
			{
				System.out.println();
				System.out.println("Computer's chance");
				this.generateRandom(Board1);
			}
			else
			{
				break;
			}
		}
		return;
	}
	
	public void UserVsUser(board Board1)
	{
		while(Board1.checkState() == -1)
		{
			Board1.print();
			this.userMove(Board1);
		}
		return;
	}
	
	public void ComputerVsAI(board Board1)
	{
		while(Board1.checkState() == -1)
		{
			Board1.print();
			System.out.println("Computer's Chance");
			this.generateRandom(Board1);
			Board1.print();
			if(Board1.checkState() == -1)
			{
				System.out.println();
				System.out.println("AI's Chance: ");
				this.getBestMove(Board1);
			}
			else
			{
				break;
			}
		}
		return;
	}
	
	public void UserVsAI(board Board1)
	{
		while(Board1.checkState() == -1)
		{
			Board1.print();
			System.out.println("User's Chance");
			this.userMove(Board1);
			Board1.print();
			if(Board1.checkState() == -1)
			{
				System.out.println();
				System.out.println("AI's Chance: ");
				this.getBestMove(Board1);
			}
			else
			{
				break;
			}
		}
		Board1.print();
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice_game;
		System.out.println("1. User vs User");
		System.out.println("2. User vs Computer");
		System.out.println("3. Computer vs AI");
		System.out.println("4. User vs AI");
		System.out.println("5. Quit");
		System.out.println("Enter Choice: ");
		Scanner reader = new Scanner(System.in);
		choice_game = reader.nextInt();
		board Board1 = new board();
		Game playGame = new Game();
		switch(choice_game)
		{
		case 1: playGame.UserVsUser(Board1); break;
		case 2: playGame.UserVsComputer(Board1); break;
		case 3: playGame.ComputerVsAI(Board1); break;
		case 4: playGame.UserVsAI(Board1); break;
		case 5: System.exit(0);
		}
	}

}
