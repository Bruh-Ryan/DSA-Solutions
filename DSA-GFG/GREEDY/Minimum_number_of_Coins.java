
import java.util.*;

class Minimum_number_of_Coins {
    public static void main(String[] args) {
        int set[]={1,2,5,10};
        int result = addition(121,set,set.length-1);
        System.out.println("RESULT"+result);
    }
    public static int addition(int target, int set[], int index){
        
        if(target==0) return 0;
        if(index<0||target<0) return Integer.MAX_VALUE/2;
        if(target>= set[index]){
            return 1+addition(target-set[index],set,index);
        }

        else{
            return addition(target,set,index-1);
        }
    }
}
