package my.date;

public class Swap {
    public static void main(String[] args) {
        int number1 = 1;
        int number2 = 2;
        number1 = number1 + number2;
        System.out.println(number1);
        number2 = number1 - number2;
        System.out.println(number2);
        number1 = number1 - number2;
        System.out.println(number1);
//        number1 = number1 ^ number2;
//        number2 = number1 ^ number2;
//        number1 = number1 ^ number2;
        System.out.println(number1);
        System.out.println(number2);

    }
}
