//https://leetcode.com/problems/word-pattern/
//判断str是否符合pattern

public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        Map<Character, String> mapping = new HashMap<Character, String>();
        if(pattern.length() != words.length)
            return false;
        for(int i=0; i<pattern.length(); i++) {
            Character ch = new Character(pattern.charAt(i));
            if(mapping.containsKey(ch)) {
                if(!words[i].equals(mapping.get(ch)))
                    return false;
            }
            else if(mapping.containsValue(words[i])) {
                return false;
            }
            else {
                mapping.put(ch, words[i]);
            }
        }
        return true;
    }
