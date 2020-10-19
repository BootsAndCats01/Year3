package FirstTerm.Week6;

public class BooleanThread implements Runnable {
    private boolean exit;

    private String name;
    private Thread thread;

    public BooleanThread(String name) {
        this.name = name;
        thread = new Thread(this, name);
        System.out.println("New Thread: " + thread);
        exit = false;
        thread.start();
    }

    @Override
    public void run() {
        int i = 0;

        while (!exit) {
            System.out.println(name + ": " + i);
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Caught: " + e);
            }
        }
        System.out.println(name + " Stopped");
    }

    public void stop() {
        exit = true;
    }

    public static void main(String[] args) {
        BooleanThread thread1 = new BooleanThread("First Thread");
        BooleanThread thread2 = new BooleanThread("Second Thread");

        try {
            Thread.sleep(500);
            thread1.stop();
            thread2.stop();
        } catch (InterruptedException e) {
            System.out.println("Caught: " + e);
        }
        System.out.println("Exiting..");

    }
}
