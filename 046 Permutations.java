//数组排列的所有情况

public class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new ArrayList<Integer>();
        for(int num : nums)
            numsList.add(num);
        getPermute(numsList, new ArrayList<Integer>(), nums.length);
        return result;
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
