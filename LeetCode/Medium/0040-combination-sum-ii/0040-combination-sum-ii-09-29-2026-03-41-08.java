class Solution {
    // M-3 using recursion (here we are skip creating duplicates) | time complexity O(nlogn + 2 ^ n  * k) | space complexity O((n + R * n)) | R is the unique combinations
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, temp, 0);
        return result;
    }
    private void solve (int [] nums , int remaining , List<Integer> temp, int idx){
        // initially we have i till n -1  options to start then we choose one path then we have that index to n - 1 options to choose 
        if (remaining == 0){
            result.add(new ArrayList<>(temp));
            return ;
        }
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > remaining) {
                break;
            }

            temp.add(nums[i]);
            solve(nums, remaining - nums[i], temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}