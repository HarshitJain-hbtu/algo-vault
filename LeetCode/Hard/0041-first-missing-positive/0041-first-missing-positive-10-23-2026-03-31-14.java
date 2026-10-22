class Solution {
    public int firstMissingPositive(int[] nums) {
        // M - 3 optimal appraoch (using cyclic sort)| time O(n) | space O(1)
        int n = nums.length;
        int i = 0;

        while (i < n) {
            int correct = nums[i] - 1;

            if (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[correct]) {
                // swap 
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }

        return n + 1;
    }
}