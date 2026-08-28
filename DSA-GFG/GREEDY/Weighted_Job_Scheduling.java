
import java.util.*;

class Weighted_Job_Scheduling {
    public static void main(String[] args) {
        int[][] jbs = {{1, 2, 50}, {3, 5, 20}, {6, 19, 100}, {2, 100, 200}};
        Arrays.sort(jbs, Comparator.comparingInt(a -> a[0]));
        int result = max_profit(0,jbs);
        System.out.println(result);
        
    }
    public static int max_profit(int i, int jbs[][]){  
        if(i>=jbs.length)return 0;
        int skip = max_profit(i+1,jbs);

        int next = i+1;
        while(next<jbs.length && jbs[next][0]<jbs[i][1]){
            next++; //this while loop is for checking overlap
        }
        int take = jbs[i][2]+max_profit(next,jbs);
        return Math.max(skip,take);
    }
}
