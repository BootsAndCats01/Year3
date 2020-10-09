package FirstTerm.Week4.ValueOfPi;

import java.math.BigDecimal;
import java.rmi.Naming;

public class Client {
    private static Compute lookUp;

    public static void main(String[] args) {
        try {
            lookUp = (Compute) Naming.lookup("//localhost/Server");
            Pi task = new Pi((int) Math.PI);
            BigDecimal pi = lookUp.executeTask(task);
            System.out.println(pi);
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }
}
