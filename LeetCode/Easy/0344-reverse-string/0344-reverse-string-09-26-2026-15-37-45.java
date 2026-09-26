class Solution {
    public void reverseString(char[] s) {
        // M-1 optimal approach | time O(n) | space O(1)
        int n = s.length;
        int i = 0 ;
        int j = n-1;
        while(i < j){
            // swap 
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i++;
            j--;
        }
    }
}