class Solution {
    public String longestCommonPrefix(String[] strs) {
        // brut force approach | time O(n * L^2) | space O(L)   , where n = strs.length & L = strs[i].length, startsWith fn takes L time 
        String ans = "";
        // Generate every prefix of first string
        for (int i = 1 ; i <= strs[0].length(); i++){
            String prefix = strs[0].substring(0, i);

            // Check prefix in every string
            boolean valid = true;
            for (int j = 1 ; j < strs.length; j++){
                if (!strs[j].startsWith(prefix)){
                    valid = false;
                    break;
                }
            }

            if (valid){
                ans = prefix;
            }else{
                break;
            }
        }
        return ans;
    }
}