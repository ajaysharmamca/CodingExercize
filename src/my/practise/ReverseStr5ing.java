package my.practise;

public class ReverseStr5ing {
    public static void main(String[] args) {
        String word = "Ajay Sharma";
        String reverse = "";
        for (int i = word.length()-1; i > -1; i-- ) {
            reverse += word.charAt(i);
        }
        System.out.println(reverse);
    }
}
