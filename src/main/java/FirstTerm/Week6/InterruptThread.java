package FirstTerm.Week6;


public class InterruptThread implements Runnable {
    private Thread thread;

    public InterruptThread() {
        thread = new Thread(this);
        System.out.println("New Thread: " + thread);
        thread.start();
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println("Thread is running");
        }
        System.out.println("Thread has stopped");
    }

    public static void main(String[] args) {
        InterruptThread interruptThread = new InterruptThread();

        try {
            Thread.sleep(1);
            interruptThread.thread.interrupt();
            Thread.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Caught: " + e);
        }
        System.out.println("Exiting..");

    }


}
