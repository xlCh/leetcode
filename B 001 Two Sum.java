//https://leetcode.com/problems/two-sum/
//nums中有两个数字和为target，返回这两个数字的索引
//一次循环  另一种方法为先排序再查找
//还有一种（卡范围） https://leetcode.com/discuss/92446/java-2ms-solution-no-hashmaps-2-simple-loops
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++) {
            if(numMap.containsKey(target-nums[i])) {
                result[0] = i;
                result[1] = numMap.get(target-nums[i]);
                return result;
            }
            numMap.put(nums[i], i);
        }
        return result;
    }
