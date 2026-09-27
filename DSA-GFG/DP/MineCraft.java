import java.util.*;
class MineCraft {
    public static void main(String[] args) {
        System.out.println("Gold Mine Problem \\ assumeing that you will do the for loop to firstly find out the max in coloumn index 0");
        int arr[][]={{1,3,3},{2,1,4},{0,6,4}};
        // int n = arr.length;
        // int m = arr[0].length;
        // System.out.println(n +" ROWs");
        // System.out.println(m +" COLs");
        int n = 1;
        int m = 0;

        int result = goldMineMax(n,m,arr);
        System.out.println(result);
        
    }
    public static int goldMineMax(int n, int m, int[][]arr){
        if (n < 0 || n >= arr.length || m >= arr[0].length) {
            return 0;
        }
        
        //diagonal up n-1,m+1 : diagonal down n+1,m+1 : right n, m+1;
        return arr[n][m]+Math.max(goldMineMax(n-1, m+1, arr), 
                            Math.max(goldMineMax(n+1, m+1, arr), 
                                     goldMineMax(n, m+1, arr)));
    }
}
