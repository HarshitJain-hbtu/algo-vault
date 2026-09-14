class Solution {
    public int findKthLargest(int[] nums, int k) {
        // M-2 using minHeap | time O(n * log k) bcz we process n ele and each insert takes log k time | space O(k)
        // intuation is maintain only the k largest elements instead of add all n elm and then remove n-k ele 
        int n = nums.length;
        PriorityQueue <Integer> minheap = new PriorityQueue<>();
        for (int num : nums){
            minheap.offer(num);

            if (minheap.size() > k){
                minheap.poll();
            }
        }
        // we return smallest among our current k largest elements at the top
        return minheap.peek();
    }
}