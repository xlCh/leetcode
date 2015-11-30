//数组的所有排列次序（有重复元素 不允许重复）
//仅对Permutation做简单修改 时间慢
//https://leetcode.com/discuss/58270/short-fast-recursive-solution-understand-with-explaination

public class Solution {
    private Set<List<Integer>> result = new HashSet<List<Integer>>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> numsList = new ArrayList<Integer>();
        for(int num : nums)
            numsList.add(num);
        getPermute(numsList, new ArrayList<Integer>(), nums.length);
        return new ArrayList(result);
    }
    
    public void getPermute(List<Integer> nums, List<Integer> already, int size) {
        if(size == already.size()) {
            result.add(already);
            return;
        }
        for(int i=0; i<nums.size(); i++) {
            List<Integer> nums2 = new ArrayList<Integer>(nums);
            List<Integer> current = new ArrayList<Integer>(already);
            current.add(nums2.get(i));
            nums2.remove(i);
            getPermute(nums2, current, size);
        }
    }
}
