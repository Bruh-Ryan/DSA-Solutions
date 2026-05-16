
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial_Using_Max {
    public static void main(String[]args)throws IOException{
        System.out.println("Enter a number");
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String inputString = r.readLine();
        int number = Integer.parseInt(inputString);
        long result = fact(number);
        System.out.println(result);
        
    }
    public static long fact(int n){
    if(n<1){
        return 1;
    }
    long result = fact(n-1)*n;
    return result;
    }
}


