class Solution {
    // M -3 using Backtraking (now we never generate duplicate) | time O(n * 2 ^n) | space O(n + n * 2^n)
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<>());
        return result;
    }

    private void solve(int[] nums, int start, List<Integer> temp) {
        // Every temp is a valid subset
        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicate at SAME LEVEL
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            // Choose
            temp.add(nums[i]);
            // Recursion
            solve(nums, i + 1, temp);
            // Backtrack
            temp.remove(temp.size() - 1);
        }
    }
}