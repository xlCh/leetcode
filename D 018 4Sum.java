//https://leetcode.com/problems/4sum/
//四个数字的和等于target的所有list
//过滤条件特别多：https://leetcode.com/discuss/69517/7ms-java-code-win-over-100%25
//参考https://leetcode.com/discuss/32594/clean-accepted-java-o-n-3-solution-based-on-3sum
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length < 4)
            return result;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++) {
            if(nums[i]<<2 > target)
                break;
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j=i+1; j<nums.length-2; j++) {
                if(j > i+1 && nums[j] == nums[j-1])
                    continue;
                int low = j+1, high = nums.length-1;
                while(low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if(sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low+1])
                            low++;
                        while(low < high && nums[high] == nums[high-1])
                            high--;
                        low++;
                        high--;
                    }
                    else if(sum < target)
                        low++;
                    else
                        high--;
                }
            }
        }
        return result;
    }
}
