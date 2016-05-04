//https://leetcode.com/problems/repeated-dna-sequences/
//寻找重复DNA 长度为10
//高端解法
//https://leetcode.com/discuss/69939/java-28ms-solution-beats-100%25-of-java-submissions
//https://leetcode.com/discuss/24478/i-did-it-in-10-lines-of-c
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

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        Map<String, Integer> existed = new HashMap<String, Integer>();
        for(int i=0; i<=s.length()-10; i++) {
        	String temp = s.substring(i, i+10);
        	if(!existed.containsKey(temp))
        		existed.put(temp, 1);
        	else {
        		int times = existed.get(temp);
        		if(times == 1) {
        			result.add(temp);
        			existed.put(temp, times+1);
        		}
        	}
        }
        return result;
    }
