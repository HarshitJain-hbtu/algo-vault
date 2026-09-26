class Solution {
    public boolean isValid(String s) {
        // M -2 optimal approach | time O(n) | space O(n)
        // edge case 
        if (s.length() % 2 != 0){
            return false;
        }
        
        Stack <Character> stack = new Stack<>();
        for (char ch : s.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else {
                if(ch == ')'){
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false ;
                    }
                }
                if(ch == '}'){
                    if(stack.isEmpty() || stack.pop() != '{'){
                        return false ;
                    }
                }
                if(ch == ']'){
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false ;
                    }
                }
            }
        }
        return stack.isEmpty();

    }
}