//Gray Code
//https://en.wikipedia.org/wiki/Gray_code

public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        int one = 1;
        for(int i=1; i<=n; i++) {
            for(int j=result.size()-1; j>=0; j--) {
                result.add(result.get(j) | one);
            }
            one = one << 1;
        }
        return result;
    }
