package object;

public class Test2 {
    public static void main(String args[]) {  
        String first = new String("Hello");
        String second = new String("Hello");
        String third = "Hello";
        String fourth = "Hello";

        System.out.println(third == fourth);
        System.out.println(third == first);
        System.out.println(first == second);
        System.out.println(second == fourth);
        System.out.println(second == third);
  }
}