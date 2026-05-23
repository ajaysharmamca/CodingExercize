package my.memory;

import java.util.ArrayList;
import java.util.List;

public class LeakCollection {
    private static final List<byte[]> leakyList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        while (true) {
            byte[] data = new byte[1024 * 100]; // 100KB objects
            leakyList.add(data);

            Thread.sleep(10);
        }
    }
}
