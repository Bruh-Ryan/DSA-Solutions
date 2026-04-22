import java.util.Arrays;
import java.util.Scanner;

public class Plus_One {

    public static void main(String[] args) {
        Plus_One obj = new Plus_One();

        int[][] testInputs = {{1,2,3}, {4,3,2,1}, {9}, {9,8,9}, {9,9,9}};
        int[][] expected   = {{1,2,4}, {4,3,2,2}, {1,0}, {9,9,0}, {1,0,0,0}};

        System.out.println("=== Hardcoded Test Cases ===");
        for (int t = 0; t < testInputs.length; t++) {
            int[] result = obj.plusOne(testInputs[t].clone());
            String status = Arrays.equals(result, expected[t]) ? "✅ PASS" : "❌ FAIL";
            System.out.printf(
                "Test %d | nums=%s | Expected=%s Got=%s | %s%n",
                t + 1,
                Arrays.toString(testInputs[t]),
                Arrays.toString(expected[t]),
                Arrays.toString(result),
                status
            );
        }

        System.out.println("\n=== Custom Input ===");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = sc.nextInt();
        int[] digits = new int[size];

        System.out.print("Enter " + size + " digits: ");
        for (int i = 0; i < size; i++) digits[i] = sc.nextInt();

        System.out.println("Enter method:\n 1. Brute Force O(n)");
        int choice = sc.nextInt();

        int[] output = new int[0];
        switch (choice) {
            case 1:
                output = obj.plusOne(digits.clone());
                // falls through to print
            default:
                System.out.printf(
                    "nums=%s → Output: %s%n",
                    Arrays.toString(digits),
                    Arrays.toString(output)
                );
        }
        sc.close();
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;      // no carry, just increment and return
                return digits;
            }
            digits[i] = 0;        // carry: set to 0 and continue
        }

        // All digits were 9 (e.g. [9,9,9] → [1,0,0,0])
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}