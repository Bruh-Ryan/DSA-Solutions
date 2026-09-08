import java.util.*;
public class jobWeightOpti {
	public static void main(String[] args) {
		int jobs[][]={{1,2,50},{3,5,20},{6,19,100},{2,100,200}};
		//sorted jobs based on start time:
		Arrays.sort(jobs, Comparator.comparingInt(a->a[0]));
		int index = 0;
		int [] memo = new int [jobs.length];
		Arrays.fill(memo, -1);
		int profit=MaxProfit(index,jobs,memo);
		System.out.println("The Profit came to be:"+profit);
	}
	public static int MaxProfit(int i, int[][]jobs, int memo[]){
	    if(i>=jobs.length){
	        return 0;
	    }
	    if (memo[i]!=-1){
	        return memo[i];
	        }
	    int skip = MaxProfit(i+1, jobs, memo);
	    int next = i+1;
	    while(next<jobs.length && jobs[next][0]<jobs[i][1]){
	        next++;
	        }
	    int take = jobs[i][2]+MaxProfit(next,jobs,memo);
	    memo[i]=Math.max(take,skip);
	    return Math.max(take,skip);
	    }
}