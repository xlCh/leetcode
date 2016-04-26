//https://leetcode.com/problems/reverse-words-in-a-string/
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

//细微区别
public String reverseWords(String s) {
        List<String> words = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            if(s.charAt(i) == ' ') {
                while(i < s.length() && s.charAt(i) == ' ')
                    i++;
            }
            int start = i;
            while(i < s.length() && s.charAt(i) != ' ') {
                i++;
            }
            words.add(s.substring(start, i));
        }
        StringBuilder sb = new StringBuilder();
        for(int j=words.size()-1; j>=0; j--) {
            sb.append(words.get(j)).append(' ');
        }
        return sb.toString().trim();
    }

//利用Scanner类的巧妙解法
public String reverseWords(String s) {
    Scanner parts = new Scanner(s);

    String result = "";

    while(parts.hasNext()){
        result = parts.next() + " " + result;
    }

    return result.trim();
}
