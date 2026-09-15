class Solution {
    public String reverseWords(String s) {
        // M-2 more optimal | time O(n)  | space O(n) 
        // now we not use strip() , replaceAll fn , and not creates several intermediate object
        StringBuilder sb = new StringBuilder();
        int i = s.length() -1;

        while (i >= 0){
            // removing trailing spaces 
            while (i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            // now i at end of word
            if (i < 0){
                break;
            }
            int end = i ;

            // now find the starting of word
            while(i >= 0 &&  s.charAt(i) != ' '){
                i--;
            }
            // now i+1 is begining of word
            if (sb.length() != 0){
                sb.append(" ");
            }
            sb.append(s,i+1 ,end + 1); // execlusive
        }
        return sb.toString();
    }
}