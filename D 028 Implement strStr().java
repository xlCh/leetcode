//https://leetcode.com/problems/implement-strstr/
//字符串查找
//KMP https://leetcode.com/discuss/97231/java-kmp-solution-5ms
//Boyer-Moore方法更高效 此外还有Rabin Karp算法
//最普通的比较方法 （更简洁：https://leetcode.com/discuss/101183/3-lines-java-codes-and-beats-33%25-easy-understantd）
public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        for(int i=0; i<=haystack.length()-needle.length(); i++) {
            if(haystack.charAt(i) != needle.charAt(0))
                continue;
            int pointer = 1;
            while(pointer < needle.length() && haystack.charAt(i+pointer) == needle.charAt(pointer))
                pointer++;
            if(pointer == needle.length())
                return i;
        }
        return -1;
    }
