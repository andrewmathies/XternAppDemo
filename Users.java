package xternApp;

import java.util.ArrayList;

public class Users {
	  private static ArrayList<User> users = new ArrayList<User>();
	  private static User currentUser;
	  private static int indexOfCurrentUser;
	  
	  public static void addUser(User person) {
		    users.add(person);
	  }
	  
	  public static void addUsers(ArrayList<User> usersTemp) {
		  for (User u : usersTemp) {
			  users.add(u);
		  }
	  }
	  
	  public static void printUsers() {
		  for (User u : users) {
			  System.out.println(u);
		  }
	  }
	  
	  // this has to remove the old version of currentUser so the current coins value of currentUser are written to the file
	  public static void storeUsers() {
		  if (!check(currentUser)) {
			  users.add(currentUser);
		  }
		  InputOutput.storeUsers(users);
	  }
	  
	  public static boolean check(User person) {
		  for (User u : users) {
			  // can't just use .equals because we are creating an anonymous fake version of the
			  // user to check, and they will not have the same coins value
			  if (u.matches(person))
				  return true;
		  }
		  return false;
	  }
	  
	  public static User getUser(User fakeUser) throws NullPointerException{
		  for (int i = 0; i < users.size(); i++) {
			  if (fakeUser.matches(users.get(i))) {
				  return users.get(i);
			  }
		  }
		  throw new NullPointerException();
	  }
	  
	  public static void setCurrentUser(User person) {
		  currentUser = person;
		  if (users.contains(person)) {
			  users.remove(person);
		  }
	  }
	  
	  public static User getCurrentUser() {
		  return currentUser;
	  }
}
