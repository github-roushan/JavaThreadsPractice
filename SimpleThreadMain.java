import java.util.concurrent.TimeUnit;

class SimpleThread extends Thread {
    private final int secs;

    SimpleThread(String name, int secs) {
        this.secs = secs;
        this.setName(name);
    }

    @Override
    public void run() {
        System.out.printf("%s: Thread Started\n", this.getName());

        try {
            TimeUnit.SECONDS.sleep(this.secs);
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }

        System.out.printf("%s: Thread Ended\n", this.getName());
    }
}

class SimpleRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Simple Runnable Started");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
        System.out.println("Simple Runnable Ending");
    }
}

public class SimpleThreadMain {
    public static void main(String[] args) {
        for(int i=0; i<5; i++){
            SimpleThread mySimpleThread = new SimpleThread("Thread-" + Integer.toString(i), 1);
            mySimpleThread.start();
        }
        SimpleRunnable myRunnable = new SimpleRunnable();
        Thread runablThread = new Thread(myRunnable);
        runablThread.start();
        
        System.out.println("This is main code");
    }
}