class Solution {
    public boolean rotateString(String s, String goal) {
        // M -1 brut force | time O(n^2) | space O(n)
        if (s.length() != goal.length()){
            return false;
        }
        if (s.equals(goal)){
            return true;
        }
        int n = s.length();
        for (int p = 1; p < n; p++) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                sb.append(s.charAt((i + p) % n));
            }

            if (sb.toString().equals(goal)) {
                return true;
            }
        }
        return false;
    }
}