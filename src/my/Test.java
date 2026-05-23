package my;

public class Test {


//    IGiven two strings, write a method to decide if one is a permutation of the
//other.
static void main(String[] args) {
    String str1 = "Mr John Smith      ";
    String trim = str1.trim();
    trim = trim.replaceAll("\\s+", "%20");

    System.out.println(trim);
}

    private static boolean isPermutation(String str1, String str2) {
        char[] chars = new char[256];
        if (str1.isEmpty() || str2.isEmpty()) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        for(int i = 0; i < str1.length(); i++) {
            chars[str1.charAt(i)]++;
            chars[str2.charAt(i)]--;
        }
        for (char c: chars) {
           if (c != 0 ) {
               return false;
           }
        }
        return true;
    }


}






