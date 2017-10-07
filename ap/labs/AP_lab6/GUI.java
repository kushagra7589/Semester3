import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// class MyFrame extends JFrame
// {
// 	public MyFrame()
// 	{
// 		setTitle("My Empty Frame");
// 		setSize(300, 200);
// 		setLocationRelativeTo(null);
// 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 	}

// 	public static void main(String[] args)
// 	{
// 		MyFrame f = new MyFrame();
// 		// f.pack();
// 		f.setVisible(true);
// 	}
// }

class QuitButtonEx extends JFrame
{
	public QuitButtonEx()
	{
		initUI();
	}

	void initUI()
	{
		JButton quitButton = new JButton("Quit");
		JButton anotherButton = new JButton("Nothing!");
		JButton button = new JButton("More nothing!");
		JButton nothin = new JButton("Nothing again!");

		quitButton.addActionListener((ActionEvent event) -> {
			System.out.println("Exiting the frame ! Bye Bye !");
			System.exit(0);
		});

		anotherButton.addActionListener((ActionEvent event) -> {
			getContentPane().setBackground(new Color(235, 223, 141));
		});

		setTitle("Quit Button");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setLocationRelativeTo(null);

		createLayout(quitButton, anotherButton);
	}

	void createLayout(JComponent... arg)
	{
		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setAutoCreateContainerGaps(true);
		gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(arg[0]).addGap(10).addComponent(arg[1]));
		gl.setVerticalGroup(gl.createParallelGroup().addComponent(arg[0]).addComponent(arg[1]));

	}

	public static void main(String[] args)
	{
		QuitButtonEx ex = new QuitButtonEx();
		ex.setVisible(true);
	} 

}