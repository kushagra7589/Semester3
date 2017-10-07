import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Menu extends JFrame
{
	public Menu()
	{
		initUI();
	}

	void initUI()
	{
		setTitle("Game choices!");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		createMenuBar();
	}

	void createMenuBar()
	{
		JMenuBar menubar = new JMenuBar();
		JMenu type = new JMenu("Type");

		JMenuItem uservsuser = new JMenuItem("User1 vs User2");
		JMenuItem uservscpu = new JMenuItem("User vs CPU");
		JMenuItem cpuvsai = new JMenuItem("CPU vs AI");
		JMenuItem uservsai = new JMenuItem("User vs AI");
		JMenuItem exit = new JMenuItem("Exit");

		exit.setToolTipText("Exit Application");
		exit.addActionListener((ActionEvent event) -> {
			System.exit(0);
		});

		type.add(uservsuser);
		type.add(uservscpu);
		type.add(cpuvsai);
		type.add(uservsai);
		type.addSeparator();
		type.add(exit);

		menubar.add(type);

		setJMenuBar(menubar);
	}

	public static void main(String[] args)
	{
		Menu m = new Menu();
		m.setVisible(true);
	}

}