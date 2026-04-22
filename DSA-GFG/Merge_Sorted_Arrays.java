import java.util.Arrays;
import java.util.Scanner;

public class Merge_Sorted_Arrays {

    public static void main(String[] args) {
        Merge_Sorted_Arrays obj = new Merge_Sorted_Arrays();

        int[][] nums1Cases   = {{1,2,3,0,0,0}, {1,0}, {0}, {2,5,6,0,0,0}, {1,3,5,7,0,0,0,0}};
        int[]   mValues      = {3, 1, 0, 3, 4};
        int[][] nums2Cases   = {{2,5,6}, {2}, {1}, {1,2,3}, {2,4,6,8}};
        int[]   nValues      = {3, 1, 1, 3, 4};
        int[][] expected     = {{1,2,2,3,5,6}, {1,2}, {1}, {1,2,2,3,5,6}, {1,2,3,4,5,6,7,8}};

        System.out.println("=== Hardcoded Test Cases ===");
        for (int t = 0; t < nums1Cases.length; t++) {
            int[] nums1 = nums1Cases[t].clone();
            int[] nums2 = nums2Cases[t].clone();
            obj.merge(nums1, mValues[t], nums2, nValues[t]);
            String status = Arrays.equals(nums1, expected[t]) ? "✅ PASS" : "❌ FAIL";
            System.out.printf(
                "Test %d | nums1=%s m=%d | nums2=%s n=%d | Expected=%s Got=%s | %s%n",
                t + 1,
                Arrays.toString(nums1Cases[t]), mValues[t],
                Arrays.toString(nums2Cases[t]), nValues[t],
                Arrays.toString(expected[t]),
                Arrays.toString(nums1),
                status
            );
        }

        System.out.println("\n=== Custom Input ===");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter m (number of valid elements in nums1): ");
        int m = sc.nextInt();
        System.out.print("Enter n (number of elements in nums2): ");
        int n = sc.nextInt();

        int[] nums1 = new int[m + n];
        System.out.print("Enter " + m + " sorted elements for nums1: ");
        for (int i = 0; i < m; i++) nums1[i] = sc.nextInt();

        int[] nums2 = new int[n];
        System.out.print("Enter " + n + " sorted elements for nums2: ");
        for (int i = 0; i < n; i++) nums2[i] = sc.nextInt();

        System.out.println("Choose method:\n 1. Two Pointer from Back O(m+n)");
        int choice = sc.nextInt();

        int[] result = nums1.clone();
        switch (choice) {
            case 1:
                obj.merge(result, m, nums2.clone(), n);
                System.out.printf(
                    "nums1=%s nums2=%s → Output: %s%n",
                    Arrays.toString(Arrays.copyOf(nums1, m)),
                    Arrays.toString(nums2),
                    Arrays.toString(result)
                );
                break;
            default:
                System.out.println("Invalid choice.");
        }
        sc.close();
    }

    // Two-pointer from back — O(m+n) time, O(1) space
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;       // last valid element in nums1
        int j = n - 1;       // last element in nums2
        int k = m + n - 1;   // last index of nums1 (including empty slots)

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}