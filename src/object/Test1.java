package object;

public class Test1 {
    public static void main(String args[]) {  
        System.out.print("a");  
      try {  
        System.out.print("b");
        return;
//        throw new IllegalArgumentException();
      }
       catch (RuntimeException e) {  
         System.out.print("c");  
      }   
       finally  {  
        System.out.print("d");  
       }  
       System.out.print("e");  
    } 
}