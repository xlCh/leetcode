//将字母相同的单词归类（类别中需要按单词顺序排）

public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        Map<String, List<String>> mapping = new HashMap<String, List<String>>();
        for(int i=0; i<strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String tempStr = String.valueOf(temp);
            if(!mapping.containsKey(tempStr))
                mapping.put(tempStr, new ArrayList<>());
            mapping.get(tempStr).add(strs[i]);
        }
        return new ArrayList<List<String>>(mapping.values());
    }
