//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
//从有序数组中移除重复元素（重复次数>2），返回数组长度
//思考：允许重复k次，写一个一般化的代码 https://leetcode.com/discuss/93021/time-and-java-solution-when-allowed-at-most-times-duplicates

public int removeDuplicates(int[] nums) {
        int low = 0;
        for(int high=0; high<nums.length; ) {
            nums[low++] = nums[high];
            int temp = nums[high++];
            if(high<nums.length && nums[high] == nums[high-1]) {
                nums[low++] = nums[high++];
                while(high < nums.length && nums[high] == temp) {
                    high++;
                }
            }
        }
        return low;
    }

//有些差异
public int removeDuplicates(int[] nums) {
        if(nums.length <= 2)
            return nums.length;
        int slow = 0, fast = 0;
        while(fast < nums.length) {
            if(fast + 2 < nums.length && nums[fast] == nums[fast+1] && nums[fast+1] == nums[fast+2]) {
                int temp = nums[fast];
                while(fast + 1 < nums.length && nums[fast] == nums[fast+1])
                    fast++;
                nums[slow++] = temp;
                nums[slow++] = temp;
            }
            else {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
