//寻找重复DNA 长度为10
//高端解法https://leetcode.com/discuss/69939/java-28ms-solution-beats-100%25-of-java-submissions

public List<String> findRepeatedDnaSequences(String s) {
        Set<String> dnas = new HashSet<String>();
        Set<String> result = new HashSet<String>();
        if(s.length() <= 10)
            return new ArrayList<String>();
        for(int i=0; i<=s.length()-10; i++) {
            String temp = s.substring(i, i+10);
            if(!dnas.add(temp)) {
                result.add(temp);
            }
        }
        return new ArrayList<String>(result);
    }
