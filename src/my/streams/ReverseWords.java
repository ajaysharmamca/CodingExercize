package my.streams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWords {

 public static void main(String[] args) {
  // TODO Auto-generated method stub
   String input = "My name is Sunil Mishra";
   
   String reverseStr=Arrays.stream(input.split(" ")).map(m -> new StringBuilder(m).reverse()).collect(Collectors.joining(" "));
   
   System.out.println("Reverse words is => "+reverseStr);
 }

} 