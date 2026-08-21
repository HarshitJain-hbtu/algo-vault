class Solution {
    public void sortColors(int[] nums) {
        // dutch national flag algo  & time O(n) and space O(1)
        /*
        using three pointers low mid high , 
            from 0 to low-1  all zeros 
            from low to mid-1 all ones
            form mid to high unsorted array 
            form high + 1 to  n-1 all two 
            try to form this / maintain this
        */
        int n = nums.length;
        int low = 0, mid = 0, high = n-1;    // initially unsorted whole array 
        while(mid <= high){
            if (nums[mid] == 0){
                swap(nums,mid, low);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else {
                swap (nums,mid,high);
                high--;
            }
        }
    }
    private void swap (int []nums, int first , int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp ;
    }
}