class Subset_Sum_Problem {
    public static void main(String[] args) {
        int arr[] = {1, 5, 5, 11,11};
        int totalSum = 0;
        
        for (int num : arr) {
            totalSum += num;
        }
        
        if (totalSum % 2 != 0) {
            System.out.println(" result " + false);
            return;
        }
        
        int target = totalSum / 2;
        int lastIndex = arr.length - 1;
        boolean result = solve(lastIndex, target, arr); 
        System.out.println(" result " + result);
    }
    
    public static boolean solve(int idx, int target, int[] arr) {

        if (target == 0) {
            return true;
        }
        
        if (idx < 0 || target < 0) {
            return false;
        }
      
        boolean take = solve(idx - 1, target - arr[idx], arr);
        boolean skip = solve(idx - 1, target, arr);
        
     
        return take || skip;
    }
}
