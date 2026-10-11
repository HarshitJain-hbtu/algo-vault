class Solution {
    public int lengthOfLongestSubstring(String s) {
        // M - 2 better approach | time O(n) | space O(k) k is no of distinct char in s 
        int n = s.length();
        int maxLen = 0 ;
        int low = 0 , high = 0 ; 
        HashSet<Character> set = new HashSet<>();
        while (high < n){
            char ch = s.charAt(high);
            // Remove characters until the duplicate is eliminated
            while (set.contains(ch)) {
                set.remove(s.charAt(low));
                low++;
            }

            // Add the current unique character
            set.add(ch);

            // Update the maximum window length
            maxLen = Math.max(maxLen, high - low + 1);
            high++;
        }
        return maxLen;
    }
}