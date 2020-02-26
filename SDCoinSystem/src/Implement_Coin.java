import java.io.Console;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Implement_Coin extends UnicastRemoteObject implements Interface_Coin {

	private int counter;
	Console console = System.console();
	protected Implement_Coin() throws RemoteException {
		counter = 0;
		
	}

	// adding coins in the stock array

	public int[] addValue(int[] veri) throws RemoteException {

		for (int i = 0; i < coins.length; i++) {

			coins[i] += veri[i];
		
		}
		return coins;
	}

	// calculate the result of coins and returns the result back to
	// Client_Coin_System.java class

	public int[] exchange(Double result) throws RemoteException {
		int[] resultcoins = {0,0,0,0};
		double roundOff = (double) Math.round(result * 100) / 100;
		int amt = (int) (roundOff * 100);
		int[] cents = { 25, 10, 5, 1 };
		int count = 0;

		for (int i = 0; i < coins.length; i++) {
			
			if (coins[i] > 0 ) {
				
				count = amt / cents[i];
				amt = amt % cents[i];
				resultcoins[i] = count;

			}
			else {
				
				System.out.println("You ran out of " + cents[i] + " cents");
			}
			

		}

		return resultcoins;
	}

// updating the stocks
	public int[] exchange2(int[] resultArray) {
		for (int j = 0; j < coins.length; j++) {
			if ((coins[j] > 0)) {
				coins[j] -= resultArray[j];
			}
			
		}
		
		
		return coins;
	}

}
