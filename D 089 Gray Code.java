//https://leetcode.com/problems/gray-code/
//Gray Code
//https://en.wikipedia.org/wiki/Gray_code
//回溯解法：https://leetcode.com/discuss/74543/backtracking-c-solution
//Gi = Bi+1 xor Bi 这个公式干嘛的 https://leetcode.com/discuss/13058/share-my-simple-way-of-this-problem-_
//一般的按照对称性的解法如下：
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
