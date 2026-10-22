class Solution {
    public String removeDuplicates(String s) {
        // M-3 optimal approach  | time O(n) | space O(n)
        // intuation instead of stack we use char array 
        char[] arr = new char[s.length()];
        int top = -1;

        for (char ch : s.toCharArray()) {
            if (top >= 0 && arr[top] == ch) {
                top--;
            } else {
                arr[++top] = ch;
            }
        }
        // top + 1 is exclusive 
        return new String(arr, 0, top + 1);
    }
}