class Detect_and_Remove_Duplicates {
    public static void main(String[] args) {
        
        LinkedList l2 = new LinkedList();
        l2.push(10);
        l2.push(10);
        l2.push(10);
        l2.push(10);
        l2.push(10);
        // Node j = new Node(10);
        // j.next = new Node(20);
        l2.showLinkedList();
        // System.out.println(j.data);
        
        // System.out.println(j.next.data);
        l2.removeDuplicates();
        l2.showLinkedList();
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
    public static void showLinkedList(){
        Node temp=head;
        System.out.print("head");
        while(temp!=null){
            System.out.print("->"+temp.data);
            temp=temp.next;
        }
        System.out.print("->null\n");
    }
    public static void removeDuplicates(){
        if(head==null){
            return;
        }
        Node cur = head;
        
        while(cur.next!=null ){
            
            if(cur.data == cur.next.data){
                cur.next = cur.next.next;
            }
            else{
                cur = cur.next;
            }
        }
        
    }
    
}
