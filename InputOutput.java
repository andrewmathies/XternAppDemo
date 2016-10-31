package xternApp;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class InputOutput {
	
	public static void loadUsers() {
	    try (FileInputStream fi = new FileInputStream("coins.bin")){
	    	ObjectInputStream ois = new ObjectInputStream(fi);
	        try {
	          System.out.println("Loaded Users!");
	          ArrayList<User> users = (ArrayList<User>) ois.readObject();
		      Users.addUsers(users); 
	        } catch (EOFException e) {
	          ois.close();
	        }	      
	    } catch (FileNotFoundException e) {
	      e.printStackTrace(); 
	    } catch (IOException e) {
	      e.printStackTrace(); 
	    } catch (ClassNotFoundException e) {
	     e.printStackTrace(); 
	    }
	  }
	
	public static void storeUsers(ArrayList<User> users) {
		System.out.println("Successfully Stored Users!");
		try (FileOutputStream fo = new FileOutputStream("coins.bin");){
			ObjectOutputStream oos = new ObjectOutputStream(fo);
			oos.writeObject(users);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}