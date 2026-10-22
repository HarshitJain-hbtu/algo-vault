class Solution {
    public int firstMissingPositive(int[] nums) {
        // M -2 better appraoch | time O(n) | space O(n)
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        for (int i = 1; i <= n + 1; i++){
            if (!set.contains(i)){
                return i;
            }
        }
        return -1;
    }
}