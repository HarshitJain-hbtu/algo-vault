class Solution {
    public int findDuplicate(int[] nums) {
        // M-2 better approach (using sorting) | time O(n * log n) | space O(1)
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0 ; i < n-1;i++){
            if (nums[i] == nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }
}