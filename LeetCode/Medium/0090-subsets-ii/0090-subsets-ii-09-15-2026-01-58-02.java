class Solution {
    // M -3 using Backtraking (now we never generate duplicate) | time O(n * 2 ^n) | space O(n + n * 2^n)
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<>());
        return result;
    }

    private void solve(int[] nums, int i, List<Integer> temp) {
        if (i == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        // we add ith element
        temp.add(nums[i]);
        solve(nums , i+1 , temp);
        // backtrack and // we not take ith element (exclude) 
        temp.remove(temp.size()-1);
        // but before next ele we skip duplicates 
        int idx = i+1 ;
        while(idx < nums.length && nums[idx] == nums[idx-1]){
            idx++;
        }
        solve (nums , idx ,temp);
    }
}