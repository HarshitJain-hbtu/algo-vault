class Solution {
    public void moveZeroes(int[] nums) {
        // M-3 better approach | time O(n) | space O(n)
        int n = nums.length;
        int[] temp = new int[n];
        int index = 0;

        // Copy all non-zero elements
        for (int num : nums) {
            if (num != 0) {
                temp[index++] = num;
            }
        }

        // Remaining positions are already zero
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}