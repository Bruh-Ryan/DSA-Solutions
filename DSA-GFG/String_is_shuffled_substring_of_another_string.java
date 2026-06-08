import java.util.*;

class String_is_shuffled_substring_of_another_string {
    public static void main(String[] args) {
        // Example execution
        // not optimised for actual caseses - meaning this not actually actually checking of the words are substring and shuffled its just checking the count of each letters;
        // so if a string has 'd' 'l' 'r' 'o' and 'w' then it will too trigger the checkSubstring();
        
        boolean substring = checkSubstring("helloworld","dlrow");
        System.out.println(substring);
        
    }
    
    public static boolean checkSubstring(String o , String t){
        HashMap<Character, Integer> setFreq = createFrequencies(o);
        int i =0;
        while(i<t.length()){
            char currentChar = t.charAt(i);
            
            if(!setFreq.containsKey(currentChar)){
                return false;
            }
            //geting value here
            int newCount = setFreq.get(currentChar) - 1;
            if (newCount < 0) {
                return false;
            }
            setFreq.put(currentChar,newCount);
            i++;
            
        }
        return true;
    }
    public static HashMap<Character, Integer> createFrequencies(String o) {

        HashMap<Character, Integer> set_frequency = new HashMap<>();
        int i = 0;
        
        while (i < o.length()) {
            char currentChar = o.charAt(i);
            
            if (set_frequency.containsKey(currentChar)) {
                int currentCount = set_frequency.get(currentChar);
                set_frequency.put(currentChar, currentCount + 1);
            } else {
                set_frequency.put(currentChar, 1);
            }
            i++; 
        }
        
        return set_frequency;
    }
}
