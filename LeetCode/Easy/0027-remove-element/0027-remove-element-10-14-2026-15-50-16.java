class Solution {
    public int removeElement(int[] nums, int val) {
        // M-2 optimal approach | time O(n) | space O(1)
        int n = nums.length;
        int idx = 0 , count = 0;
        for (int i = 0 ; i < n; i++){
            if (nums[i] != val){
                count++;
                nums[idx++] = nums[i];
            }
        }
        if (idx != n){
            while(idx < n){
                nums[idx++] = 0 ;
            }
        }
        return count;
    }
}