//1~9 取k个数 和为n 求所有组合

public class Solution {
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<Integer>();
        combination(list, n, k, 1);
        return result;
    }
    
    public void combination(List<Integer> tempList, int target, int k, int start) {
        if(target == 0 && k == 0) {
            result.add(tempList);
            return;
        }
        for(int i=start; i<10; i++) {
            if(i > target)
                return;
            List<Integer> newList = new ArrayList<Integer>(tempList);
            newList.add(i);
            combination(newList, target-i, k-1, i+1);
        }
    }
}
