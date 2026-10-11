class Solution {
    public int lengthOfLongestSubstring(String s) {
        // M - 2 optimal approach | time O(n) | space o(1)
        int n = s.length();
        int maxLen = 0 ;
        int low = 0 , high = 0 ; 
        int [] arr = new int [255];
        Arrays.fill(arr , -1);
        while (high < n){
            char ch = s.charAt(high);
            // duplicate char occured 
            if (arr[ch] != -1){
                // and its position is >= low then
                if (arr[ch] >= low){
                    low = arr[ch] + 1;
                }
            }

            int len = high - low + 1;
            maxLen = Math.max(len , maxLen);
            // store index of ch occurs 
            arr[ch] = high;
            high++;
        }
        return maxLen;
    }
}