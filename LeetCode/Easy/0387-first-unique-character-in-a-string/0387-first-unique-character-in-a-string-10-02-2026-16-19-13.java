class Solution {
    public int firstUniqChar(String s) {
        // M-3 optimal apprach| time O(n) | space O(1)
        int n = s.length();
        int [] arr = new int [26];
        // store freq of each char in arr 
        for (char ch : s.toCharArray()){
            arr[ch - 'a']++;
        }
        //  Traverse the original string to preserve order.
        for (int i = 0; i < n; i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}