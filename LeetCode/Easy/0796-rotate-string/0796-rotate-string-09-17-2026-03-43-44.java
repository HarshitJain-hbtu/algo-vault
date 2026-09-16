class Solution {
    public boolean rotateString(String s, String goal) {
        // M-2  better approach | time O(n * n) | space O(1)
        if (s.length() != goal.length()){
            return false;
        }
        if (s.equals(goal)){
            return true;
        }
        int n = s.length();
        
        // if char of s match with first char of goal then check
        for (int i = 0 ;i < n ; i++){
            if (s.charAt(i) != goal.charAt(0)){
                continue;
            }
            boolean match = true;
            // now check s from i index that it can conv into goal or not
            for (int j = 0 ; j < n ; j++){
                if (s.charAt((j + i) % n) != goal.charAt(j)){
                    match = false;
                    break;
                } 
            }

            if (match){
                return true;
            }
        }
        return false;
    }
}