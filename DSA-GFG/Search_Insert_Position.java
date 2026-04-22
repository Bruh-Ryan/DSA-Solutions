import java.util.Arrays;
import java.util.Scanner;

public class Search_Insert_Position {

    public static void main(String[] args) {
        Search_Insert_Position obj = new Search_Insert_Position();

        int[][] testNums   = {{1,3,5,6}, {1,3,5,6}, {1,3,5,6}, {1,3,5,6}, {1}};
        int[]   targets    = {5, 2, 7, 0, 0};
        int[]   expected   = {2, 1, 4, 0, 0};

        System.out.println("=== Hardcoded Test Cases ===");
        for (int t = 0; t < testNums.length; t++) {
            int result = obj.searchInsert(testNums[t], targets[t]);
            String status = result == expected[t] ? "✅ PASS" : "❌ FAIL";
            System.out.printf(
                "Test %d | nums=%s target=%d | Expected=%d Got=%d | %s%n",
                t + 1, Arrays.toString(testNums[t]), targets[t], expected[t], result, status
            );
        }

        System.out.println("\n=== Custom Input ===");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = sc.nextInt();
        int[] nums = new int[size];

        System.out.print("Enter " + size + " sorted integers: ");
        for (int i = 0; i < size; i++) nums[i] = sc.nextInt();

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        System.out.println("Enter method:\n 1. Binary Search O(log n)\n 2. Brute Force O(n)");
        int choice = sc.nextInt();
        int output = 0;

        switch (choice) {
            case 1 -> output = obj.searchInsertBinarySearch(nums, target);
            case 2 -> output = obj.searchInsert(nums, target);
        }

        System.out.printf("nums=%s target=%d → Output: %d%n", Arrays.toString(nums), target, output);
        sc.close();
    }

    // Brute Force — O(n)
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length; // target is larger than all elements
    }

    // Binary Search — O(log n)
    public int searchInsertBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // ✅ fixed: was nums.length (causes ArrayIndexOutOfBounds)

        while (left <= right) {      // ✅ fixed: was left < right (misses single element)
            int mid = left + (right - left) / 2; // ✅ fixed: was left + (left - right)/2 (wrong formula → negative mid)
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1; // ✅ fixed: was return mid - 1
            else left = mid + 1;                           // ✅ fixed: was return mid + 1
        }

        return left; // natural insert position when target not found
    }
}