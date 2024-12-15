import java.util.concurrent.TimeUnit;

class FluentRunnable implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("Exception Occurred");
        }
    }
}

public class FluentThreadMain {
    public static void main(String[] args) {
        Runnable r = new FluentRunnable();
        Thread.ofPlatform().name("Fluent Thread").start(r);
        System.out.println("Main Code: Code Ran Successfully");
    }
}
