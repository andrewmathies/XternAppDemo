package xternApp;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel implements ActionListener{
  private JPanel contentPane;
	
  private JLabel labelLoginUsername = new JLabel("Username: ");
  private JLabel labelLoginPassword = new JLabel("Password: ");
  
  private JTextField loginUsername = new JTextField(20);
  private JPasswordField loginPassword = new JPasswordField(20);
 
  private JButton loginButton = new JButton("Login");
  private JButton registerButton = new JButton("Register");
  
  public LoginPanel(JPanel contentPane) {
	  this.contentPane = contentPane;
	  loginButton.addActionListener(this);
	  registerButton.addActionListener(this);
	  InputOutput.loadUsers();
  }
  
  public void placeComponents() {
	  setLayout(null);
	  
	  labelLoginUsername.setBounds(10, 10, 80, 25);
	  labelLoginPassword.setBounds(10, 40, 80, 25);
	  loginUsername.setBounds(100, 10, 160, 25);
	  loginPassword.setBounds(100, 40, 160, 25);
	  loginButton.setBounds(10, 80, 80, 25);
	  registerButton.setBounds(170, 80, 100, 25);
	  
	  add(labelLoginUsername);
	  add(labelLoginPassword);
	  add(loginUsername);
	  add(loginPassword);
	  add(loginButton);
	  add(registerButton);
  }
  
  public void actionPerformed(ActionEvent e) {
	User mockUser = new User(loginUsername.getText(), new String(loginPassword.getPassword()));
	  
	if (e.getSource().equals(loginButton)) {
		boolean isUser = Users.check(mockUser);
		if (!isUser) {
			JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
			return;
		}
		Users.setCurrentUser(Users.getUser(mockUser));
	} else if (e.getSource().equals(registerButton)) {
		//Users.addUser(mockUser);
		Users.setCurrentUser(mockUser);
	}
	
	App.switchSize();
    CardLayout cardLayout = (CardLayout) contentPane.getLayout();
    cardLayout.show(contentPane, "AppPanel");
  }
}