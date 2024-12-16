import java.util.concurrent.TimeUnit;

public class LambdaBasedThreadMain {
    public static void main(String[] args) {
        Thread.ofPlatform().start(() -> {
            System.out.println("Thread: This was ran from a thread");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                System.out.println("Interrupted");
            }
            System.out.println("Thread: Ending thread");
        });
        System.out.println("Main Code: This is ran from main");
    }
}
