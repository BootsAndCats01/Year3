package FirstTerm.Week5;

public class Multi extends Thread {

    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        Multi thread1 = new Multi();
        Multi thread2 = new Multi();
        thread1.start();
        thread2.start();
    }
}
