class Solution {
    public int removeElement(int[] nums, int val) {
        // M-1 brut force | time O(n) | space O(n)
        int n = nums.length;
        int [] arr = new int[n];
        int idx = 0 , count = 0;
        for (int i = 0 ; i < n; i++){
            if (nums[i] != val){
                count++;
                arr[idx++] = nums[i];
            }
        }
        for (int i =0 ; i < n;i++){
            nums[i] = arr[i];
        }
        return count;
    }
}