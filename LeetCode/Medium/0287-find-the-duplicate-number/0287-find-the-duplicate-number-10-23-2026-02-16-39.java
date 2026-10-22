class Solution {
    public int findDuplicate(int[] nums) {
        // M-2 better approach (using hashmap) | time O(n) | space O(n)
        int n = nums.length; 
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);

            if (map.get(num) > 1){
                return num;
            }
        } 
        return -1;
    }
}