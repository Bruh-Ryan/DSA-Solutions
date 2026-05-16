import java.util.*;
//Find common elements In 3 sorted arrays
public class Common_3_Sorted_Arrays {
    public static void main(String[]arhs){
        int []arr1 = { 1, 5, 10, 20, 30 };
        int []arr2 = { 5, 13, 15, 20 };
        int []arr3 = { 5, 20 };

        int i=0;
        int j=0;
        int k=0;

        int a =0;
        
        int []result = new int [arr1.length];
        // should be variable, for we want largest array to be the base;
       while(i<arr1.length && j<arr2.length && k < arr3.length){
            if (arr1[i]==arr2[j] && arr2[j]==arr3[k]){
                result[a]=arr1[i];
                i++;
                j++;
                k++;
                a++;
                while(i < arr1.length && arr1[i] == arr1[i - 1]){
                    i++;
                }
                while(j < arr2.length && arr2[j] == arr2[j - 1]){
                    j++;
                }
                while(k < arr1.length && arr1[k] == arr1[k - 1]){
                    k++;
                }
                
            }
            else if (arr1[i] < arr2[j])
                i++;
            else if (arr2[j] < arr3[k])
                j++;
            else
                k++;

       }
       System.out.println("numbers"+Arrays.toString(result));
    }
}
