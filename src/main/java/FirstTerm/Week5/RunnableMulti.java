package FirstTerm.Week5;

public class RunnableMulti implements Runnable {

    @Override
    public void run() {
        // Put what you want the thread to do in here
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        RunnableMulti runnableMulti = new RunnableMulti();
        Thread thread1 = new Thread(runnableMulti);
        Thread thread2 = new Thread(runnableMulti);
        thread1.start();
        thread2.start();
    }

}
