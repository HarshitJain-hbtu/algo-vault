class Solution {
    public boolean isPalindrome(String s) {
        // M -1  brut approach | time O(n) & space O(n)
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()){
            if (ch >= 'a' && ch <= 'z'){
                sb.append(ch);
            }else if (ch >= 'A' && ch <= 'Z'){
                sb.append(Character.toLowerCase(ch));
            } else if (ch >= '0' && ch <= '9') {
                sb.append(ch);  
            }
        }
        int i = 0;
        int j = sb.length() -1;
        while (i < j){
            if(sb.charAt(i) != sb.charAt(j)){
                return false;
            }
            i++ ;
            j-- ;
        }
        return true;
    }
}