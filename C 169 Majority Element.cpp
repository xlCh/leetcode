//https://leetcode.com/problems/majority-element/
//找出个数大于⌊n/2⌋的元素
//这种解法时间略长，此题有多种解法可参考
int majorityElement(vector<int>& nums) {
        int i = 0;
        map<int, int> elementMap;
        int size = nums.size();
        for(int i=0; i<size; i++) {
            if(elementMap.find(nums[i]) != elementMap.end())
                elementMap[nums[i]]++;
            else
                elementMap[nums[i]] = 1;
            if(elementMap[nums[i]] >= (size+1) / 2)
                return nums[i];
        }
        return 0;
    }

//时间短的解法，还有一种基于栈的 和这种方法类似
public int majorityElement(int[] nums) {
        if(nums.length == 0)
            return 0;
        int candidate = nums[0];
        int count = 1;
        for(int i=1; i<nums.length; i++) {
            if(count == 0) {
                candidate = nums[i];
                count = 1;
            }
            else if(nums[i] == candidate)
                count++;
            else
                count--;
        }
        
        return candidate;
    }
//后面可以重新for循环验证一下
