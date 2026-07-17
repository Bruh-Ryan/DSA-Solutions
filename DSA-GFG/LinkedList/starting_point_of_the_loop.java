class  starting_point_of_the_loop {
    public static void main(String[] args) {
        
        LinkedList l2 = new LinkedList();
        l2.push(10);
        l2.push(20);
        l2.push(30);
        l2.push(40);
        l2.push(50);
        l2.head.next.next.next.next.next = l2.head.next.next;
        l2.showLinkedList();
        LinkedList.removeLoop(l2);
        l2.showLinkedList();
        l2.startPoint();
        
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
    static Node startingPointLoop = null;
    public static boolean Using_Floyds_Cycle_Finding_Algorithm(){
        Node slow = head;
        Node fast = head;
        while(slow!=null && fast != null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    
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
        boolean isLoop = Using_Floyds_Cycle_Finding_Algorithm();
        if(isLoop==false){
            System.out.print("head");
            while(temp!=null){
                System.out.print("->"+temp.data);
                temp=temp.next;
            }
            System.out.print("->null\n");
        }
        else{
            System.out.println("Loop detected");
        }
        
    }
    public static void removeLoop(LinkedList list){
        Node slow=head;
        Node fast=head;
        
        while(slow != null && fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast){
                //System.out.println("THEY MET AT:"+slow.data +" s & f "+fast.data);//debug
                removeLoopHelper(slow);//you could use fast too if you wanted
                
                return;
            }
            
        }
    }
    public static void removeLoopHelper(Node n){
        Node slow=head;
        Node fast=n;
        Node startpoint=null;
        while(slow != null && fast != null){
            slow=slow.next;
            fast=fast.next;
            if(slow.next==fast.next){
                fast.next=null;
                startPointHelper(slow.next);
                return;
            }
        }
     }
     public static int  startPoint(){
         if(startingPointLoop!=null){
            System.out.println(startingPointLoop.data); 
            return startingPointLoop.data;
         }
         return -1;
     }
     public static void  startPointHelper(Node startPoint){
         startingPointLoop=startPoint;
     }
}
