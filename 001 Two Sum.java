//nums中有两个数字和为target，返回这两个数字的索引
//方法比较笨 一个更好的方法是直接在第一个for循环中直接判断mapping.containsKey(target-nums[i])


public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> mapping = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            if(mapping.containsKey(nums[i])) {
                if(nums[i] * 2 == target) {
                    result[0] = mapping.get(nums[i]);
                    result[1] = i+1;
                    return result;
                }
            }
            else
        	    mapping.put(nums[i], i+1);
        }
        Arrays.sort(nums);
        int start = 0, end = nums.length-1;
        while(start < end) {
        	if(nums[start] + nums[end] < target) {
        		start++;
        	}
        	else if(nums[start] + nums[end] > target) {
        		end--;
        	}
        	else
        		break;
        }
        int index1 = mapping.get(nums[start]), index2 = mapping.get(nums[end]);
        result[0] = Math.min(index1, index2);
        result[1] = Math.max(index1, index2);
        return result;
    }
