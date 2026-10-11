class Solution {
    public String reverseStr(String s, int k) {
        // M-2 better approach | time O(n) | space O(n)
        int n = s.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i += 2 * k) {
            int end = Math.min(i + k, n);

            // Reverse the first k characters
            result.append(new StringBuilder(s.substring(i, end)).reverse());

            // Keep the next k characters unchanged
            int next = Math.min(i + 2 * k, n);
            if (end < next) {
                result.append(s.substring(end, next));
            }
        }

        return result.toString();
    }
}