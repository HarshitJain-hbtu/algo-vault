class Solution {
    public String longestCommonPrefix(String[] strs) {
        // M -3 better approach| time O(nlog n * L) | space O(L) 
        //  where n = strs.length & L = strs[i].length, 
        StringBuilder ans = new StringBuilder();
        // sort array lexiographically (not sort each element internally) just sort array acc to char
        Arrays.sort(strs);
        // now find common prefix from first and last string 
        String first = strs[0];
        String last = strs[strs.length -1];
        int i = 0 ;
        int j = 0 ;
        while (i < first.length() && j < last.length()){
            if (first.charAt(i) == last.charAt(j)){
                ans.append(first.charAt(i));
                i++ ;
                j++;
            }
            else {
                break;
            }
        }
        return ans.toString();
    }
}