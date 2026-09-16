class Solution {
    public boolean rotateString(String s, String goal) {
        // M-3  still better ans clean approach | time O(n * n) | space O(n)
        if (s.length() != goal.length()){
            return false;
        }
        return (s + s).contains(goal);
    }
}