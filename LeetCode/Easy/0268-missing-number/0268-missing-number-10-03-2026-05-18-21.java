class Solution {
    public int missingNumber(int[] nums) {
        // M-3 better approach (by sorting)| time O(n * logn) | space O(1)
        int n = nums.length;
        Arrays.sort(nums);
        // now check each index should equal to value
        for (int i = 0 ; i < n ; i++){
            if (nums[i] != i){
                return i ;
            }
        }
        return n;
    }
}