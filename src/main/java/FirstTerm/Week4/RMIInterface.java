package FirstTerm.Week4;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {

    String helloTo(String name) throws RemoteException;
}
