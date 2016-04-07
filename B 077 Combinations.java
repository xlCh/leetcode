//https://leetcode.com/problems/combinations/
//从n个中选取k个的组合

public class Solution {
    private List<List<Integer>> results = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> result = new ArrayList<Integer>();
        combineNums(result, 1, n, k);
        return results;
    }
    
    public void combineNums(List<Integer> result, int start, int n, int k) {
        if(k == 0) {
            results.add(result);
            return;
        }
        for(int i=start; i<=n; i++) {
            List<Integer> newResult = new ArrayList<Integer>(result);
            newResult.add(i);
            combineNums(newResult, i+1, n, k-1);
        }
    }
}

//更快的方法
public class Solution {
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combine(int n, int k) {
        combine(new ArrayList<Integer>(), n, k, 1);
        return result;
    }
    
    public void combine(List<Integer> already, int n, int k, int now) {
        if(already.size() == k) {
            result.add(new ArrayList(already));
            return;
        }
        for(int i=now; i<=n; i++) {
                already.add(i);
                combine(already, n, k, i+1);
                already.remove(already.size()-1);
        }
    }
}
