class Solution {
    public int findDuplicate(int[] nums) {
        // M-3 optimal appraoch (cyclic sort) | time O(n) | space O(1)
        int i = 0 ; 
        while(i < nums.length){
            int correct = nums[i] - 1;
            if(nums[correct] != nums[i]){
                swap(nums, i , correct);
            }
            else{
                i++;
            }
        }
        // after sorting the numbers are not at their correct index are the duplicate ones 
        for (int j = 0 ; j < nums.length; j++){
            if (nums[j] != j+1){
                return nums[j];
            }
        }
        return -1;
    }
    private void swap (int [] nums, int f , int s){
        int temp = nums[f];
        nums[f] = nums[s];
        nums[s] = temp;
    }
}