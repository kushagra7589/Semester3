import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

class TicTacToe extends JFrame
{

	JPanel windows;
	JPanel mainpage;
	JPanel gamePage;
	JLabel[][] gridLabel;
	JLabel status;
	Timer timer;
//-------- constructor function
	TicTacToe()
	{
		initUI();		//to define the JFrame
	}

//-------- defining the JFrame
	void initUI()
	{
		//setting basic things for frame
		setTitle("TicTacToe");
		setSize(700, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container pane = getContentPane();
		
		//creating the main menu page
		createMainPage();

		//creating the second page!
		createGamePage();

		//making the cardlayout
		windows = new JPanel(new CardLayout());

		//adding all pages to the layout
		windows.add(mainpage, "mainmenu");
		windows.add(gamePage, "game");

		//adding cardlayout to the main frame
		pane.add(windows);
	}

//----------------------- DISPLAY PAGES ------------------------------
//-------- creating the main page
	void createMainPage()
	{
		mainpage = new JPanel();
		//title label

		//buttons to start and exit game
		//styling the buttons
		JButton startButton = styleButton("Start Game", 25);
		JButton exitButton = styleButton("Exit", 25);

		//registering the buttons with event listeners
		//exitButton uses anonymous class
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		//startButton uses derived class
		startButton.addActionListener(new ChangeWindowListener("game"));

		Font mainFont = new Font("Verdana", Font.BOLD, 50);
		JLabel title = new JLabel("Tic Tac Toe");
		title.setFont(mainFont);
		title.setForeground(new Color(82, 66, 22));

		//creating the layout for the main page !
		createLayoutMainPage(title, startButton, exitButton);
		
		mainpage.setBackground(new Color(249, 231, 159));

	}


//-------- creating the game page
	void createGamePage()
	{
		gamePage = new JPanel();
		gridLabel = new JLabel[3][3];
		java.util.List<String> str = new ArrayList<String>();
		Game playGame = new Game('X', 'O');
		Board boardGame = new Board();
		str.add(" ");
		str.add(" ");
		str.add(" ");
		for(int row=0; row<3; row++)
		{
			for(int col=0; col<3; col++)
			{
				gridLabel[row][col] = new JLabel(str.get((row + col)%3));
				gridLabel[row][col].setMinimumSize(new Dimension(90, 90));
				gridLabel[row][col].setMaximumSize(new Dimension(90, 90));
				gridLabel[row][col].setHorizontalAlignment(SwingConstants.CENTER);
				gridLabel[row][col].setVerticalAlignment(SwingConstants.CENTER);
				gridLabel[row][col].setPreferredSize(new Dimension(90, 90));
				gridLabel[row][col].setBorder(new LineBorder(Color.BLACK));
				gridLabel[row][col].setFont(new Font("Verdana", Font.PLAIN, 70));
				gridLabel[row][col].setOpaque(true);
				gridLabel[row][col].setBackground(new Color(223, 221, 226));
				gridLabel[row][col].setForeground(new Color(222, 44, 74));
				gridLabel[row][col].addMouseListener(new LabelListener(playGame, boardGame, row, col));		
			}
		}

		//Buttons for game modes
		JButton userVsUser = styleButton("User1 vs User2 ", 20);
		JButton userVsCpu = styleButton("   User vs CPU   ", 20);
		JButton cpuVsAi = styleButton("  CPU vs AI Bot  ", 20);
		JButton uservsAi = styleButton(" User vs AI Bot  ", 20);
		JButton backButton = styleButton("Back to Main Menu", 20);
		backButton.addActionListener(new ChangeWindowListener("mainmenu"));
		backButton.addActionListener(new ClearGridListener(gridLabel, boardGame, playGame));

		//event listeners for the buttons
		userVsUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//setting all buttons the default color
				userVsUser.setBackground(new Color(7, 145, 140));
				userVsCpu.setBackground(new Color(7, 145, 140));
				cpuVsAi.setBackground(new Color(7, 145, 140));
				uservsAi.setBackground(new Color(7, 145, 140));
				JButton curr = (JButton)e.getSource();
				//highlighting the current button
				curr.setBackground(new Color(31, 129, 205));
				playGame.restart(boardGame);
				JPanel panel = new JPanel();
				JLabel label1 = new JLabel("User1: ");
				JTextField tf1 = new JTextField(10);
				JLabel label2 = new JLabel("User2: ");
				JTextField tf2 = new JTextField(10);
				panel.add(label1);
				panel.add(tf1);
				panel.add(label2);
				panel.add(tf2);
				JLabel startStatus = new JLabel();
				startStatus.setFont(new Font("Verdana", Font.PLAIN, 10));
				startStatus.setForeground(new Color(255, 0, 0));
				panel.add(startStatus);
				String[] options = {"OK"};
				String user1 = "";
				String user2 = "";
				int selectedOption = JOptionPane.showOptionDialog(null, panel, "Usernames", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
				while(selectedOption == 0)
				{
					System.out.println(user1);

					user1 = tf1.getText();
					user2 = tf2.getText();

					if(user1.equals("") ||  user2.equals(""))
					{
						startStatus.setText("Please enter valid usernames!");
						selectedOption = JOptionPane.showOptionDialog(null, panel, "Usernames", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
					}
					else{
						playGame.hm.put("X", user1);
						playGame.hm.put("O", user2);
						break;
					}
				}
				String statusText = playGame.getUser() + "'s turn";
				status.setText(statusText);
				playGame.mode = 1;
			}
		});

		userVsCpu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				userVsUser.setBackground(new Color(7, 145, 140));
				userVsCpu.setBackground(new Color(7, 145, 140));
				cpuVsAi.setBackground(new Color(7, 145, 140));
				uservsAi.setBackground(new Color(7, 145, 140));
				JButton curr = (JButton)e.getSource();
				curr.setBackground(new Color(31, 129, 205));
				playGame.restart(boardGame);
				JPanel panel = new JPanel();
				JLabel label1 = new JLabel("User1: ");
				JTextField tf1 = new JTextField(10);
				panel.add(label1);
				panel.add(tf1);
				JLabel startStatus = new JLabel();
				startStatus.setFont(new Font("Verdana", Font.PLAIN, 10));
				startStatus.setForeground(new Color(255, 0, 0));
				panel.add(startStatus);
				String[] options = {"OK"};
				String user1 = "";
				int selectedOption = JOptionPane.showOptionDialog(null, panel, "Usernames", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
				while(selectedOption == 0)
				{

					user1 = tf1.getText();
					if(user1.equals(""))
					{
						startStatus.setText("Please enter valid usernames!");
						selectedOption = JOptionPane.showOptionDialog(null, panel, "Usernames", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
					}
					else{
						playGame.hm.put("X", user1);
						playGame.hm.put("O", "CPU");
						break;
					}
				}
				String statusText = playGame.getUser() + "'s turn";
				status.setText(statusText);
				playGame.mode = 2;
			}
		});

		uservsAi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				userVsUser.setBackground(new Color(7, 145, 140));
				userVsCpu.setBackground(new Color(7, 145, 140));
				cpuVsAi.setBackground(new Color(7, 145, 140));
				uservsAi.setBackground(new Color(7, 145, 140));
				JButton curr = (JButton)e.getSource();
				curr.setBackground(new Color(31, 129, 205));
				playGame.restart(boardGame);
				JPanel panel = new JPanel();
				JLabel label1 = new JLabel("User1: ");
				JTextField tf1 = new JTextField(10);
				panel.add(label1);
				panel.add(tf1);
				JLabel startStatus = new JLabel();
				startStatus.setFont(new Font("Verdana", Font.PLAIN, 10));
				startStatus.setForeground(new Color(255, 0, 0));
				panel.add(startStatus);
				String[] options = {"OK"};
				String user1 = "";
				int selectedOption = JOptionPane.showOptionDialog(null, panel, "Usernames", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
				while(selectedOption == 0)
				{

					user1 = tf1.getText();
					if(user1.equals(""))
					{
						startStatus.setText("Please enter valid usernames!");
						selectedOption = JOptionPane.showOptionDialog(null, panel, "Usernames", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
					}
					else{
						playGame.hm.put("X", user1);
						playGame.hm.put("O", "AI");
						break;
					}
				}
				String statusText = playGame.getUser() + "'s turn";
				status.setText(statusText);
				playGame.mode = 4;
			}
		});

		cpuVsAi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				userVsUser.setBackground(new Color(7, 145, 140));
				userVsCpu.setBackground(new Color(7, 145, 140));
				cpuVsAi.setBackground(new Color(7, 145, 140));
				uservsAi.setBackground(new Color(7, 145, 140));
				JButton curr = (JButton)e.getSource();
				curr.setBackground(new Color(31, 129, 205));
				playGame.restart(boardGame);
				Random randomno = new Random();
				int count = randomno.nextInt(2);
				if(count == 0)
				{
					playGame.hm.put("X", "CPU");
					playGame.hm.put("O", "AI");
				}
				else
				{
					playGame.hm.put("O", "CPU");
					playGame.hm.put("X", "AI");
				}
				TimeClass tc = new TimeClass(playGame, boardGame);
				timer = new Timer(1000, tc);
				timer.start();
			}
		});

		//Status of the game:
		status = new JLabel();
		status.setFont(new Font("Verdana", Font.PLAIN, 22));
		status.setText("Welcome");
		createGridLayout(gridLabel, userVsUser, userVsCpu, cpuVsAi, uservsAi, backButton, status);

		gamePage.setBackground(new Color(249, 231, 159));
	}

//--------------------------- LAYOUTS -----------------------------------------
//-------- creating Layout for the mainpage
	void createLayoutMainPage(Component... cmp)
	{
		GroupLayout gl = new GroupLayout(mainpage);
		mainpage.setLayout(gl);

		gl.setAutoCreateContainerGaps(true);

		//setting the horizontal layout
		gl.setHorizontalGroup(
			gl.createSequentialGroup()
			.addGap(200).
			addGroup(
			gl.createParallelGroup()
			.addComponent(cmp[0])
			.addGap(150)
			.addGroup(gl.createSequentialGroup()
				.addComponent(cmp[1])
				.addGap(30)
				.addComponent(cmp[2])
				)
			)
		);

		//setting the vertical layout
		gl.setVerticalGroup(gl.createSequentialGroup()
			.addGap(150)
			.addComponent(cmp[0])
			.addGap(150)
			.addGroup(gl.createParallelGroup()
				.addComponent(cmp[1])
				.addGap(200)
				.addComponent(cmp[2])
				)
		);
	}


//-------- creating the layout for the grid
	void createGridLayout(JLabel[][] grid, Component... cmp)
	{
		GroupLayout gl = new GroupLayout(gamePage);
		gamePage.setLayout(gl);

		gl.setAutoCreateContainerGaps(true);

		gl.setHorizontalGroup(gl.createSequentialGroup()
			.addGap(40)
			.addGroup(gl.createParallelGroup()
				.addGap(160)
				.addComponent(cmp[0])
				.addGap(35)
				.addComponent(cmp[1])
				.addGap(35)
				.addComponent(cmp[2])
				.addGap(35)
				.addComponent(cmp[3])
				.addGap(80)
				.addComponent(cmp[4])
			)
			.addGap(60)
			.addGroup(gl.createParallelGroup()
				.addGap(150)
				.addGroup(gl.createSequentialGroup()
					.addComponent(grid[0][0])
					.addComponent(grid[0][1])
					.addComponent(grid[0][2])
				)
				.addGroup(gl.createSequentialGroup()
					.addComponent(grid[1][0])
					.addComponent(grid[1][1])
					.addComponent(grid[1][2])
				)
				.addGroup(gl.createSequentialGroup()
					.addComponent(grid[2][0])
					.addComponent(grid[2][1])
					.addComponent(grid[2][2])
				)
				.addGap(25)
				.addComponent(cmp[5])
			)
		);

		gl.setVerticalGroup(gl.createParallelGroup()
			.addGap(40)
			.addGroup(gl.createSequentialGroup()
				.addGap(160)
				.addComponent(cmp[0])
				.addGap(35)
				.addComponent(cmp[1])
				.addGap(35)
				.addComponent(cmp[2])
				.addGap(35)
				.addComponent(cmp[3])
				.addGap(80)
				.addComponent(cmp[4])
			)
			.addGap(60)
			.addGroup(gl.createSequentialGroup()
				.addGap(150)
				.addGroup(gl.createParallelGroup()
					.addComponent(grid[0][0])
					.addComponent(grid[0][1])
					.addComponent(grid[0][2])
				)
				.addGroup(gl.createParallelGroup()
					.addComponent(grid[1][0])
					.addComponent(grid[1][1])
					.addComponent(grid[1][2])
				)
				.addGroup(gl.createParallelGroup()
					.addComponent(grid[2][0])
					.addComponent(grid[2][1])
					.addComponent(grid[2][2])
				)	
				.addGap(25)
				.addComponent(cmp[5])	
			)
		);
	}	


//-------------------------- EVENT LISTENERS -----------------------------
//-------- implementing the change of page
	private class ChangeWindowListener implements ActionListener
	{

		String panelName;
		ChangeWindowListener(String s)
		{
			this.panelName = s;
		}
		@Override
		public void actionPerformed(ActionEvent e)
		{
			CardLayout cl = (CardLayout)windows.getLayout();
			cl.show(windows, this.panelName);
		}
	}

	private class LabelListener extends MouseAdapter
	{
		Game game;
		Board board;
		int x;
		int y;

		LabelListener(Game g, Board b, int row, int col)
		{
			game = g;
			board = b;
			x = row;
			y = col;
		}

		@Override
		public void mousePressed(MouseEvent e)
		{
			if(game.mode == 0)
			{

			}
			else if(game.mode == 1)
			{
				if(game.checkState(board) == -1)
				{
					game.userMove(board, x, y);
					int a  = game.checkState(board);
				}
			}
			else if(game.mode == 2)
			{
				if(game.checkState(board) == -1)
				{
					game.userMove(board, x, y);
					if(game.checkState(board) == -1)
					{
						game.cpuMove(board);
					}
					int a  = game.checkState(board);
				}
			}
			else if(game.mode == 4)
			{
				if(game.checkState(board) == -1)
				{
					game.userMove(board, x, y);
					if(game.checkState(board) == -1)
						game.getBestMove(board);
					int a = game.checkState(board);
				}
			}
		}
	}

	private class ClearGridListener implements ActionListener
	{
		JLabel[][] g;
		Board b;
		Game game;

		ClearGridListener(JLabel[][] grid, Board bb, Game x)
		{
			g = grid;
			b = bb;
			game = x;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			for(int i=0; i<3; i++)
			{
				for(int j=0; j<3; j++)
				{
					g[i][j].setText(" ");
				}
			}
			game.restart(b);
		}
	}

	private class TimeClass implements ActionListener
	{
		Game game;
		Board board;

		TimeClass(Game g, Board b)
		{
			game = g;
			board = b;
		}
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(game.checkState(board) != -1)
			{
				game.mode = 0;
				timer.stop();
			}
			else if(game.turn == 1)
			{
				String currPlayer = game.hm.get(String.valueOf(game.player));
				status.setText(currPlayer+"'s turn");	
				if(currPlayer.equals("CPU"))
					game.cpuMove(board);
				else
					game.getBestMove(board);
			}
			else if(game.turn == -1)
			{
				String currPlayer = game.hm.get(String.valueOf(game.opponent));
				status.setText(currPlayer + "'s turn");
				if(currPlayer.equals("CPU"))
					game.cpuMove(board);
				else
					game.getBestMove(board);
			}
		}
	}

//--------------------- STYLING UTILITIES -------------------------
	JButton styleButton(String buttonText, int fontSize)
	{
		JButton button = new JButton(buttonText);
		button.setBackground(new Color(7, 145, 140));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Verdana", Font.PLAIN, fontSize));
		return button;
	}

//--------------------- MAIN FUNCTION ----------------------------
	public static void main(String[] args) {
		TicTacToe g = new TicTacToe();
		g.setVisible(true);
	}

//---------------- LOGIC OF THE GAME -> THE GAME CLASS -------------------
	class Game
	{
		int turn;
		char player;
		char opponent;
		int mode;
		Map<String, String> hm;

		public Game(char x, char o) {player = x; opponent = o; turn = 1; mode = 0; hm = new HashMap<String, String>(); }

		public void restart(Board board)
		{
			board.clear();
			this.turn = 1;
			for(int i=0; i<3; i++)
			{
				for(int j=0; j<3; j++)
				{
					gridLabel[i][j].setBackground(new Color(223, 221, 226));
				}
			}
			status.setText("Welcome");
			mode = 0;
			hm.put(String.valueOf(player), "");
			hm.put(String.valueOf(opponent), "");
		}
		public int checkState(Board board)
		{
			for(int i=0; i<3; i++)
			{
				if(board.grid[i][0] == board.grid[i][1] && board.grid[i][1] == board.grid[i][2])
				{
					if(board.grid[i][0] == player)
					{
						for(int j=0; j<3; j++)
						{
							gridLabel[i][j].setBackground(new Color(27, 203, 51));
						}
						System.out.println(player + " wins");
						String text = hm.get(String.valueOf(player)) + " wins";
						status.setText(text);
						return 1;
					}
					else if(board.grid[i][0] == opponent)
					{
						for(int j=0; j<3; j++)
						{
							gridLabel[i][j].setBackground(new Color(27, 203, 51));
						}
						String text = hm.get(String.valueOf(opponent)) + " wins";
						status.setText(text);
						System.out.println(opponent + " wins");
						return 2;
					}
				}
			}
			
			for(int i=0; i<3; i++)
			{
				if(board.grid[0][i] == board.grid[1][i] && board.grid[1][i] == board.grid[2][i])
				{
					
					if(board.grid[0][i] == player)
					{
						for(int j=0; j<3; j++)
						{
							gridLabel[j][i].setBackground(new Color(27, 203, 51));
						}
						System.out.println(player + " wins");
						String text = hm.get(String.valueOf(player)) + " wins";
						status.setText(text);
						return 1;
					}
					else if(board.grid[0][i] == opponent)
					{
						for(int j=0; j<3; j++)
						{
							gridLabel[j][i].setBackground(new Color(27, 203, 51));
						}
						System.out.println(opponent + " wins");
						String text = hm.get(String.valueOf(opponent)) + " wins";
						status.setText(text);
						return 2;
					}
				}
			}
			
			if(board.grid[0][0] == board.grid[1][1] && board.grid[1][1] == board.grid[2][2]){
				
				if(board.grid[0][0] == player)
				{
					for(int j=0; j<3; j++)
					{
						gridLabel[j][j].setBackground(new Color(27, 203, 51));
					}
					System.out.println(player + " wins");
					String text = hm.get(String.valueOf(player)) + " wins";
					status.setText(text);
					return 1;
				}
				else if(board.grid[0][0] == opponent)
				{
					for(int j=0; j<3; j++)
					{
						gridLabel[j][j].setBackground(new Color(27, 203, 51));
					}
					System.out.println(opponent + " wins");
					String text = hm.get(String.valueOf(opponent)) + " wins";
					status.setText(text);
					return 2;
				}
			}
			
			if(board.grid[0][2] == board.grid[1][1] && board.grid[1][1] == board.grid[2][0]){
				if(board.grid[0][2] == player)
				{
					for(int j=0; j<3; j++)
					{
						gridLabel[j][2-j].setBackground(new Color(27, 203, 51));
					}
					System.out.println(player + " wins");
					String text = hm.get(String.valueOf(player)) + " wins";
					status.setText(text);
					return 1;
				}
				else if(board.grid[0][2] == opponent)
				{
					for(int j=0; j<3; j++)
					{
						gridLabel[j][2-j].setBackground(new Color(27, 203, 51));
					}
					System.out.println(opponent + " wins");
					String text = hm.get(String.valueOf(opponent)) + " wins";
					status.setText(text);
					return 2;
				}
			}

			for(int i=0; i<3; i++)
			{
				for(int j=0; j<3; j++)
				{
					if(board.grid[i][j] == '-')
						return -1;
				}
			}

			System.out.println("Draw!");
			String text = "It is a Draw";
			status.setText(text);
			return 0;
		}
	
		public void getBestMove(Board board1)
		{
			char[][] playGrid = board1.get();
			if(this.turn == 1)
			{
				for(int i=0; i<3; i++)
				{
					if(playGrid[i][0] == playGrid[i][1] && playGrid[i][2] == '-' && playGrid[i][0] == 'X')
					{
						board1.put(i, 2, 'X');
						gridLabel[i][2].setText("X");
						this.turn = -this.turn;
						return;
					}
					if(playGrid[i][1] == playGrid[i][2] && playGrid[i][0] == '-' && playGrid[i][1] == 'X')
					{
						board1.put(i, 0, 'X');
						gridLabel[i][0].setText("X");
						this.turn = -this.turn;
						return;
					}
					if(playGrid[i][0] == playGrid[i][2] && playGrid[i][1] == '-' && playGrid[i][0] == 'X')
					{
						board1.put(i, 1, 'X');
						gridLabel[i][1].setText("X");
						this.turn = -this.turn;
						return;
					}
				}
				for(int i = 0; i<3; i++)
				{
					if(playGrid[0][i] == playGrid[1][i] && playGrid[2][i] == '-' && playGrid[0][i] == 'X')
					{
						board1.put(2, i, 'X');
						gridLabel[2][i].setText("X");
						this.turn = -this.turn;
						return;
					}
					if(playGrid[1][i] == playGrid[2][i] && playGrid[0][i] == '-' && playGrid[1][i] == 'X')
					{
						board1.put(0, i, 'X');
						gridLabel[0][i].setText("X");
						this.turn = -this.turn;
						return;
					}
					if(playGrid[0][i] == playGrid[2][i] && playGrid[1][i] == '-' && playGrid[0][i] == 'X')
					{
						board1.put(1, i, 'X');
						gridLabel[1][i].setText("X");
						this.turn = -this.turn;
						return;
					}
				}
				if(playGrid[0][0] == playGrid[1][1] && playGrid[2][2] == '-' && playGrid[0][0] == 'X')
				{
					board1.put(2, 2, 'X');
					gridLabel[2][2].setText("X");
					this.turn = -this.turn;
					return;
				}
				if(playGrid[0][0] == playGrid[2][2] && playGrid[1][1] == '-' && playGrid[0][0] == 'X')
				{
					board1.put(1, 1, 'X');
					gridLabel[1][1].setText("X");
					this.turn = -this.turn;
					return;
				}
				if(playGrid[2][2] == playGrid[1][1] && playGrid[0][0] == '-' && playGrid[1][1] == 'X')
				{
					board1.put(0, 0, 'X');
					gridLabel[0][0].setText("X");
					this.turn = -this.turn;
					return;
				}
				
				if(playGrid[0][2] == playGrid[1][1] && playGrid[2][0] == '-' && playGrid[0][2] == 'X')
				{
					board1.put(2, 0, 'X');
					gridLabel[2][0].setText("X");
					this.turn = -this.turn;
					return;
				}
				if(playGrid[0][2] == playGrid[2][0] && playGrid[1][1] == '-' && playGrid[0][2] == 'X')
				{
					board1.put(1, 1, 'X');
					gridLabel[1][1].setText("X");
					this.turn = -this.turn;
					return;
				}
				if(playGrid[2][0] == playGrid[1][1] && playGrid[0][2] == '-' && playGrid[1][1] == 'X')
				{
					board1.put(0, 2, 'X');
					gridLabel[0][2].setText("X");
					this.turn = -this.turn;
					return;
				}
				
				for(int i=0; i<3; i++)
				{
					if(playGrid[i][0] == playGrid[i][1] && playGrid[i][2] == '-' && playGrid[i][0] == 'O')
					{
						board1.put(i, 2, 'X');
						gridLabel[i][2].setText("X");
						this.turn = -this.turn;
						return;
					}
					if(playGrid[i][1] == playGrid[i][2] && playGrid[i][0] == '-' && playGrid[i][1] == 'O')
					{
						board1.put(i, 0, 'X');
						gridLabel[i][0].setText("X");
						this.turn = -this.turn;
						return;
					}
					if(playGrid[i][0] == playGrid[i][2] && playGrid[i][1] == '-' && playGrid[i][0] == 'O')
					{
						board1.put(i, 1, 'X');
						gridLabel[i][1].setText("X");
						this.turn = -this.turn;
						return;
					}
				}
				for(int i = 0; i<3; i++)
				{
					if(playGrid[0][i] == playGrid[1][i] && playGrid[2][i] == '-' && playGrid[0][i] == 'O')
					{
						board1.put(2, i, 'X');
						gridLabel[2][i].setText("X");
						this.turn = -this.turn;
						return;
					}
					if(playGrid[1][i] == playGrid[2][i] && playGrid[0][i] == '-' && playGrid[1][i] == 'O')
					{
						board1.put(0, i, 'X');
						gridLabel[0][i].setText("X");
						this.turn = -this.turn;
						return;
					}
					if(playGrid[0][i] == playGrid[2][i] && playGrid[1][i] == '-' && playGrid[0][i] == 'O')
					{
						board1.put(1, i, 'X');
						gridLabel[1][i].setText("X");
						this.turn = -this.turn;
						return;
					}
				}
				if(playGrid[0][0] == playGrid[1][1] && playGrid[2][2] == '-' && playGrid[0][0] == 'O')
				{
					board1.put(2, 2, 'X');
					gridLabel[2][2].setText("X");
					this.turn = -this.turn;
					return;
				}
				if(playGrid[0][0] == playGrid[2][2] && playGrid[1][1] == '-' && playGrid[0][0] == 'O')
				{
					board1.put(1, 1, 'X');
					gridLabel[1][1].setText("X");
					this.turn = -this.turn;
					return;
				}
				if(playGrid[2][2] == playGrid[1][1] && playGrid[0][0] == '-' && playGrid[1][1] == 'O')
				{
					board1.put(0, 0, 'X');
					gridLabel[0][0].setText("X");
					this.turn = -this.turn;
					return;
				}
				
				if(playGrid[0][2] == playGrid[1][1] && playGrid[2][0] == '-' && playGrid[0][2] == 'O')
				{
					board1.put(2, 0, 'X');
					gridLabel[2][0].setText("X");
					this.turn = -this.turn;
					return;
				}
				if(playGrid[0][2] == playGrid[2][0] && playGrid[1][1] == '-' && playGrid[0][2] == 'O')
				{
					board1.put(1, 1, 'X');
					gridLabel[2][1].setText("X");
					this.turn = -this.turn;
					return;
				}
				if(playGrid[2][0] == playGrid[1][1] && playGrid[0][2] == '-' && playGrid[1][1] == 'O')
				{
					board1.put(0, 2, 'X');
					gridLabel[0][2].setText("X");
					this.turn = -this.turn;
					return;
				}
				
				this.cpuMove(board1);
				
			}
			else
			{
				for(int i=0; i<3; i++)
				{
					if(playGrid[i][0] == playGrid[i][1] && playGrid[i][2] == '-' && playGrid[i][0] == 'O')
					{
						board1.put(i, 2, 'O');
						gridLabel[i][2].setText("O");
						this.turn = -this.turn;
						return;
					}
					if(playGrid[i][1] == playGrid[i][2] && playGrid[i][0] == '-' && playGrid[i][1] == 'O')
					{
						board1.put(i, 0, 'O');
						gridLabel[i][0].setText("O");
						this.turn = -this.turn;
						return;
					}
					if(playGrid[i][0] == playGrid[i][2] && playGrid[i][1] == '-' && playGrid[i][0] == 'O')
					{
						board1.put(i, 1, 'O');
						gridLabel[i][1].setText("O");
						this.turn = -this.turn;
						return;
					}
				}
				for(int i = 0; i<3; i++)
				{
					if(playGrid[0][i] == playGrid[1][i] && playGrid[2][i] == '-' && playGrid[0][i] == 'O')
					{
						board1.put(2, i, 'O');
						gridLabel[2][i].setText("O");
						this.turn = -this.turn;
						return;
					}
					if(playGrid[1][i] == playGrid[2][i] && playGrid[0][i] == '-' && playGrid[1][i] == 'O')
					{
						board1.put(0, i, 'O');
						gridLabel[0][i].setText("O");
						this.turn = -this.turn;
						return;
					}
					if(playGrid[0][i] == playGrid[2][i] && playGrid[1][i] == '-' && playGrid[0][i] == 'O')
					{
						board1.put(1, i, 'O');
						gridLabel[1][i].setText("O");
						this.turn = -this.turn;
						return;
					}
				}
				if(playGrid[0][0] == playGrid[1][1] && playGrid[2][2] == '-' && playGrid[0][0] == 'O')
				{
					board1.put(2, 2, 'O');
					gridLabel[2][2].setText("O");
					this.turn = -this.turn;
					return;
				}
				if(playGrid[0][0] == playGrid[2][2] && playGrid[1][1] == '-' && playGrid[0][0] == 'O')
				{
					board1.put(1, 1, 'O');
					gridLabel[1][1].setText("O");
					this.turn = -this.turn;
					return;
				}
				if(playGrid[2][2] == playGrid[1][1] && playGrid[0][0] == '-' && playGrid[1][1] == 'O')
				{
					board1.put(0, 0, 'O');
					gridLabel[0][0].setText("O");
					this.turn = -this.turn;
					return;
				}
				
				if(playGrid[0][2] == playGrid[1][1] && playGrid[2][0] == '-' && playGrid[0][2] == 'O')
				{
					board1.put(2, 0, 'O');
					gridLabel[2][0].setText("O");
					this.turn = -this.turn;
					return;
				}
				if(playGrid[0][2] == playGrid[2][0] && playGrid[1][1] == '-' && playGrid[0][2] == 'O')
				{
					board1.put(1, 1, 'O');
					gridLabel[1][1].setText("O");
					this.turn = -this.turn;
					return;
				}
				if(playGrid[2][0] == playGrid[1][1] && playGrid[0][2] == '-' && playGrid[1][1] == 'O')
				{
					board1.put(0, 2, 'O');
					gridLabel[0][2].setText("O");
					this.turn = -this.turn;
					return;
				}
				
				
				for(int i=0; i<3; i++)
				{
					if(playGrid[i][0] == playGrid[i][1] && playGrid[i][2] == '-' && playGrid[i][0] == 'X')
					{
						board1.put(i, 2, 'O');
						gridLabel[i][2].setText("O");
						this.turn = -this.turn;
						return;
					}
					if(playGrid[i][1] == playGrid[i][2] && playGrid[i][0] == '-' && playGrid[i][1] == 'X')
					{
						board1.put(i, 0, 'O');
						gridLabel[i][0].setText("O");
						this.turn = -this.turn;
						return;
					}
					if(playGrid[i][0] == playGrid[i][2] && playGrid[i][1] == '-' && playGrid[i][0] == 'X')
					{
						board1.put(i, 1, 'O');
						gridLabel[i][1].setText("O");
						this.turn = -this.turn;
						return;
					}
				}
				for(int i = 0; i<3; i++)
				{
					if(playGrid[0][i] == playGrid[1][i] && playGrid[2][i] == '-' && playGrid[0][i] == 'X')
					{
						board1.put(2, i, 'O');
						gridLabel[2][i].setText("O");
						this.turn = -this.turn;
						return;
					}
					if(playGrid[1][i] == playGrid[2][i] && playGrid[0][i] == '-' && playGrid[1][i] == 'X')
					{
						board1.put(0, i, 'O');
						gridLabel[0][i].setText("O");
						this.turn = -this.turn;
						return;
					}
					if(playGrid[0][i] == playGrid[2][i] && playGrid[1][i] == '-' && playGrid[0][i] == 'X')
					{
						board1.put(1, i, 'O');
						gridLabel[1][i].setText("O");
						this.turn = -this.turn;
						return;
					}
				}
				if(playGrid[0][0] == playGrid[1][1] && playGrid[2][2] == '-' && playGrid[0][0] == 'X')
				{
					board1.put(2, 2, 'O');
					gridLabel[2][2].setText("O");
					this.turn = -this.turn;
					return;
				}
				if(playGrid[0][0] == playGrid[2][2] && playGrid[1][1] == '-' && playGrid[0][0] == 'X')
				{
					board1.put(1, 1, 'O');
					gridLabel[1][1].setText("O");
					this.turn = -this.turn;
					return;
				}
				if(playGrid[2][2] == playGrid[1][1] && playGrid[0][0] == '-' && playGrid[1][1] == 'X')
				{
					board1.put(0, 0, 'O');
					gridLabel[0][0].setText("O");
					this.turn = -this.turn;
					return;
				}
				
				if(playGrid[0][2] == playGrid[1][1] && playGrid[2][0] == '-' && playGrid[0][2] == 'X')
				{
					board1.put(2, 0, 'O');
					gridLabel[2][0].setText("O");
					this.turn = -this.turn;
					return;
				}
				if(playGrid[0][2] == playGrid[2][0] && playGrid[1][1] == '-' && playGrid[0][2] == 'X')
				{
					board1.put(1, 1, 'O');
					gridLabel[1][1].setText("O");
					this.turn = -this.turn;
					return;
				}
				if(playGrid[2][0] == playGrid[1][1] && playGrid[0][2] == '-' && playGrid[1][1] == 'X')
				{
					board1.put(0, 2, 'O');
					gridLabel[0][2].setText("O");
					this.turn = -this.turn;
					return;
				}
				
				this.cpuMove(board1);
			}
		}

		char getValue()
		{
			if(this.turn == 1)
				return 'X';
			return 'O';
		}
	
		public void userMove(Board board1, int x, int y)
		{
			boolean accepted = false;
			char value = getValue();
			accepted = board1.put(x, y, value);
			if(accepted == true)
			{
				this.turn = -this.turn;
				String statusText = getUser() +  "'s turn ";
				status.setText(statusText);
				gridLabel[x][y].setText(String.valueOf(value));
			}
		}

		public void cpuMove(Board board1)
		{
			char value = getValue();
			this.turn = -this.turn;
			String statusText = getUser() +  "'s turn ";
			status.setText(statusText);
			char[][] playGrid = board1.get();
			Random randomNo = new Random();
			int x = randomNo.nextInt(3);
			int y = randomNo.nextInt(3);
			int flag = 0;
			while(flag == 0)
			{
				if(playGrid[x][y] == '-')
				{
					flag = 1;
					gridLabel[x][y].setText(String.valueOf(value));
					board1.put(x, y, value);
				}
				else
				{
					x = randomNo.nextInt(3);
					y = randomNo.nextInt(3);
				}
			}
		}

		public String getUser()
		{
			if(this.turn == 1)
				return hm.get(String.valueOf(player));
			else
				return hm.get(String.valueOf(opponent));
		}
	}

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

		void clear()
		{
			for(int i=0; i<3; i++)
			{
				for(int j=0; j<3; j++)
				{
					grid[i][j] = '-';
					gridLabel[i][j].setText(" ");
				}
			}
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
}