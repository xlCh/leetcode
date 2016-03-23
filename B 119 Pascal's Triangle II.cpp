//https://leetcode.com/problems/pascals-triangle-ii/
//获取rowIndex处的list
//最快的方法（利用对称特性）：https://leetcode.com/discuss/86872/java-o-k-7lines-1ms-beats-86%25
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<=rowIndex; i++) {
            result.add(1);
            for(int j=i-1; j>=1; j--) {
                result.set(j, result.get(j) + result.get(j-1));
            }
        }
        return result;
    }
