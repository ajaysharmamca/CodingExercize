package my.algos;

import java.util.Arrays;

public class InsetionSort
{
    public static void main(String[] args) {
        int[] array = {20, 5, 40, 60, 10, 30};
        
        doInsertionSort(array);
        
        System.out.println(Arrays.toString(array));
    }
    
    private static void doInsertionSort(int[] array) {
        
        
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while ( j >= 0 && array[j] > key) {
                array[j + 1] = array [j];
                j--;
            }
            array[j+1] = key;
            
        }
        
    } 
}