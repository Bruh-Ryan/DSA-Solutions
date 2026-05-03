import java.util.*;

//Rearrange the array in alternating positive and negative items with O(1) extra space
class Rearrange_Array_by_Sign {
    public static void main(String[] args) {
       int nums[] ={-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};

        if (nums.length == 0) {
            System.out.println("NO NUMBERS");
            return;   
        }

       System.out.println("Input: "+ Arrays.toString(nums));
       int i=0,j=0; //indexes for pos and neg
       int pcount =0;
       
       for(int a=0;a<nums.length;a++){
           if(nums[a]>=0){
               
               pcount++;
           }
       }
       int []pos=new int [pcount];
       int[]neg=new int[nums.length-pcount];
       //putting values in pos and neg
       for(int a=0;a<nums.length;a++){
           if(nums[a]>=0){
               pos[i]=nums[a];
               i++;
           }
           else{
               neg[j]=nums[a];
               j++;
           }
           
       }
       i=0;
       j=0;
       int k=0;//index
       while(i<pos.length && j<neg.length){
           if(k%2==0){
               nums[k]=pos[i];
               i++;
           }
           else{
               nums[k]=neg[j];
               j++;
           }
           k++;
           
       }
       while(i<pos.length){
           nums[k]=pos[i];
               i++;k++;
       }
       while(j<neg.length){
           nums[k]=neg[j];
               j++;k++;
       }
       
       System.out.print("Output");
       System.out.println(Arrays.toString(nums));
       
    }
}