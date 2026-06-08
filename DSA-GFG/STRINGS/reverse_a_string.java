//javac reverse_a_string.java
//java reverse_a_string.java
class reverse_a_string {
    public static void main(String[] args) {
        String a ="ryan";
        System.out.println("original: "+a);
        
        int length = a.length();
        int i=0;
        String b ="";
        while(i<=length-1){
            b += a.charAt(length -1- i);
            i++;
        }
        System.out.println("reverse: "+b);
    }
}