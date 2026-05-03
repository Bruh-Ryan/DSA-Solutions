import java.util.Scanner;

public class Trapping_Rain_Water {
    public static void main(String[]ar){
         int arr[]={3,0,1,0,4,0,2};
        System.out.println("Choose method 1. brute force 2.more optimised");
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        switch(a){
            case 1:
                brute_force(arr);
                break;
            case 2:
                opti(arr);
                break;
        }
    }
    public static void opti(int arr[]){
        int res=0;
        int left =0, right =arr.length-1;
        int lMax = arr[0], rMax= arr[arr.length-1];

        while (left<right){
            if(lMax<=rMax){
                left++;
                lMax= Math.max(lMax,arr[left]);
                res+=lMax-arr[left];
            }
            else{
                right--;
                rMax = Math.max(rMax,arr[right]);
                res+=rMax-arr[right];
            }
            
        }
        System.out.println(res);
    }
    public static void brute_force(int[]arr){
        int res =0;
       
       for(int i=1;i<arr.length-1;i++){
          int left = arr[i];
          
          for(int j=0;j<i;j++){
              // Finding max
             left = (left>arr[j])?left:arr[j];
          }
          
          int right = arr[i];
          
          for(int j=i+1;j<arr.length;j++){
              right = (right>arr[j])?right:arr[j];
          }
          
          if(right<left){
              res += right-arr[i];
          }
          else if(left<right){
              res+=left-arr[i];
          }
        }
        System.out.println(res);
    }
}
