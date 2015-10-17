//和为目标的数字组合 要求不能重复（candidates本身可能有重复）

public class Solution {
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combination(list, candidates, target, 0);
        return result;
    }
    
    public void combination(List<Integer> tempList, int[] candidates, int target, int start) {
        if(target == 0) {
            result.add(tempList);
            return;
        }
        for(int i=start; i<candidates.length; i++) {
            if((tempList.size() != 0 && candidates[i] < tempList.get(tempList.size()-1)) || candidates[i] > target)
                continue;
            List<Integer> newList = new ArrayList<Integer>(tempList);
            if(i != start && candidates[i] == candidates[i-1])
                continue;
            else if(target >= candidates[i]) {
                newList.add(candidates[i]);
                combination(newList, candidates, target-candidates[i], i+1);
            }
        }
    }
}
