import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Server_Coin {

	public static void main(String args[]) throws Exception {

		String unpass = "varun12345";
		LocateRegistry.createRegistry(1099);
		System.out.println("Server is up and running");
		Implement_Coin n1 = new Implement_Coin();
		Naming.rebind(unpass, n1);
		

	}
}
