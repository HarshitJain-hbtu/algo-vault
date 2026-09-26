class Solution {
    //M -3 optimal approach (by these two checks we not able to generate any invalid string hence no need of invalid function )
    // we can also solve using stringbuilder it takes less memory bcz here we actually backtrack | no new string objects creates again and again
    //T.C : O((2^(2n)) -> Removing constant -> O(n * (2^2n))
    //S.C : O(2*n) -> Removing constant -> O(n) -> recursion stack space - Max depth of recusion tree
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        generate(0, 0, n,sb);
        return result;
    }
    private void generate(int open , int close ,int n , StringBuilder curr){
        if (curr.length() == 2 * n){
            result.add(curr.toString());
            return ;
        }
        if (open < n){
            curr.append('(');
            generate(open + 1, close , n , curr);
            curr.deleteCharAt(curr.length() - 1);
        }
        
        if (close < open){
            curr.append(')');
            generate(open ,close + 1, n , curr);
            curr.deleteCharAt(curr.length() - 1);
        } 
    }
}