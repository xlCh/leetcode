//求子集
//例如对于[1,2,2]，得到
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]

public class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        getSubsets(nums, 0, new ArrayList<Integer>(), false);
        return result;
    }
    
    public void getSubsets(int[] nums, int start, List<Integer> already, boolean hasLast) {
        if(start == nums.length) {
            result.add(already);
            return;
        }
        List<Integer> donotHasThis = new ArrayList<Integer>(already);
        List<Integer> hasThis = new ArrayList<Integer>(already);
        hasThis.add(nums[start]);
        getSubsets(nums, start+1, donotHasThis, false);
        if(hasLast || !(start > 0 && nums[start] == nums[start-1]))
            getSubsets(nums, start+1, hasThis, true);
    }
}
