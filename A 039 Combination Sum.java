//https://leetcode.com/problems/combination-sum/
//给出目标整数，求所有和为目标的组合

public class Solution {
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<Integer>();
        combination(list, candidates, target);
        return result;
    }
    
    public void combination(List<Integer> tempList, int[] candidates, int target) {
        
        for(int i=0; i<candidates.length; i++) {
            if((tempList.size() != 0 && candidates[i] < tempList.get(tempList.size()-1)) || candidates[i] > target)
                continue;
            List<Integer> newList = new ArrayList<Integer>(tempList);
            if(candidates[i] == target) {
                newList.add(candidates[i]);
                result.add(newList);
            }
            else {
                newList.add(candidates[i]);
                combination(newList, candidates, target-candidates[i]);
            }
        }
    }
}

//先排序再求解
List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combination(candidates, new ArrayList<Integer>(), 0, target);
        return result;
    }
    
    public void combination(int[] candidates, List<Integer> already, int start, int target) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(already));
            return;
        }
        for(int i=start; i<candidates.length; i++) {
            if(candidates[i] > target)
                break;
            already.add(candidates[i]);
            combination(candidates, already, i, target - candidates[i]);
            already.remove(already.size()-1);
        }
    }
