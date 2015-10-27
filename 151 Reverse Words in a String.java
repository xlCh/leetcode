//将字符串中的单词颠倒一下
//O(1) space解法：先颠倒整个句子，再分别颠倒每个词

public String reverseWords(String s) {
        if(s.length() == 0)
            return "";
        String result = "";
        int i = 0;
        while(i < s.length()) {
            String word = "";
            while(i < s.length() && s.charAt(i) != ' ') {
                word += s.charAt(i++);
            }
            if(!word.equals(""))
                result = word + " " + result;
            i++;
        }
        if(result.length() == 0)
            return "";
        return result.substring(0, result.length()-1);
    }
