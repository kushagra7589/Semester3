class Board
{
	char[][] grid = new char[3][3];
	
	public Board()
	{
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				grid[i][j] = '-';
			}
		}
	}

	public char[][] get()
	{
		return grid;
	}
	
	public void print()
	{
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				System.out.print(grid[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}


	public boolean put(int x, int y, char value)
	{
		if(x < 3 && x>=0 && y < 3 && y >= 0)
		{
			if(grid[x][y] == '-')
			{
				grid[x][y] = value;
				return true;
			}	
			else
			{
				System.out.println("Invalid Co-ordinates");
				
				return false;
			}
		}
		else
		{
			System.out.println("Invalid Co-ordinates");
			return false;
		}
	}

}