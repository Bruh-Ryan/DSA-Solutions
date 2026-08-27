import java.util.*;

class Activity_Selection{
    public static void main(String[] args) {
        int st[]={10, 12, 20};
        int en[]={20, 25, 30};
        int n = st.length;
        int activity[][] = new int [n][2];

        for(int i=0;i<n;i++){
            activity[i][0]=st[i];
            activity[i][1]=en[i];
        }
        int count = 1;
        int prev_activity = activity[0][1];
        for(int i =0;i<n;i++){
            if(activity[i][0]>prev_activity){
                count++;
                prev_activity=activity[i][1];
            }
        }
        System.out.println(count);
    }
}
