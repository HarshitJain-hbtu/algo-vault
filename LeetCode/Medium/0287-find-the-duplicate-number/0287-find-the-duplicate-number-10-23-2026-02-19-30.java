class Solution {
    public int findDuplicate(int[] nums) {
        // M-2 better approach (using extra array) | time O(n) | space O(n)
        int n = nums.length; 
        int [] arr = new int[n];
        for (int num : nums){
            arr[num]++;

            if (arr[num] > 1){
                return num;
            }
        } 
        return -1;
    }
}