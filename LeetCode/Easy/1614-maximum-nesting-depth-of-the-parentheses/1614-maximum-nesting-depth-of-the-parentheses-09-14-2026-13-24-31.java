class Solution {
    public int maxDepth(String s) {
        // M-2 optimal approach  | time O(n) | space O(1)
        // use count var to just count nested one , when we get '(' we count++ and update depth and when ')' then count -- , hence count store no of nested ( 
        int depth = 0 ;
        int count = 0 ;
        for (char ch : s.toCharArray()){
            if (ch == '('){
                count++;
                depth = Math.max(depth , count);
            }
            if (ch == ')'){
                count-- ;
            }
        }
        return depth ;
    }
}