public class Trapping_Rain_Water {
    public static void main(String[]ar){
         int arr[]={3,0,1,0,4,0,2};
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
