package xternApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AppPanel extends JPanel implements ActionListener{	
	private JLabel currentCoinsLabel;
	private JLabel titleLabel;
	private JLabel guessLabel = new JLabel("Type in a random integer between 1 and 100 here!");
	private JLabel explanationLabel = new JLabel("If you guess the right number, you will get one XternCoin!");
	private JLabel correctLabel = new JLabel("Correct!");
	private JLabel incorrectLabel = new JLabel("Incorrect!");
	
	private JButton guessButton = new JButton("Guess");
	private JButton startGuessingButton = new JButton("Pretend User Starts Guessing");	
	private JTextField guessingText = new JTextField(5);
	
	private User currentU;
	private Random rand = new Random();
	private int guessNumber = rand.nextInt(99) + 1;
	
	public void initialize() {
		setLayout(null);		
		guessButton.addActionListener(this);
		startGuessingButton.addActionListener(this);
		
		System.out.println(guessNumber);
		
		currentU = Users.getCurrentUser();
		titleLabel = new JLabel("Hello " + currentU.getID() + "!");
		currentCoinsLabel = new JLabel("Current Amount of XternCoins: " + currentU.getCoins());
		
		titleLabel.setBounds(200, 30, 100, 20);
		currentCoinsLabel.setBounds(150, 100, 200, 20);
		guessLabel.setBounds(100, 150, 300, 20);
		explanationLabel.setBounds(85, 190, 330, 20);
		guessingText.setBounds(170, 230, 100, 20);
		guessButton.setBounds(280, 230, 75, 20);
		startGuessingButton.setBounds(140, 300, 220, 40);
		
		add(titleLabel);
		add(currentCoinsLabel);
		add(guessLabel);
		add(explanationLabel);
		add(guessingText);
		add(guessButton);
		add(startGuessingButton);
		revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(guessButton)) {
			int guess = Integer.parseInt(guessingText.getText());
			if (guess == guessNumber) {
				JOptionPane.showMessageDialog(null, correctLabel);
				currentU.addCoin();
				currentCoinsLabel.setText("Current Amount of XternCoins: " + currentU.getCoins());
				this.revalidate();
				guessNumber = rand.nextInt(99) + 1;
				System.out.println(guessNumber);
			} else {
				JOptionPane.showMessageDialog(null, incorrectLabel);
			}
			guessingText.setText("");
		} else {
			startGuessing();
		}
	}
	
	public void startGuessing() {
		int myGuess;
		while (true) {
			myGuess = rand.nextInt(99) + 1;
			guessingText.setText(new Integer(myGuess).toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			guessButton.doClick(10);
		}
	}
}