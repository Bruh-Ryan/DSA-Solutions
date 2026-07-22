class Intersection_point_of_two_nodes{
    public static void main(String[] args) {
        
        LinkedList l1 = new LinkedList();
        l1.push(1);
        l1.push(2);
        l1.push(4);
        
        LinkedList l2 = new LinkedList();
        l2.push(1);
        l2.push(2);
        
        
        LinkedList l3 = new LinkedList();
        l3.push(8);
        l3.push(9);
        
        Node temp1 = l1.head;
        while (temp1.next != null) {
            temp1 = temp1.next;
        }
        
        //temp1.next = l3.head;
        
        Node temp2 = l2.head;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        
        //temp2.next = l3.head;
        
        System.out.println("original");
        l1.showLinkedList();
        l2.showLinkedList();
        System.out.println("Intersection point of two Linked Lists");
        Node find = new Node(0);
        Node inter = find.getIntersection(l1.head,l2.head);
        if (inter != null) {
            System.out.print("Intersection node: " + inter.data);
        } else {
            System.out.print("No intersection found.");
        }
    }
}
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
    public Node getIntersection(Node n1, Node n2) {
        if (n1 == null || n2 == null) {
            return null;
        }
        
        Node temp1 = n1;
        Node temp2 = n2;
        
        // Loop until they are the exact same node (or both are null)
        while (temp1 != temp2) {
            // Move temp1 forward. If it hits null, warp to the head of n2
            if (temp1 == null) {
                temp1 = n2;
            } else {
                temp1 = temp1.next;
            }
            
            // Move temp2 forward. If it hits null, warp to the head of n1
            if (temp2 == null) {
                temp2 = n1;
            } else {
                temp2 = temp2.next;
            }
        }
        
        // If they intersect, it returns the node. If they don't, they both hit null and it returns null.
        return temp1;
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
}
