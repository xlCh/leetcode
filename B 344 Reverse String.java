//https://leetcode.com/problems/reverse-string/
//其他答案 https://leetcode.com/discuss/98774/many-acceptable-answers
public String reverseString(String s) {
        char[] chs = s.toCharArray();
        for(int i=0, j=chs.length-1; i<j; i++, j--) {
            char temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
        }
        return String.valueOf(chs);
    }
