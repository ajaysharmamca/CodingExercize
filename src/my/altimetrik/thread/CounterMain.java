package my.altimetrik.thread;

import static java.lang.Thread.sleep;

public class CounterMain {
    static volatile Counter counter = new Counter();
    static void main() throws InterruptedException {

        Thread t1 = Thread.ofPlatform().unstarted(
            () -> {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (int i = 0; i < 500; i++) {
                    counter.increment();
                }
                ;
            });
        Thread t2 = Thread.ofPlatform().unstarted(
                () -> {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    for (int i = 0; i < 500; i++) {
                        counter.decrement();
                    }
                    ;
                });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.value());
    }
}
