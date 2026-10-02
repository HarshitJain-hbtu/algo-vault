class Solution {
    public int missingNumber(int[] nums) {
        // M-2 optimal approach (using sum of first n numbers| time O(n) | space O(1)
        int n = nums.length;
        int sum = 0 ;
        for (int num : nums){
            sum += num;
        }
        // sum of first n num = n * n+1/2
        return n * (n+1)/2 - sum;
    }
}