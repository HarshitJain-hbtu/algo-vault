class Solution {
    public int missingNumber(int[] nums) {
        // M-1 optimal approach | time O(n) | space O(1)
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }
}