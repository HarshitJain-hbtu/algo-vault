class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // M-3 optimal approach | time (m + n) | space O(1) 
        // Merge from the end to avoid overwriting
        int i = m - 1;
        int j = n - 1;
        int k = m + n -1;

        // untill all j ele got merged
        while (j >= 0){
            if (i >= 0 && nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }
            else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}