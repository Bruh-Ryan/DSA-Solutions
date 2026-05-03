import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Find all pairs on integer array whose sum is equal to given number
public class Two_Sum {

    public static void main(String[] args) {
        Two_Sum obj = new Two_Sum();

        int[][] numsCases = {
            {10, 12, 10, 15, -1},
            {1,  5,  7, -1,  5},
            {1,  1,  1,  1},
            {3,  2,  4,  6},
            {5,  5,  5,  5}
        };
        int[] targets  = {125,  6,  2, 100, 10};
        int[] expected = {  0,  3,  6,   0,  6};

        System.out.println("=== Hardcoded Test Cases ===");
        for (int t = 0; t < numsCases.length; t++) {
            int bruteResult = obj.countPairsBruteForce(numsCases[t], targets[t]);
            String status   = (bruteResult == expected[t]) ? "✅ PASS" : "❌ FAIL";
            System.out.printf(
                "Test %d | nums=%-20s target=%-4d | Expected=%-3d Got=%-3d | %s%n",
                t + 1,
                Arrays.toString(numsCases[t]),
                targets[t],
                expected[t],
                bruteResult,
                status
            );
        }

        System.out.println("\n=== Custom Input ===");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        System.out.println("Choose approach:");
        System.out.println(" 1. Brute Force  — O(n²) time | O(1) space");
        System.out.println(" 2. HashMap      — O(n)  time | O(n) space  [come back to this later!]");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                int res1 = obj.countPairsBruteForce(nums, target);
                System.out.printf(
                    "nums=%s target=%d → Pair count: %d%n",
                    Arrays.toString(nums), target, res1
                );
                break;
            case 2:
                int res2 = obj.countPairsHashMap(nums, target);
                System.out.printf(
                    "nums=%s target=%d → Pair count: %d%n",
                    Arrays.toString(nums), target, res2
                );
                break;
            default:
                System.out.println("Invalid choice.");
        }
        sc.close();
    }

    // ── Approach 1: Brute Force — O(n²) time | O(1) space ────────────────────
    public int countPairsBruteForce(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {   
                if (find == nums[j]) {                     
                    count++;
                }
            }
        }
        return count;                                      
    }

    // ── Approach 2: HashMap — O(n) time | O(n) space ─────────────────────────
    public int countPairsHashMap(int[] nums, int target) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int complement = target - num;
            if (freq.containsKey(complement)) {
                count += freq.get(complement);
            }
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}