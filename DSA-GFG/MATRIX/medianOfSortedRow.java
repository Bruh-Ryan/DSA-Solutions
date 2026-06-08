//javac medianOfSortedRow.java
// java medianOfSortedRow
class Node {
    int val;
    int row;
    int col;

    public Node(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }
}

public class medianOfSortedRow {
    public static void main(String args[]) {
        int[][] matrix = {
            {1, 5, 9},
            {2, 4, 11},
            {3, 6, 8}
        };

       int rw = matrix.length;
       int cl = matrix[0].length;
       int target = (rw*cl+1)/2; //formula for median (n*m+1)/2

       pQ q = new pQ(rw);

       for (int i = 0; i < rw; i++) {
            q.push(new Node(matrix[i][0], i, 0));
        }
        q.display();
        int counter = 0;
        Node poppedNode = null;

        while(counter<target){
            // Extract the minimum element
            q.display();
            poppedNode = q.pop();
            counter++;
            if(counter<target){
                int r = poppedNode.row;
                int c = poppedNode.col;
                if(c+1<cl){
                    q.push(new Node(matrix[r][c + 1], r, c + 1));
                }
                else {
                    // If the row is exhausted, we push 'infinity' to keep heap logic intact,
                    // or in this implementation, we simply don't push, but our pQ needs to handle shrinking.
                    // For simplicity in a fixed array heap, push Integer.MAX_VALUE.
                    q.push(new Node(Integer.MAX_VALUE, r, c + 1));
                }
            }
        }
        System.out.println("The median is: " + poppedNode.val);

    }
}

class pQ {
    Node[] arr; // Upgraded to hold Nodes
    int size;
    int capacity;

    public pQ(int capacity) {
        this.capacity = capacity;
        arr = new Node[capacity];
        size = 0;
    }

    public void push(Node element) {
        if (size == capacity) {
            System.out.println("MAX Reached");
            return;
        }
        arr[size] = element;
        size++;
        heapifyUp(size - 1);
    }

    // NEW: Pop method to extract the root
    public Node pop() {
        if (size == 0) return null;
        Node root = arr[0];
        arr[0] = arr[size - 1]; // Move last element to root
        size--;
        heapifyDown(0); // Sink it down to restore heap property
        return root;
    }

    public void heapifyUp(int s) {
        int parent = (s - 1) / 2;
        // Upgraded to compare Node.val
        while (s > 0 && arr[s].val < arr[parent].val) {
            Node temp = arr[s];
            arr[s] = arr[parent];
            arr[parent] = temp;

            s = parent;
            parent = (s - 1) / 2;
        }
    }

    // NEW: HeapifyDown to restore heap after popping
    public void heapifyDown(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left].val < arr[smallest].val) {
            smallest = left;
        }
        if (right < size && arr[right].val < arr[smallest].val) {
            smallest = right;
        }
        if (smallest != i) {
            Node swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;
            heapifyDown(smallest); // Recursively heapify down
        }
    }
    public void display(){
        for (int i = 0; i < size; i++)
            System.out.print("|v:" + arr[i].val + " row:" + arr[i].row + "col: "+arr[i].col+" |");
        System.out.println();
    }
}