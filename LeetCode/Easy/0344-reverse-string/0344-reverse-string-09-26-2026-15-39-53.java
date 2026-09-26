class Solution {
    public void reverseString(char[] s) {
        // M-1 optimal approach | time O(n) | space O(1)
        int n = s.length;
        for (int i = 0 ; i < n/2;i++){
            // swap 
            char temp = s[i];
            s[i] = s[n-i-1];
            s[n-i-1] = temp;
        }
    
    }
}