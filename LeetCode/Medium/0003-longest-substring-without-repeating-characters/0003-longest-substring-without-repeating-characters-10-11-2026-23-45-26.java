class Solution {
    public int lengthOfLongestSubstring(String s) {
        // M-1 brut force (try all substring) using two pointer | time O(n * n) | space o(1)
        int n = s.length();
        int maxLen = 0 ;

        for (int i = 0 ; i < n;i++){
            int [] hash = new int [255];
            Arrays.fill(hash, -1);
            int len = 0 ;
            for (int j = i ; j < n ;j++){
                // if duplicate char found 
                if(hash[s.charAt(j)] != -1){
                    break;
                }
                // new unique char
                hash[s.charAt(j)] = 1;
                len = j - i + 1;
                maxLen = Math.max(len , maxLen);
            }
        }
        return maxLen;
    }
}