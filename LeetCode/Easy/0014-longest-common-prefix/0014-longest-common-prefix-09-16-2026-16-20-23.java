class Solution {
    public String longestCommonPrefix(String[] strs) {
        // M -3 better approach| time O(nlog n * L) | space O(L) | where n = strs.length & L = strs[i].length, 
        // sort array lexiographically (not sort each element internally) just sort array acc to char
        Arrays.sort(strs);
        // now find common prefix from first and last string 
        String first = strs[0];
        String last = strs[strs.length -1];
        int i = 0 ;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)){
            i++;
        }
        return first.substring(0 , i);
    }
}