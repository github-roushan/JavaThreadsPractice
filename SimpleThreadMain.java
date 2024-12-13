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

public class SimpleThreadMain {
    public static void main(String[] args) {
        for(int i=0; i<5; i++){
            SimpleThread mySimpleThread = new SimpleThread("Thread-" + Integer.toString(i), 1);
            mySimpleThread.start();
        }
        
        System.out.println("This is main code");
    }
}