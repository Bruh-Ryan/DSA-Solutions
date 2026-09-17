
class Reverse_A_Word_or_String {
    public static void main(String[] args) {
       String str ="I love Java Code";
        String temp = "";
         Stack<String> k = new Stack<String>(5);
        
        for(int i =0; i<str.length();i++){
           if(str.charAt(i)==' '){

               k.push(temp);
               temp="";
       
           }
            else{
                temp+=str.charAt(i); 
            }
        }
         if (!temp.isEmpty()) {
            k.push(temp);
        }
        temp="";
        while(k.top!=-1){
            temp+=k.pop();
            temp+=" ";
        }
        
        System.out.println(temp);
       
    }
}
class Stack<T>{

    int top;
    int capacity;
    int size;
    T data;
    T stk [];
    @SuppressWarnings("unchecked")
    Stack(int size){
        this.size = size;
        this.capacity = 0;
        this.stk = (T[]) new Object[size];
        this.top=-1;
    }
    
    public void push(T data){
        if(top==-1){
            top++;
            capacity++;
            stk[top]=data;
            return;
        }
        if(top>=size-1){
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        stk[top]=data;
        capacity++;
    }
    public T pop (){
        if(top==-1){
            System.out.println("Null Case");
            return null;
        }
        capacity--;
        T re = stk[top];
        top--;
        return re;
        
    }
    public T showPopOrTop(){
        return stk[top];
    }
    public void showStack(){
        if(top!=-1){
            int i=0;
            while(stk[i] != null){
                System.out.println(stk[i]);
                i++;
            }
        }
    }
}
