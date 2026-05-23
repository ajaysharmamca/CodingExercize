package my.altimetrik.thread;

public class Deadlock {
    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                + "  has bowed to me!%n", 
                this.name, bower.getName());
            bower.bowBack(this);
        }
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                + " has bowed back to me!%n",
                this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend ram =
            new Friend("Ram");
        final Friend shyam =
            new Friend("Shyam");
        new Thread(new Runnable() {
            public void run() { ram.bow(shyam); }
        }).start();
        new Thread(new Runnable() {
            public void run() { shyam.bow(ram); }
        }).start();
    }
}