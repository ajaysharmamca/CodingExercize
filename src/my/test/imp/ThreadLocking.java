package my.test.imp;

public class ThreadLocking {
    record Person(String name, int age) {}
    static void main() {
        //Make dead lock
        String str1 = new String("A");
        String str2 = new String("B");

        Thread th1 = Thread.ofPlatform().start(
                ()-> {
                    synchronized (str1) {
                        System.out.println("Thread-1 locked str1");
                        try { Thread.sleep(100); } catch (Exception ignored) {}
                        System.out.println("Thread-1 waiting for str2...");
                        synchronized (str2) {
                            System.out.println("Thread-1 locked str2");
                        }
                    }
                }
        );

        Thread th2 = Thread.ofPlatform().start(
                ()-> {
                    synchronized (str2) {
                        System.out.println("Thread-2 locked str2");
                        try { Thread.sleep(100); } catch (Exception ignored) {}
                        System.out.println("Thread-2 waiting for str1...");
                        synchronized (str1) {
                            System.out.println("Thread-2 locked str1");
                        }
                    }
                }
        );

        // join to show deadlock
        try {
            th1.join();
            th2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
