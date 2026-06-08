//javac palindrome.java      
//java palindrome  
public class palindrome {
    public static void main(String[] args) {
        String a ="abbaaa";
        System.out.println("is it palindrome? yes or no? "+palin(a));
        
        }
    public static boolean palin(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}


