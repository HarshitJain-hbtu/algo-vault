class Solution {
    public int firstUniqChar(String s) {
        // M-2 better approach | time O(n) | space O(n)
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        // store freq of each char 
        for (char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }
        //  Traverse the original string to preserve order.
        for (int i = 0; i < n; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}