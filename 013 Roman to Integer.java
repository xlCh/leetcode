//将罗马数字转换为阿拉伯数字

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
