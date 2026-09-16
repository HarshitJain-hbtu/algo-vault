class Solution {
    public String longestCommonPrefix(String[] strs) {
        // M -4 optimal approach| time O(n * L) | space O(L) | where n = strs.length & L = strs[i].length, 
        // intuation is now we compare characters (vertical scanning)
        for (int i = 0 ; i < strs[0].length(); i++){
            char ch = strs[0].charAt(i);

            // compare with each string first char 
            for (int j = 1 ; j < strs.length; j++){
                if (i >= strs[j].length() || ch != strs[j].charAt(i)){
                    return strs[0].substring(0 , i);
                }
            }
        }
        return strs[0];
    }
}