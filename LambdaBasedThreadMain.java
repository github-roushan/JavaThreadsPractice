import java.util.concurrent.TimeUnit;

class ThreadPlay {
    static void doSomething(){
        System.out.println("When you are a thinker, you think a lot and code less.");
        try {
            TimeUnit.SECONDS.sleep(10); // Time Spent Thinking
        } catch (Exception e) {
            System.out.println("Some Exception Occurred");
        }
        System.out.println("Time Spent Coding"); // :(
    }
}
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

        // Method Reference
        Thread.ofPlatform().start(ThreadPlay::doSomething);

        System.out.println("Main Code: This is ran from main");
    }
}
