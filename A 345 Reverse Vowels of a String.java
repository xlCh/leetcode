//https://leetcode.com/problems/reverse-vowels-of-a-string/
//仅reverse元音
public String reverseVowels(String s) {
        char[] chs = s.toCharArray();
        int i = 0, j = chs.length-1;
        while(i < j) {
            while(i < j && "aeiouAEIOU".indexOf(chs[i]) == -1)
                i++;
            while(i < j && "aeiouAEIOU".indexOf(chs[j]) == -1)
                j--;
            char temp = chs[i];
            chs[i++] = chs[j];
            chs[j--] = temp;
        }
        return String.valueOf(chs);
    }
