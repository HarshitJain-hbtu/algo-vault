class Solution {
    public String removeOuterParentheses(String s) {
        // time O(n) and space O(n)
        StringBuilder result = new StringBuilder();  
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            // If we encounter '(', push inside stack
            if (ch == '(') {
                // If we're inside a primitive, add '(' to result
                if (stack.size() > 0){
                    result.append(ch);
                }
                stack.push(ch);
            } 
            // If we encounter ')', pop from stack
            else if (ch == ')') {
                // Decrease the nesting level for ')'
                stack.pop(); 
                // If we're inside a primitive, add ')' to result
                if (stack.size() > 0) {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }
}