package FirstTerm.Week5.ThreadEx;

import java.util.Scanner;

public class PartOne implements Runnable {

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Thread is running...");

        System.out.println("Please enter your name..");
        String name = scanner.nextLine();

        System.out.println("Hello " + name + "!");
    }

    public static void main(String[] args) {
        PartOne obj = new PartOne();
        Thread thread = new Thread(obj);
        thread.start();
    }

}
