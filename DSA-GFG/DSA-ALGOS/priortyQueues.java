class Node {
    int value;
    int priority;

    Node(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}
public class priortyQueues {
    
    Node []arr;
    int size;
    int capacity;

    public priortyQueues(int capacity) {
        this.capacity = capacity;
        arr = new Node[capacity];
        size = 0;
    }

    public void push(int v, int p){

        if(size==capacity){
            System.out.println("MAX Reached");
            return;
        }
        arr[size]=new Node(v,p);
        size++;
        heapifyUp(size-1);
    }
    public void heapifyUp(int s){
        //say 's' is child 'c' and 'parent' is 'i' or node at which we are finding : c = (i*2)+1 or (i*2)+2
        //from that we derive this formula by rearranging them.
        int parent = (s-1)/2;
        while(s>0 &&  arr[s].priority < arr[parent].priority){
            //swap condition:
            Node temp = arr[s];
            arr[s] = arr[parent];
            arr[parent] = temp;

            s=parent;
            parent=(s-1)/2;
        }  
    }
    public void display(){
        for (int i = 0; i < size; i++)
            System.out.print("|v:" + arr[i].value + " p:" + arr[i].priority + "|");
        System.out.println();
    }

    public static void main(String []args){
        priortyQueues pq = new priortyQueues(5);
        pq.push(1,3);
        pq.push(3,1);
        pq.push(2,2);
        pq.push(4,4);
        pq.push(55,0);
        pq.display();
        
    }
}

