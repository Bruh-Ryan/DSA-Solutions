//not that this is a simpler approach, this problem is same like job schedule but added with platforms, so if you do this per platform then you can achive the result of 5 
// so just add in a while or for loop seggrigating each platforms AT and DT and train.
import java.util.*;
class Max_Trains_Stoppage_Provided {
    public static void main(String[] args) {
      int trains[][] = {
            {1, 1000, 1030}, // Train 1
            {2, 1010, 1030}, // Train 2
            {6, 9000, 1005}  // Train 6 (09:00 is just 900)
        };
        
        // Sort by Departure Time (index 2)
        Arrays.sort(trains, Comparator.comparingInt(a -> a[2]));
        System.out.println(checkTrains(trains,0));
        // Train 6 departs at: 1005    arrival: 9000
        // Train 1 departs at: 1030    arrival: 1000
        // Train 2 departs at: 1030    arrival: 1010
    }
    public static int checkTrains(int[][]t,int i){
        if(i>=t.length){
            return 0;
        }
        int skip = checkTrains(t,++i);
        int next = i;
        while(next>t.length && t[next][2]<t[i][1]){
            next++;
        }
        int take = 1+checkTrains(t,i);
        return Math.max(take,skip);
    }
}
