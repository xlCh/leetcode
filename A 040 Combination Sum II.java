//https://leetcode.com/problems/combination-sum-ii/
//和为目标的数字组合 要求不能重复（candidates本身可能有重复）

List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
			if(i != start && candidates[i] == candidates[i-1])
				continue;
			if(candidates[i] > target)
			    return;
			already.add(candidates[i]);
			combination(candidates, already, i+1, target-candidates[i]);
			already.remove(already.size()-1);
		}
	}
