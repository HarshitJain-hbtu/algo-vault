class Solution {
    public String reverseStr(String s, int k) {
        // M-1 optimal approach | time O(n) | space O(n)
        int n = s.length();
        char [] str = s.toCharArray();
        
        for (int i = 0 ; i < n ; i+= 2 * k){
            int left = i ;
            int right = Math.min(i + k -1, n-1);      // to handle if i < n but j > n then reverse i till last element
            // reverse char from left to right 
            while (left < right){
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                left++ ;
                right--;
            }
        }
        return new String (str);
    }
}