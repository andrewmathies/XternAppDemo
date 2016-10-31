package xternApp;

import java.awt.CardLayout;
import javax.swing.*;

public class App extends JFrame{ 
	
	private static JFrame frame;
	private JPanel contentPane = new JPanel();
	private static AppPanel appPanel = new AppPanel();
	
	public static void main(String[] args)  {
	    SwingUtilities.invokeLater(new Runnable()
	    {
	        public void run()
	        {
	            new App().displayGUI();
	            Users.printUsers();
	        }
	    });
	  }
	
  public void displayGUI() {
    frame = new JFrame("XternCoin");
    
    contentPane.setLayout(new CardLayout());
    
    LoginPanel loginPanel = new LoginPanel(contentPane);
    loginPanel.placeComponents();
    contentPane.add(loginPanel, "LoginPanel");
    contentPane.add(appPanel, "AppPanel");

    frame.add(contentPane);
    frame.pack();
    frame.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            Users.storeUsers();
        }
    });
    frame.setSize(300, 160);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
  }
  
  public static void switchSize() {
	  frame.setSize(500, 500);
	  appPanel.initialize();
  }  
}