class Solution {
    // Brut force (intuation generate all substrings and check is vaild) 
    //T.C : O(2n* (2^(2n)) -> Removing constant -> O(n * (2^2n))
    //S.C : O(2*n) -> Removing constant -> O(n) -> recursion stack space - Max depth of recusion tree
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(0 , n , "");
        return result;
    }
    private void generate(int i , int n , String curr){
        if (i == 2 * n){
            if (isValid(curr)){
                result.add(curr);
            }
            return ;
        }

        curr = curr + "(";
        generate(i+1 , n , curr);

        // backtrack (removing last added  char)
        curr = curr.substring(0, curr.length() - 1);
        curr = curr + ")";
        generate(i + 1, n , curr);
        
    }
    private boolean isValid(String s){
        int count = 0 ; 
        
        for (char ch : s.toCharArray()){
            if (ch == '('){
                count++;
            }
            else{
                count--;
                if (count < 0){
                    return false;
                }
            }
        }
        return count == 0 ;
    }
}