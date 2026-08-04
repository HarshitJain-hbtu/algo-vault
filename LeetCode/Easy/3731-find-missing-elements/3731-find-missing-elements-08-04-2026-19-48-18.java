class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        // M-1 brut force | time O(n) | space O(n)
        int min = 100;
        int max = 0 ; 
        for (int i = 0; i < nums.length;i++){
            max = Math.max (max , nums[i]);
            min = Math.min(min , nums[i]);
        }
        // now we got range from min to max
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = min ; i <= max ;i++){
            list.add(i);
        }
        for (int num : nums){
            list.remove(Integer.valueOf(num));
        }

        return list;
    }
}