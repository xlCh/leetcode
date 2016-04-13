//https://leetcode.com/problems/subsets-ii
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
//不需要递归的方法：https://leetcode.com/discuss/91614/share-my-2ms-java-iteration-solution-very-simple-and-short
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

//另一种方法 很慢
Set<List<Integer>> result = new HashSet<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subset(nums, new ArrayList<Integer>(), 0);
        return new ArrayList<List<Integer>>(result);
    }
    
    public void subset(int[] nums, List<Integer> already, int start) {
        if(start == nums.length) {
            result.add(new ArrayList<Integer>(already));
            return;
        }
        subset(nums, already, start+1);
        already.add(nums[start]);
        subset(nums, already, start+1);
        already.remove(already.size()-1);
    }
    
//最快的方法
List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subset(nums, new ArrayList<Integer>(), 0);
        return result;
    }
    
    public void subset(int[] nums, List<Integer> already, int start) {
        if(start <= nums.length) {
            result.add(new ArrayList<Integer>(already));
        }
        for(int i=start; i<nums.length; i++) {
            if(i != start && nums[i] == nums[i-1])
                continue;
            already.add(nums[i]);
            subset(nums, already, i+1);
            already.remove(already.size()-1);
        }
    }
