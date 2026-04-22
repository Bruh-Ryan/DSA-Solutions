import java.util.*;

class Count_Inversion {
    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 1};

        System.out.println("Choose\n 1.testcase  2.make testcase");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        if (a == 1) {
            System.out.println("Choose 1. brute or 2. optimise");
            int b = sc.nextInt();
            if (b == 1) {
                brute_force(arr);
            }
            if (b == 2) {
                long result = optimise(arr, 0, arr.length - 1); 
                System.out.println(result);
            }
        }
        if (a == 2) {
            System.out.println("NOT MADE YET");
        }
    }

    public static void brute_force(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) count++;
            }
        }
        System.out.println(count);
    }

    public static long optimise(int[] arr, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += optimise(arr, left, mid);        // left half inversions
            count += optimise(arr, mid + 1, right);   // right half inversions
            count += merge(arr, left, mid, right);    // split inversions
        }
        return count;
    }

    public static long merge(int[] arr, int left, int mid, int right) {
        long count = 0;
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
                count += (n1 - i); 
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];

        return count;
    }
}