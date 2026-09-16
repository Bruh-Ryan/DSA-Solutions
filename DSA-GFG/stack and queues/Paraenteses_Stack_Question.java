
class Paraenteses_Stack_Question {
    public static void main(String[] args) {

        System.out.println( checkBalanced("{}[{}{{}]}") ? "true" : "false");
       
    }
    public static boolean checkBalanced(String in){
        if(in.length()%2!=0){
            return false;
        }
        Stack stk = new Stack(in.length());
        
        for(char i : in.toCharArray()){
            if(i=='{' || i=='['|| i=='('){
                stk.push(i);
            }
            else if(i=='}' || i==']'|| i==')'){
                stk.pop();
            }
        }
        if(stk.top!=-1){
            return false;
        }
        
        return true;
    }
}
class Stack{

    int top;
    int capacity;
    int size;
    char data;
    char [] stk;

    Stack(int size){
        this.size = size;
        this.capacity = 0;
        stk = new char[size];
        this.top=-1;
    }
    public void push(char data){
        if(top==-1){
            top++;
            capacity++;
            stk[top]=data;
            return;
        }
        if(top>=size){
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        stk[top]=data;
        capacity++;
    }
    public void pop (){
        if(top==-1){
            System.out.println("Null Case");
            return;
        }
        char re = stk[top];
        showPopOrTop();
        top--;
        
    }
    public char showPopOrTop(){
        return stk[top];
    }
    public void showStack(){
        if(top!=-1){
            for(char i:stk){
                System.out.println(i);
            }
        }
    }
}
