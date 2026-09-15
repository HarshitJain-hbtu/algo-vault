class Solution {
    public String removeOuterParentheses(String s) {
        // time O(n) and space O(1)
        StringBuilder result = new StringBuilder();  
        int level = 0;  

        for (char ch : s.toCharArray()) {
            // If we encounter '(', increase the level
            if (ch == '(') {
                // If we're inside a primitive, add '(' to result
                if (level > 0) {
                    result.append(ch);
                }
                level++; 
            } 
            // If we encounter ')', decrease the level
            else if (ch == ')') {
                // Decrease the nesting level for ')'
                level--;  
                // If we're inside a primitive, add ')' to result
                if (level > 0) {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }
}