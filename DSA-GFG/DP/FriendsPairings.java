public class FriendsPairings {
      public static void main(String[] args) {
        int n = 3;
        int result = countFriendsPairings(n);
        System.out.println(result);
        
    }
    static int countFriendsPairings(int n)
    {
        // base cases
        if (n <= 2)
            return n;

        // recursive calls
        return countFriendsPairings(n - 1) + (n - 1) * countFriendsPairings(n - 2);
    }
}
