//Given binary string s . find the maximum number of substrings it can be splitted into 
//such that all substrings have equal number of 0s and 1s.
// If it is not possible to split s satisfying the conditions then return -1.
class Split_a_binary_string_into_substrings  {
    public static void main(String[] args) {
        String s = "01100";
        
        if(s.length() % 2 != 0){
            System.out.println("NOPE");  
            return;
        }
        
        int cnt = 0;
        int cnt0 = 0;
        int cnt1 = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                cnt0++;
            }
            else{
                cnt1++;
            }
            
            if (cnt0 == cnt1) {
                cnt++;
            }
        }

        if (cnt0 != cnt1) {
            System.out.println("NOPE");
            return;
        }
        
        System.out.println(cnt);
    }
}
