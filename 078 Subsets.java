//某个数组的所有子集

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
