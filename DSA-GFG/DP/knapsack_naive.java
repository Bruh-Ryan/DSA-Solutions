// Online Java Compiler (Editor)
// Write and run Java online using this editor.
import java.util.*;
class knapsack_naive{
    public static void main(String[] args) {
        int w = 4;
        int[]val ={1,2,3};
        int []wt ={4,5,1};
        int n = val.length;
        int result = knapsack(w,val,wt,n);
        System.out.println(result);
        
    }
    public static int knapsack(int w, int val[], int wt[], int n){
        if(n==0 || w==0){
            return 0;
        }
        int take=0;
        if(wt[n-1]<=w){
            take = val[n-1] + knapsack(w-wt[n-1],val,wt,n-1);
        }
        int skip = knapsack(w,val,wt,n-1);

        return Math.max(take,skip);
    }
}
