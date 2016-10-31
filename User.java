package xternApp;

import java.io.*;

public class User implements Serializable {
  private static final long serialVersionUID = 4511700594621768327L;
  private int coins;
  private String userID;
  private String password;
  
  public User(String id, String password) {
    this.coins = 0;
    this.userID = id;
    this.password = password;
  }
  
  public int getCoins() {
    return coins;
  }
  
  public void addCoin() {
	  coins++;
  }
  
  public String toString() {
    return "User [ID = " + userID + ", COINS = " + coins + "]";
  }

  public String getID() {
	  return userID;
  }
  
  public String getPass() {
	  return password;
  }
  
  public boolean matches(User person) {
	  if (person == null) {
		  return false;
	  }
	return this.userID.equals(person.getID()) && this.password.equals(person.getPass());
  }
}