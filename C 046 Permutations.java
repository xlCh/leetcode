//https://leetcode.com/problems/permutations/
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

//更快一点的方法
public class Solution {
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, new ArrayList<Integer>());
        return result;
    }
    
    public void permute(int[] nums, List<Integer> already) {
        if(already.size() == nums.length) {
            result.add(already);
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(!already.contains(nums[i])) {
                already.add(nums[i]);
                permute(nums, new ArrayList<Integer>(already));
                already.remove(already.size()-1);
            }
        }
    }
}

//更快，直接操作数组
public class Solution {
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);
        return result;
    }
    
    public void permute(int[] nums, int start) {
        if(start == nums.length) {
            List<Integer> temp = new ArrayList<Integer>();
            for(int num : nums)
                temp.add(num);
            result.add(temp);
            return;
        }
        for(int i=start; i<nums.length; i++) {
            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
            permute(nums, start+1);
            nums[i] = nums[start];
            nums[start] = temp;
        }
    }
}
