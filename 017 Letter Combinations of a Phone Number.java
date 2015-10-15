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
