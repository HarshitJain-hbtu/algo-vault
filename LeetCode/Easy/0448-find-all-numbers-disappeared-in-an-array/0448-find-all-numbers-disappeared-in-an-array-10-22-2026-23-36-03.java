class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // M - 2 better appraoch (instead of set we use extra array) | time O(n) | space O(n)
        int n = nums.length;
        int [] arr = new int [n+1];
        for (int num : nums){
            arr[num]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            if (arr[i] == 0){
                result.add(i);
            }
        }
        return result;
    }
}