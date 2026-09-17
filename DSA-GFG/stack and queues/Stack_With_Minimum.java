import java.util.*;

class Stack_With_Minimum {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>(5, (a, b) -> Integer.compare(a, b));
        
        st.push(5);
        System.out.println("Current Min: " + st.getMin()); 
        st.push(3);
        System.out.println("Current Min: " + st.getMin()); 
        st.push(2);
        System.out.println("Current Min: " + st.getMin()); 
        
        System.out.println("\n--- Testing Popping ---");
        st.pop(); 
        st.pop();
        st.pop();
        st.pop();
        System.out.println("Current Min after 1 pop: " + st.getMin());
}
}

class Stack<T>{
    int top;
    int capacity;
    int size;
    T[] stk;
    T[] minStk; 
    
    private Comparator<T> comparator;
    
    @SuppressWarnings("unchecked")
    Stack(int size, Comparator<T> comparator){
        this.size = size;
        this.capacity = 0;
        this.stk = (T[]) new Object[size];
        this.minStk = (T[]) new Object[size];
        this.top = -1;
        this.comparator = comparator;
    }
    
    public void push(T data){
        if(top >= size - 1){
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        stk[top] = data;
        capacity++;
        
       
        if (top == 0) {
            minStk[top] = data; 
        } else {
            T currentMin = minStk[top - 1];
            
            if (comparator.compare(data, currentMin) < 0) {
                minStk[top] = data;
            } else {
                minStk[top] = currentMin; 
            }
        }
    }
    
    public T pop (){
        if(top == -1){
            System.out.println("Null Case");
            return null;
        }
        capacity--;
        T re = stk[top];
        
        top--; 
        return re;
    }
    
    public T getMin(){
        if(top != -1){
            return minStk[top]; 
        }
        return null;
    }
    
    public T showPopOrTop(){
        if (top == -1) return null;
        return stk[top];
    }
}
