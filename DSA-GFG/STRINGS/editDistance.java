import java.util.*;
class editDistance{
    public static void main(String []rgs){
        String s1 = "geeks";
        String s2 = "gexxkes";
        System.out.println(editDist(s1,s2,s1.length(),s2.length()));
    }
    public static int editDist(String s1, String s2, int m, int n){
        //base case::
        //if s2 is empty string then we have to add all the things there
        //so no. of operations would be s1. lenght
        if(n==0){
            return m; 
        }
        if(m==0){
            return n; 
        }
        //this means if last two charAt() are same then do nothing move on to next
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) 
            return editDist(s1, s2, m - 1, n - 1);
            
        //if not the first then apply all three operations
        //n-1 for  : insert
        //m-1 for  : remove
        //both for : replaxe
        return 1 + Math.min(editDist(s1, s2, m, n - 1), 
                   Math.min(editDist(s1, s2, m - 1, n), 
                            editDist(s1, s2, m - 1, n - 1)));
    }
}
