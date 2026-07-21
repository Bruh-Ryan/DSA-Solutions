class Add_two_numbers_using_elements_of_the_list {
    public static void main(String[] args) {
        
        LinkedList l2 = new LinkedList();
        l2.push(1);
        l2.push(2);
        l2.push(3);
        l2.push(4);
        l2.push(9);
        System.out.println("original");
        l2.showLinkedList();
        System.out.println("add sum");
        l2.addSum(l2.head);
        l2.showLinkedList();
        System.out.println("add one");
        l2.addOne(l2.head);
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
    public static void addOne(Node head){
        int carry = addOneHelper(head);
        if (carry > 0) {
            Node newHead = new Node(carry);
            newHead.next = head;
            head = newHead;
        }
    }
    public static int addOneHelper(Node node){
        if(node == null){
            return 1;
        }
        int carry = addOneHelper(node.next);// in the last stage of recursion the one return because we are just adding 1; so we get that from if statement above;
        
        int sum = node.data+carry;
        node.data = sum % 10;
        return sum/10;
    }
    public static void addSum(Node head){
        int carry = addSumHelper(head);
        if(carry>0){
            Node newHead = new Node(carry);
            newHead.next = head;
            head = newHead;
        }
    
    }
    public static int addSumHelper(Node node){
        if(node==null){
            return 0;
        }
        int carry = addSumHelper(node.next);
        int sum = node.data + node.data + carry;
        node.data = sum%10;
        return sum/10;
    }
}
