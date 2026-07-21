class Intersection_of_two_Sorted_Linked_Lists {
    //main food for thought is using a hash map or a comparision method 
    //wouldnt be a best way as The Hashmap Approach: This works great and
    //runs in $O(M + N)$ time, but it requires $O(M)$ extra space to
    //store the map.
    //Compare Everything" Approach (Nested Loops): This requires O(1) extra space, but it forces you to scan the second list repeatedly, resulting in a slow O(M×N) time complexity.
    
    //what we did was that we used "two pointer" approach
    //if both match then we move both pointer and if either one is small we move the smaller pointer. NOTE: this only works if we have sorted linkedlist
    
    public static void main(String[] args) {
        
        LinkedList l1 = new LinkedList();
        l1.push(1);
        l1.push(2);
        l1.push(4);
        l1.push(6);
        
        LinkedList l2 = new LinkedList();
        l2.push(1);
        l2.push(2);
        l2.push(3);
        l2.push(4);

        System.out.println("original");
        l1.showLinkedList();
        l2.showLinkedList();
        System.out.println("new node");
        l2.intersectionOfTwoSortedLists(l1.head,l2.head).showLinkedList();
        
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
    //only for sorted elements
    public LinkedList intersectionOfTwoSortedLists(Node n1, Node n2){
        LinkedList returnList = new LinkedList();
        
        while(n1!=null && n2!=null){
            if(n1.data==n2.data){
                //will come here
                returnList.push(n1.data);
                n1=n1.next;
                n2=n2.next;
                
            }
            else if(n1.data<n2.data){
                n1=n1.next;
            }
            else{
                n2=n2.next;
            }
        }
        return returnList;
    }
}
