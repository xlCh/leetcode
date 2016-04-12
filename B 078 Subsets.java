//https://leetcode.com/problems/subsets/
//某个数组的所有子集

//基本上有三类解决方法：https://leetcode.com/discuss/88036/share-my-several-c-solutions-easy-to-understand

public class Solution {
    private List<List<Integer>> results = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        subset(new ArrayList<Integer>(), 0, nums);
        return results;
    }
    
    public void subset(List<Integer> result, int start, int[] nums) {
        results.add(result);
        for(int i=start; i<nums.length; i++) {
            List<Integer> newResult = new ArrayList<Integer>(result);
            newResult.add(nums[i]);
            subset(newResult, i+1, nums);
        }
    }
}

//稍有些不一样
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> subsets(int[] nums) {
	    Arrays.sort(nums);
        subsets(nums, new ArrayList<Integer>(), 0);
        return result;
    }
	
	public void subsets(int[] nums, List<Integer> already, int start) {
		if(start == nums.length){
			result.add(new ArrayList<Integer>(already));
			return;
		}
		subsets(nums, already, start+1);
		already.add(nums[start]);
		subsets(nums, already, start+1);
		already.remove(already.size()-1);
	}
