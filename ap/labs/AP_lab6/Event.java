import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EventObject extends JFrame
{
	EventObject()
	{
		initUI();
	}

	void initUI()
	{
		setTitle("Check Event!");
		JButton clickButton = new JButton("Click!");
		JButton exitButton = new JButton("Exit!");
		clickButton.addActionListener((ActionEvent e) -> {
			System.out.println(e);
			System.out.println("You just clicked the button");
		});
		exitButton.addActionListener((ActionEvent e) -> {
			System.out.println("Exiting the system");
			System.exit(0);
		});
		createLayout(clickButton, exitButton);
		setLocationRelativeTo(null);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	void createLayout(Component... cmp)
	{
		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setAutoCreateContainerGaps(true);

		gl.setHorizontalGroup(gl.createSequentialGroup()
			.addComponent(cmp[0])
			.addGap(20)
			.addComponent(cmp[1])
		);

		gl.setVerticalGroup(gl.createParallelGroup()
			.addComponent(cmp[0])
			.addComponent(cmp[1])
		);
	}

	public static void main(String[] args)
	{
		EventObject eo = new EventObject();
		eo.setVisible(true);
	}

}