import java.util.concurrent.TimeUnit;

class ThreadPlay {
    static void doSomething(){
        System.out.println("When you are a thinker, you think a lot and code less.");
        try {
            TimeUnit.SECONDS.sleep(10); // Time Spent Thinking
        } catch (Exception e) {
            System.out.println("Some Exception Occurred");
        }
        System.out.println(Thread.currentThread().getName() + ": Time Spent Coding was so less"); // :(
    }
}
public class LambdaBasedThreadMain {
    public static void main(String[] args) {
        Thread.ofPlatform().start(() -> {
            System.out.println("Lambda Thread: This was ran from a thread");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                System.out.println("Interrupted");
            }
            System.out.println("Lambda Thread: Ending thread");
        });

        // Method Reference
        Thread.ofPlatform().name("Method Reference").start(ThreadPlay::doSomething);
        System.out.println("Main Code: This is ran from main");
    }
}
