class Check_if_is_circular_or_not{
    public static void main(String[] args) {
        
        LinkedList l1 = new LinkedList();
        l1.push(1);
        l1.push(2);
        l1.push(4);
        l1.push(5);
        l1.head.next.next.next.next = l1.head;
        Boolean op = l1.circularCheck(l1.head);
        System.out.println(op);
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
    Node head;
    
    public void push(int data){
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
    public void del_ele(int d){
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
    public void showLinkedList(){
        Node temp=head;
        System.out.print("head");
        while(temp!=null){
            System.out.print("->"+temp.data);
            temp=temp.next;
        }
        System.out.print("->null\n");
    }
    public Boolean circularCheck(Node node){
        Node slow = node;
        Node fast = node;
        while(fast!=null && fast.next!=null){
            fast    = fast.next.next;
            slow    =   slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    
}
