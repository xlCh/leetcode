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
