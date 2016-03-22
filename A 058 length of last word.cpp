//https://leetcode.com/problems/length-of-last-word/
//判断最后一个词的长度 注意字符串末尾可能的空格
public int lengthOfLastWord(String s) {
        if(s.isEmpty())
            return 0;
        int i;
        int lastEnd = s.length()-1;
        while(lastEnd >= 0 && s.charAt(lastEnd) == ' ')
            lastEnd--;
        for(i = lastEnd; i>=0; i--) {
            if(s.charAt(i) == ' ')
                break;
        }
        return lastEnd-i;
    }
