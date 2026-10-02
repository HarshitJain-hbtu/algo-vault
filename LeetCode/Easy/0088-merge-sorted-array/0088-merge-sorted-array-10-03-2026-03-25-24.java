class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // M-1 brut force | time O(m + n) | space O(m + n)
        int [] arr = new int [m + n];
        int idx = 0;
        int i = 0 ; 
        int j = 0 ;
        while (i < m && j < n){
            if (nums1[i] < nums2[j]){
                arr[idx++] = nums1[i];
                i++;
            }
            else{
                arr[idx++] = nums2[j];
                j++;
            }
        }
        while (i < m){
            arr[idx++] = nums1[i];
            i++;
        }
        while (j < n){
            arr[idx++] = nums2[j];
            j++;
        }

        // copy back to nums1
        for (int x = 0 ; x < m+n; x++){
            nums1[x] = arr[x];
        }
    }
}