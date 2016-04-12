//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//手机键盘上数字可能的字母组合

String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new ArrayList<String>();
    
    public List<String> letterCombinations(String digits) {
        getResult(digits, "");
        return result;
    }
    
    public void getResult(String digits, String already) {
        if(digits.length() == 0) {
            if(!already.equals(""))
                result.add(already);
            return;
        }
        String letter = mapping[digits.charAt(0) - '0'];
        if(letter.length() == 0)
            getResult(digits.substring(1), already);
        for(int i=0; i<letter.length(); i++) {
            getResult(digits.substring(1), already+letter.charAt(i));
        }
    }

//另一种
List<String> result = new ArrayList<String>();
    
    String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() != 0)
            combination(digits, 0, new StringBuilder());
        return result;
    }
    
    public void combination(String digits, int start, StringBuilder sb) {
        if(start == digits.length()) {
            if(sb.length() == digits.length())
                result.add(sb.toString());
            return;
        }
        for(int i=start; i<digits.length(); i++) {
            String mapping = letters[digits.charAt(i)-'2'];
            for(int j=0; j<mapping.length(); j++) {
                sb.append(mapping.charAt(j));
                combination(digits, i+1, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
