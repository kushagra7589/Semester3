import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class cardLayout extends JFrame
{
	JPanel cards;
	cardLayout()
	{
		initUI();
	}

	void initUI()
	{
		setTitle("Checking cardLayout");

		JPanel card1 = new JPanel();
		JPanel card2 = new JPanel();
		cards = new JPanel(new CardLayout());
		JButton page1 = new JButton("Next");
		JButton page2 = new JButton("Prev");
		card1.add(page1, BorderLayout.CENTER);
		card2.add(page2, BorderLayout.SOUTH);

		page1.addActionListener(new ChangeCard("prev"));
		page2.addActionListener(new ChangeCard("next"));
		cards.add(card1, "next");
		cards.add(card2, "prev");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		Container pane = getContentPane();
		pane.add(cards, BorderLayout.CENTER);
	}

	class ChangeCard implements ActionListener
	{
		String panelstring;
		ChangeCard(String s)
		{
			this.panelstring = s;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			CardLayout cl = (CardLayout)cards.getLayout();
			cl.show(cards, this.panelstring);
		}
	}

	public static void main(String[] args) {
		cardLayout c = new cardLayout();
		c.setVisible(true);
	}
}