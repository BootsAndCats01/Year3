package FirstTerm.Week5.ThreadEx;

import java.util.Scanner;

public class PartTwo extends Thread {

    public void run() {
        System.out.println("Thread is running...");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name..");
        String name = scanner.nextLine();

        System.out.println("Hello " + name + "!");
    }

    public static void main(String[] args) {
        PartTwo thread = new PartTwo();
        thread.start();
    }
}
