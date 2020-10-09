package FirstTerm.Week5.MultithreadEx;

import java.util.Scanner;

public class WorkerThread implements Runnable {
    public WorkerThread() {
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number...");
        int number = scanner.nextInt();
        System.out.println("Square root of " + number + " is " + Math.sqrt(number));
    }

    private void processMessage() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
