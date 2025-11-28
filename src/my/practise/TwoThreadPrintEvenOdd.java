package my.practise;

public class TwoThreadPrintEvenOdd {

    private static volatile int i = 1;
    public static final Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        int printNumbers = 1200;


        Runnable runnable1 = () -> {
            synchronized (lock) {
                while (i <= printNumbers) {
                    if (i % 2 != 0) {
                        System.out.println("Thread 1 : " + i);
                        i = i + 1;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            }
        };

        Runnable runnable2 = () ->  {
            synchronized (lock) {
                while (i <= printNumbers) {
                    if (i % 2 == 0) {
                        System.out.println("Thread 2 : " + i);
                        i = i + 1;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
         thread2.join();


    }
}
