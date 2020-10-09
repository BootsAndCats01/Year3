package FirstTerm.Week4;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientOperation {

    private static RMIInterface lookUp;

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        lookUp = (RMIInterface) Naming.lookup("//localhost/HelloServer");
        String message = JOptionPane.showInputDialog("What is your name?");

        String response = lookUp.helloTo(message);

        JOptionPane.showMessageDialog(null, response);
    }
}
