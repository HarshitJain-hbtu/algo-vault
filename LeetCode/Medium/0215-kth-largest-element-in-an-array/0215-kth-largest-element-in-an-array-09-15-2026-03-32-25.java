class Solution {
    public int findKthLargest(int[] nums, int k) {
        // M-2 using maxheap | Time  → O(n + k log n) |  space O(k)
        // intuation is add all n elm and then remove n-k ele 
        int n = nums.length;
        PriorityQueue <Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums){
            maxheap.offer(num);
        }
        // now remove k-1 ele so kth largest at top
        for (int i = 0 ; i < k-1 ;i++){
            maxheap.poll();
        }
        return maxheap.peek();
    }
}