class Solution {
    public String longestCommonPrefix(String[] strs) {
        // same as brut force approach(but differ implementation | time O(n * L^2) | space O(L) 
        //  where n = strs.length & L = strs[i].length, startsWith fn takes L time 
        String prefix = strs[0];
        // now we can keep reducing our current prefix till get common prefix for all string 
        for (int i = 1 ; i < strs.length; i++){
            while (!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0 ,prefix.length()-1);
            }
            if (prefix.isEmpty()){
                return "";
            }
        }
        return prefix;
    }
}