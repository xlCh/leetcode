//https://leetcode.com/problems/3sum/
//找出数组中所有和为0的三个数
//注意可能重复的情况
//https://leetcode.com/discuss/97292/6ms-99-92%25-hashmaps-and-no-sorting-but-may-require-lot-of-space
//可用do while https://leetcode.com/discuss/96528/java-solution-beats-92-68%25
 public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length;) {
            int start = i+1, end = nums.length-1, temp = nums[i];
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int temp1 = nums[start], temp2 = nums[end];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while(start < end && nums[start] == temp1) start++;
                    while(start < end && nums[end] == temp2) end--;
                }
                else if(sum < 0) {
                    while(start < end && nums[start] == temp1) start++;
                }
                else {
                    while(start < end && nums[end] == temp2) end--;
                }
            }
            while(i<nums.length && nums[i] == temp) i++;
        }
        return result;
    }
