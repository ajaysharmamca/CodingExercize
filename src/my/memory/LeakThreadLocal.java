package my.memory;

public class LeakThreadLocal {
    private static final ThreadLocal<byte[]> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws Exception {
        while (true) {
            byte[] data = new byte[1024 * 1024]; // 1 MB
            threadLocal.set(data);

            // ThreadLocal not removed → leak
            Thread.sleep(100);
        }
    }
}