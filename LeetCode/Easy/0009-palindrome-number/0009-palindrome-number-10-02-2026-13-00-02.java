class Solution {
    public boolean isPalindrome(int x) {
        // M-1 brut force (using string) | time O(log n) | space O(log n)
        if (x < 0) return false;

        String s = String.valueOf(x);
        String rev = new StringBuilder(s).reverse().toString();

        return s.equals(rev);
    }
}