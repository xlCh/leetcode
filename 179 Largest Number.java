//用数字组成最大的数（排序的一种）

public String largestNumber(int[] nums) {
        List<String> numStrs = new ArrayList<String>();
        for(int i=0; i<nums.length; i++) {
            numStrs.add("" + nums[i]);
        }
        Collections.sort(numStrs, (a, b)-> {
            String s1 = a + b;
            String s2 = b + a;
            return s2.compareTo(s1);
        });
        int i=0;
        while(i<nums.length && numStrs.get(i).equals("0"))
            i++;
        StringBuffer result = new StringBuffer();
        for(int j=i; j<numStrs.size(); j++) {
            result.append(numStrs.get(j));
        }
        return result.length() == 0?"0":result.toString();
    }
