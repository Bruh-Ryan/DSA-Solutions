class Find_next_greater_number_with_same_set_of_digits{
    public static void main(String[]args){
        String s = "218765";
        char[] c = new char[s.length()];
        for(int i =0;i<s.length();i++){
             c[i]=s.charAt(i);
        }
        System.out.println(nextGreatest(c,s.length()-1,0));//passing indices;
    }
    public static String nextGreatest(char [] s, int start, int end){
        for(int i=start;i>end;i--){
            if(s.length<=1){
                String str = new String(s);
                return str;
            }
                if(s[i]>s[i-1]){
                System.out.println("pivot point :" + s[i-1]); //3
                System.out.println("finding the next largest number");//should come 4
                char num = s[i];//7
                int index = Integer.MIN_VALUE;
                for(int j = i;j<s.length;j++){
                    if(s[j]<num){
                        num=s[j];
                        index = j;
                    }
                }
                System.out.println("finding the next largest number found " + num);
        
                //swap
                char temp = s[i-1];
                s[i-1]=s[index];
                s[index]=temp;
                //flip
                //4753 -> 4 753 -> 4 357 -> 4357
                int left=i;
                int right = s.length-1;
                while(left<right){
                    char tmp = s[left];
                    s[left]=s[right];
                    s[right]=tmp;
                    left++;
                    right--;
                }

                String str = new String(s);
                return(str);
            }}
        return "CANNOT";
    }
}
