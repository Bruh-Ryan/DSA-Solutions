import java.util.*;
public class rotate_an_img_90deg {
    public static void main(String []ars){
        int [][]a = {{1, 2, 3},
                     {4, 5, 6},
                     {7, 8, 9}};
        int n = a.length;
        int res[][]=new int[n][n];

        // for(int row=0;row<n;row++){
        //     for(int col=0;col<n;col++){
        //         System.out.print(a[row][col]);
        //     }
        //     System.out.println("");
        // }
        int col = a[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res[j][n-1-i]=a[i][j];
                System.out.println("res: "+ Arrays.deepToString(res));
                System.out.println("array: "+Arrays.deepToString(a));
               }
               System.out.println();
            }

        System.out.println(Arrays.deepToString(res));
       
        
    }

}
