//https://leetcode.com/problems/roman-to-integer/
//将罗马数字转换为阿拉伯数字

//用map慢一些
public int romanToInt(String s) {
        Map<Character, Integer> mapping = new HashMap<Character, Integer>();
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(i != s.length()-1 && mapping.get(s.charAt(i)) < mapping.get(s.charAt(i+1))) {
                count -= mapping.get(s.charAt(i));
            }
            else {
                count += mapping.get(s.charAt(i));
            }
        }
        return count;
    }
    
    //另一种解法，getNum函数略 思路不太一样
     public int romanToInt(String s) {
        int result = 0;
        int i;
        for(i=s.length()-1; i>0; i--) {
            int ati = getNum(s.charAt(i));
            int ati_1 = getNum(s.charAt(i-1));
            if(ati > ati_1)  {
                result += (ati - ati_1);
                i--;
            }
            else
                result += ati;
        }
        if(i == 0)
            result += getNum(s.charAt(0));
        return result;
        
    }
