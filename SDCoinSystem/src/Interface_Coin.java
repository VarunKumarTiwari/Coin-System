import java.rmi.*;

interface Interface_Coin extends Remote {
	public int[] coins = new int[4];
	public int[] resultcoins = new int[4];

	public int[] addValue(int[] veri) throws RemoteException;

	public int[] exchange(Double result) throws RemoteException;

	public int[] exchange2(int[] coi) throws RemoteException;

}
