class LinkedList_Q1_Q2 {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        //LinkedList -> 1. insert, 2. delete, 3. print 4. to do reverse
        l.push(10);
        l.push(20);
        l.push(30);
        l.push(40);
        l.push(50);
        l.push(90);
        l.showLinkedList();
        l.reverse();
        l.showLinkedList();
        l.reverse_a_batch(4);
        l.showLinkedList();
    }
}
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class LinkedList{
    static Node head;
    public static void push(int data){
        if(head==null){
            head = new Node(data);
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(data);
       
    }
    public static void del_ele(int d){
        if(head==null){
            return;
        }
        
        Node prev = head;
        Node cur = head.next;
        Node n = null;
        
        while(cur != null){
           if(head.data==d){
               head=head.next;
               return;
           }
           
           n=cur.next;
           if(cur.data == d){
            //   System.out.println("found "+ cur.data); //debug
                if(cur.next==null){
                    // System.out.println("found that cur.next != 10");//debug
                    // System.out.println("prev"+prev.data);//debug
                    prev.next=null;
                    cur=prev.next;
                }
                prev.next=n;
                cur=prev;
                
           }
            // System.out.println("traversed node :"+cur.data);//debug
            cur=cur.next;
            prev=prev.next;
            if(cur.next==null && cur.data != d){
                System.out.println("NOT FOUND");
                return;
            }
        }
        
    }
    public static void reverse_a_batch(int k){
        head =  reverse_a_batch_helper( head, k );
    }
    public static Node reverse_a_batch_helper(Node startNode, int k){
        Node prev = null;
        Node temp = null;
        Node curr = startNode;
        int n =1;
        
        while(curr!=null && n<=k){
            temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            n++;
        }
        if(curr!=null){
            startNode.next=reverse_a_batch_helper(curr,k);
        }
        return prev;
        
    }
    public static void reverse(){
        Node prev = null;
        Node temp = null;
        Node cur = head;
        
        if(head.next==null){
                // System.out.print("cur.next mean that my head is verymuch null");//debug
                showLinkedList();
                return;
            }
        
        while(cur!=null){
            temp=cur.next; //give the cur's next reff point to temp, save future
            cur.next=prev; // give the prev as reff to the cur's next, flip arrow.
            prev=cur; // update prev with current cur
            cur=temp; // give the cur.next, that was stored temp, and give to cur.

        }
        head=prev;
    }
    public static void showLinkedList(){
        Node temp=head;
        System.out.print("head");
        while(temp!=null){
            System.out.print("->"+temp.data);
            temp=temp.next;
        }
        System.out.print("->null\n");
        
    }
}
