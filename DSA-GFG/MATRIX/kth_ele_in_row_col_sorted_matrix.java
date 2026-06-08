class node {
    int val;
    int row;
    int col;

    public node(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }
}

class priorityQueues {
    node[] arr;
    int size;
    int capacity;

    public priorityQueues(int capacity) {
        this.capacity = capacity;
        arr = new node[capacity];
        size = 0;
    }

    public void push_e(node element) {
        if (size == capacity) {
            System.out.println("MAX Reached");
            return;
        }
        arr[size] = element;
        size++;
        heapifyUp(size - 1);
    }

    public node pop() {
        if (size == 0) return null;

        node root = arr[0];
        arr[0] = arr[size - 1];
        size--;
        heapifyDown(0);

        return root;
    }

    public node peekNode() {
        if (size == 0) return null;
        return arr[0];
    }

    public void heapifyUp(int s) {
        int parent = (s - 1) / 2;

        while (s > 0 && arr[s].val > arr[parent].val) {
            node temp = arr[s];
            arr[s] = arr[parent];
            arr[parent] = temp;

            s = parent;
            parent = (s - 1) / 2;
        }
    }

    public void heapifyDown(int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left].val > arr[largest].val) {
            largest = left;
        }

        if (right < size && arr[right].val > arr[largest].val) {
            largest = right;
        }

        if (largest != i) {
            node swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapifyDown(largest);
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("|v:" + arr[i].val + " row:" + arr[i].row + " col:" + arr[i].col + "| ");
        }
        System.out.println();
    }

    public int size() {
        return size;
    }

    public int peek() {
        if (size == 0) {
            return -1;
        }
        return arr[0].val;
    }
}

public class kth_ele_in_row_col_sorted_matrix {
    public static void main(String[] arhs) {
        int[][] mat = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {24, 29, 37, 48},
            {32, 33, 39, 50}
        };

        int k = 3;
        priorityQueues q = new priorityQueues(mat.length * mat.length);

        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[i].length; ++j) {
                q.push_e(new node(mat[i][j], i, j));

                if (q.size() > k) {
                    q.pop();
                }
            }
        }

        node ans = q.peekNode();
        System.out.println("kth smallest: " + ans.val);
        System.out.println("row: " + ans.row + " col: " + ans.col);
    }
}