class Solution {
    // M-1 using backtracking (by recursion) | O(n × 2^n) | space O(n + (2^n) * n)
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        solve (nums, 0 , temp);
        return result;
    }
    public void solve(int [] nums, int i ,List<Integer> temp){
        if (i == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        // take ith element 
        temp.add(nums[i]);
        solve(nums, i + 1 , temp);
        // not take ith element 
        temp.remove(temp.size() -1);
        solve(nums, i + 1 , temp);
    }
}