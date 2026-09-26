class Solution {
    //optimal approach (by these two checks we not able to generate any invalid string hence no need of invalid function ) 
    //T.C : O((2^(2n)) -> Removing constant -> O(n * (2^2n))
    //S.C : O(2*n) -> Removing constant -> O(n) -> recursion stack space - Max depth of recusion tree
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(0 , 0 , n , "");
        return result;
    }
    private void generate(int open , int close ,int n , String curr){
        if (curr.length() == 2 * n){
            result.add(curr);
            return ;
        }
        if (open < n){
            curr = curr + "(";
            generate(open + 1, close , n , curr);
            curr = curr.substring(0, curr.length() - 1);
        }
        
        if (close < open){
            curr = curr + ")";
            generate(open ,close + 1, n , curr);
        } 
    }
}