class Solution {
    public String removeKdigits(String num, int k) {
        // M -3 optimal approach (monotonic stack)| time O(n ) | space O(n)
        // use same concept of greedy but now we not again agian scan we use string builder as stack and itrate each char  digit with top element if top element is greater then remove it untill we k == 0 and  then append it and if k still > 0 then remove last digits and then remove leading zeroes 
        StringBuilder stack = new StringBuilder();

        for (char digit : num.toCharArray()) {

            while (k > 0 &&
                   stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > digit) {

                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(digit);
        }

        // If digits are in non-decreasing order,
        // remove the remaining digits from the end.
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Remove leading zeros
        int i = 0;
        while (i < stack.length() && stack.charAt(i) == '0') {
            i++;
        }

        String result = stack.substring(i);

        return result.isEmpty() ? "0" : result;
    }
}