package my.leet.pattern.sliding;

public class JavaInternMethod {
    public static void main(String[] args) {
        String a = "Java";
        String b = new String("Java").intern();
        System.out.println(a == b); // true

    }
}
