//https://leetcode.com/problems/remove-element/
//移除值为val的元素，并返回移除后vector的size
int removeElement(vector<int>& nums, int val) {
        int valNum = 0;
        for(int i=0, j=0; i<nums.size(); i++) {
            if(nums[i] == val) {
                valNum++;
            }
            else if(j+valNum < nums.size())
                nums[j] = nums[(j++)+valNum];
        }
        return nums.size() - valNum;
    }
    
//最快的方法 java
public int removeElement(int[] nums, int val) {
        if(nums.length == 0)
            return 0;
        int slow = 0, fast = nums.length-1;
        while(slow < fast) {
            while(slow < fast && nums[slow] != val)
                slow++;
            while(fast > slow && nums[fast] == val)
                fast--;
            if(fast == slow) {
                return nums[slow] == val ? slow : slow+1;
            }
            nums[slow] = nums[fast];
            nums[fast] = val;
        }
        return nums[slow] == val ? slow : slow+1;
    }
