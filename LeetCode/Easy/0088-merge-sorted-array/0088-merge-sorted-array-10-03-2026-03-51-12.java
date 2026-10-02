class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // M-1 brut approach | time O(m + n) * log (m + n) | space O(log (m + n))
        // copy nums2 element into nums1 and then sort whole nums1
        for (int i = 0 ; i< n;i++){
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}