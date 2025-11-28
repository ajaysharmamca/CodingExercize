package my.object;

public class Test {
    static {
        System.out.println("Static Block-1");
    }

    public static void main(String[] args) {
        System.out.println("my.test.Main Method");
    }

    static {
        System.out.println("Static Block-2");
    }

}