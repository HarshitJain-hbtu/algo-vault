class Solution {
    public int maxDepth(String s) {
        // M-1 using stack | time O(n) | space O(n)
        int depth = 0 ;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()){
            if (ch == '('){
                stack.push('(');
                depth = Math.max(depth , stack.size());
            }
            if (ch == ')'){
                stack.pop();
            }
        }
        return depth ;
    }
}