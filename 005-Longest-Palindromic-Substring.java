//寻找字符串中最长回文 挨个找

public class Solution {
    int paStart = 0, longest = 0;
    public String longestPalindrome(String s) {
        if(s.length() < 2)
            return s;
        for(int i=0; i<s.length()-1; i++) {
            findLongest(s, i, i);
            findLongest(s, i, i+1);
        }
        return s.substring(paStart, paStart + longest);
    }
    
    public void findLongest(String s, int toLeft, int toRight) {
        while(toLeft >= 0 && toRight < s.length() && s.charAt(toLeft) == s.charAt(toRight)) {
            toLeft--;
            toRight++;
        }
        if(longest < toRight - toLeft - 1) {
            longest = toRight - toLeft - 1;
            paStart = toLeft + 1;
        }
    }
}
