//https://leetcode.com/problems/permutations-ii/
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
//https://leetcode.com/discuss/25279/a-simple-c-solution-in-only-20-lines 以及回复
//较快 注意copyOf那一段，不使用会出错
List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        permute(nums, 0);
        return result;
    }
    
    public void permute(int[] nums, int start) {
        if(start == nums.length-1) {
            List<Integer> temp = new ArrayList<Integer>();
            for(int num : nums)
                temp.add(num);
            result.add(temp);
            return;
        }
        for(int i=start; i<nums.length; i++) {
            if(i != start && nums[start] == nums[i])
                continue;
            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
            permute(Arrays.copyOf(nums, nums.length), start+1);
            //nums[i] = nums[start];
           // nums[start] = temp;
        }
    }
