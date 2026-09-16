class Solution {
    public boolean isIsomorphic(String s, String t) {
        // instead of using hashmap we use two arr of size 256
        // M-3 optimal approach  | time O(n) | space O(1)
        int [] nums1 = new int [256];
        int [] nums2 = new int [256];
 
        for (int i = 0 ; i < s.length();i++){
            char a = s.charAt(i);
            char b = t.charAt(i);

            // if char reoccur then they should store same 
            if (nums1[a] != nums2[b]){
                return false;
            }
            // now we map current char with same value
            nums1[a] = i+1;
            nums2[b] = i+1;
        }
        return true;
    }
}