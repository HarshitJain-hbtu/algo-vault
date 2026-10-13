class Solution {
    public String removeKdigits(String num, int k) {
        // M -2 better approach | time O(n * k ) | space O(n)
        // greedy appraoch if any digit is greater that its right digit then remove digit while k > 0 and when no digit is found in one scan means all digits in non descending order so remove last digits till k == 0 
        StringBuilder sb = new StringBuilder(num);

        while (k > 0) {
            boolean removed = false;

            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) > sb.charAt(i + 1)) {
                    sb.deleteCharAt(i);
                    k--;
                    removed = true;
                    break;
                }
            }

            if (!removed) {
                // now digits in non descending order so remove last digits till k == 0 
                while (k > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                    k--;
                }
            }
        }
        // removing leading zeroes 
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        String result = sb.substring(i);
        return result.isEmpty() ? "0" : result;
    }
}