class Solution {
    public int firstMissingPositive(int[] nums) {
        // M - 3 optimal appraoch (in place -ve marking)| time O(n) | space O(1)
        int n = nums.length;

        // Step 1: Ignore irrelevant values
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Step 2: Mark the positions of existing numbers
        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]);

            if (x <= n) {
                nums[x - 1] = -Math.abs(nums[x - 1]);
            }
        }

        // Step 3: Find the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}